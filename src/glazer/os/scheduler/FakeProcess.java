package glazer.os.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FakeProcess {

	int priority;
	int timeToCompletion;
	int waiting;
	int runTimeRemaining;
	int number;
	private ScheduledExecutorService execute;
	private ScheduledExecutorService waitingTime;

	public FakeProcess(int timeToCompletion, int priority,int number) {
		execute=Executors.newScheduledThreadPool(1);
		waiting = 0;
		this.number=number;
		this.timeToCompletion = timeToCompletion;
		this.priority = priority;
		if(timeToCompletion>0){
		priority = (waiting + timeToCompletion) / timeToCompletion;
		}
		waitingTime = Executors.newScheduledThreadPool(1);
		waitingTime.scheduleAtFixedRate(waitingIncrease, 0, 1,
				TimeUnit.MILLISECONDS);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public int getPriority() {
		if(timeToCompletion>0){
		priority = (waiting + timeToCompletion) / timeToCompletion;
			}
			else{
				priority=0;
			} 
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void  run(int quantum) throws InterruptedException {
		//execute.shutdown();
	//	execute = Executors.newScheduledThreadPool(1);
		 //reduce time left in process
		runTimeRemaining = quantum;
		
		if(runTimeRemaining>quantum){
			Thread.sleep(quantum);
			timeToCompletion-=quantum;
		}
		else if(runTimeRemaining>0){
			Thread.sleep(timeToCompletion);
			timeToCompletion=0;
		}
		
		
		//execute.scheduleAtFixedRate(decrease, 0, 1, TimeUnit.MILLISECONDS);
	}

	public int getRunTimeRemaining() {
		return runTimeRemaining;
	}

	public void setRunTimeRemaining(int runTimeRemaining) {
		this.runTimeRemaining = runTimeRemaining;
	}

	public int getTimeToCompletion() {
		return timeToCompletion;
	}

	public void setTimeToCompletion(int timeToCompletion) {
		this.timeToCompletion = timeToCompletion;
	}

	public boolean isStillRunning() {
		return timeToCompletion > 0;
	}

	private Runnable decrease = new Runnable() {

		@Override
		public void run() {
			if (runTimeRemaining > 0) {

				runTimeRemaining--;
				if (timeToCompletion > 0) {
					timeToCompletion--;
				}
				else{
					runTimeRemaining=0;
					execute.shutdown();
				}
			} else {
				execute.shutdown();
			}
		}

	};
	private Runnable waitingIncrease = new Runnable() {

		@Override
		public void run() {
			if (runTimeRemaining == 0) {
				waiting++;
			} else {
			waiting=0;
			}
		}

	};
}
