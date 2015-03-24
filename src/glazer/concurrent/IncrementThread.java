package glazer.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementThread extends Thread {

	private CountDownLatch latch;
	private AtomicInteger num;
	static Semaphore semaphore=new Semaphore(1,true);

	// static Object lock=new Object();
	public IncrementThread(CountDownLatch latch,AtomicInteger num) {
		this.latch = latch;
		this.num=num;
		
	}

	@Override
	public void run() {

		for (int i = 0; i < 100000; i++) {
			// synchronized(lock){
			// num = num + 1;

			// }
			
			/*try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num++;
			semaphore.release();
			*/
			//add();
			num.incrementAndGet();
		}
		latch.countDown();
	}

	private static synchronized void add() {
		//num++;
	}

	public static void main(String args[]) {
		AtomicInteger num=new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			IncrementThread t1 = new IncrementThread(latch,num);
			t1.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}

}
