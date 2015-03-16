package glazer.download;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class Threads extends JFrame{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int count;
	private File file1;
	private File file2;
	private File file3;
	public Threads() throws MalformedURLException, InterruptedException{
		file1=new File("file1.jpg");
		file2=new File("file2.jpg");
		file3=new File("file3.jpg");
		count=0;
		Download a=new Download(this,file1,new URL("http://www.efoodsdirect.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/p/apples2.jpg"));
		a.start();
		Download b=new Download(this,file2,new URL("http://www.efoodsdirect.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/p/apples2.jpg"));
		b.start();
		Download c=new Download(this,file3,new URL("http://www.efoodsdirect.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/a/p/apples2.jpg"));
		c.start();
		do{}
		while(a.isAlive()&&b.isAlive()&&c.isAlive());
		System.out.println("finito");
		
		
	
	}
	public void finishThread(){
		count++;
		if(count==3){
		System.out.println("finished downloading");
		}
	}
	public static void main(String args[]){
		try {
			Threads thread= new Threads ();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
