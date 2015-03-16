package glazer.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Download extends Thread {

	private File file;
	private Threads thread;
	private URL url;
	public Download(Threads thread,File file, URL url){
		this.file=file;
		this.thread=thread;
		this.url=url;
	}
	@Override
	public void run(){
		
		try {
			
	
			InputStream input=url.openStream();
			
			FileOutputStream stream=new FileOutputStream(file);
			
			byte[] bytes = new byte[2048];
			int length;

			while ((length = input.read(bytes)) != -1) {
				stream.write(bytes, 0, length);
			}
			thread.finishThread();
			stream.close();
			input.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
