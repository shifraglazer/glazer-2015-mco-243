package glazer.os.scheduler;

import java.util.List;

public class SPFScheduler implements SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		int index=0;
		int smallestTime=10;
		for(int i=1;i<list.size();i++){
			int time=list.get(i).getTimeToCompletion();
			if(time<smallestTime){
				index=i;
				smallestTime=time;
			}
		}
		return list.get(index);
	}

}
