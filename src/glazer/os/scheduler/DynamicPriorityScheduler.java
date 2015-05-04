package glazer.os.scheduler;

import java.util.List;

public class DynamicPriorityScheduler implements SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		int index=0;
		double greatestPriority=list.get(0).getPriority();
		for(int i=1;i<list.size();i++){
			double priority=list.get(i).getPriority();
			if(priority>greatestPriority){
				index=i;
				greatestPriority=priority;
			}
		}
		return list.get(index);
	}

}
