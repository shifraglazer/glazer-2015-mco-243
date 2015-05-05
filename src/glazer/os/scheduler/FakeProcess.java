package glazer.os.scheduler;


public class FakeProcess {

	int priority;
	int timeToCompletion;
	int waiting;
	int runTimeRemaining;
	int number;
	public FakeProcess(int timeToCompletion, int priority,int number) {
		waitingIncrease.run();
		waiting = 0;
		this.number=number;
		this.timeToCompletion = timeToCompletion;
		this.priority = priority;
		if(timeToCompletion>0){
		priority = (waiting + timeToCompletion) / timeToCompletion;
		}
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


	private Runnable waitingIncrease = new Runnable() {

		@Override
		public void run() {
			if (runTimeRemaining == 0) {
				waiting++;
			} else {
			waiting=0;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	};
}
