package glazer.os.scheduler;

import java.util.List;

public class FIFOProcessor implements SchedulerAlgorithm {

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		
		return list.get(0);
	}

}
