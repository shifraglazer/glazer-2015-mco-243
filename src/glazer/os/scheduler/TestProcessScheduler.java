package glazer.os.scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProcessScheduler {
	@Test
	public void testDynamicPriority() {
		long startTime=System.currentTimeMillis();
		DynamicPriorityScheduler processor=new DynamicPriorityScheduler();
		Scheduler scheduler=new Scheduler(processor);
		try {
			scheduler.run();
			System.out.println(scheduler.listSize());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Time elapsed DynamicPriorityScheduler "+ (endTime-startTime));
	}
	
	@Test
	public void testFIFO() {
		long startTime=System.currentTimeMillis();
		FIFOProcessor processor=new FIFOProcessor();
		Scheduler scheduler=new Scheduler(processor);
		try {
			scheduler.run();
			System.out.println(scheduler.listSize());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Time elapsed FIFO "+ (endTime-startTime));
	}

	@Test
	public void testSPFS() {
		long startTime=System.currentTimeMillis();
		SPFScheduler processor=new SPFScheduler();
		Scheduler scheduler=new Scheduler(processor);

		try {
			scheduler.run();
			System.out.println(scheduler.listSize());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Time elapsed SPFScheduler "+ (endTime-startTime));
	}

}
