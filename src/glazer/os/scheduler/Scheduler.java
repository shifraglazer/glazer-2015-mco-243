package glazer.os.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Scheduler {

	final static int QUANTUM=10;
	private int timer;
	List<FakeProcess> list;
	SchedulerAlgorithm algorithm;
	final static Random random=new Random(15);
	private ScheduledExecutorService executor;
	public Scheduler(SchedulerAlgorithm algorithm){
		executor=Executors.newSingleThreadScheduledExecutor();
		random.setSeed(12355678);
		timer=800;
		executor.scheduleAtFixedRate(time, 0,1, TimeUnit.MILLISECONDS);
		list=new ArrayList<>();
		for(int i=0;i<100;i++){
			list.add(new FakeProcess(random.nextInt(15),random.nextInt(10)+1,i+1));
		}
		this.algorithm=algorithm;
	}
	
	public void run() throws InterruptedException{
		//while(list.size()>0){
		while(timer>0){
			FakeProcess process=algorithm.getNextProcess(list);
			list.remove(process);
			//System.out.println("process#: "+process.getNumber()+" timeleft: "+process.getTimeToCompletion()+" priority: "+process.getPriority());
			process.run(QUANTUM);
			
			if(process.isStillRunning()){
				list.add(process);
			}
			
		}
	}
	public  int listSize(){
		return list.size();
	}
	public static void main(String args[]){
		long startTime;
		long endTime;
		try {
		/*
		long startTime=System.currentTimeMillis();
		FIFOProcessor processor=new FIFOProcessor();
		Scheduler scheduler=new Scheduler(processor);
		
			scheduler.run();
	
		long endTime=System.currentTimeMillis();
		System.out.println("Time elapsed FIFO "+ (endTime-startTime));

*/
		 startTime=System.currentTimeMillis();
		SPFScheduler processor2=new SPFScheduler();
		Scheduler scheduler2=new Scheduler(processor2);
		scheduler2.run();
		 endTime=System.currentTimeMillis();
		System.out.println("Time elapsed SPFScheduler "+ (endTime-startTime));

		 startTime=System.currentTimeMillis();
		DynamicPriorityScheduler processor3=new DynamicPriorityScheduler();
		Scheduler scheduler3=new Scheduler(processor3);
		scheduler3.run();
		 endTime=System.currentTimeMillis();
		System.out.println("Time elapsed DynamicPriorityScheduler "+ (endTime-startTime));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Runnable time=new Runnable(){
		@Override
		public void run(){
			timer--;
		}
	};
}
