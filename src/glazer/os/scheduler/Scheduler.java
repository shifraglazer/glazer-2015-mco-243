package glazer.os.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	final static int QUANTUM=10;
	List<FakeProcess> list;
	SchedulerAlgorithm algorithm;
	
	public Scheduler(SchedulerAlgorithm algorithm){
		list=new ArrayList<>();
		this.algorithm=algorithm;
	}
	
	public void run(){
		while(true){
			FakeProcess process=algorithm.getNextProcess(list);
			list.remove(process);
			process.run(QUANTUM);
			if(process.isStillRunning()){
				list.add(process);
			}
		}
	}
}
