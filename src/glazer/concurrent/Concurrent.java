package glazer.concurrent;

import java.util.concurrent.CountDownLatch;

public class Concurrent {


	private CountDownLatch latch;

	public Concurrent() {
		latch = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			IncrementThread t1 = new IncrementThread(latch);
			t1.start();
		}
		try {
			latch.await();
			System.out.println(IncrementThread.num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static void main(String args[]) {
	
		CountDownLatch latch = new CountDownLatch(10);
		System.out.println(IncrementThread.num);
	}


}
