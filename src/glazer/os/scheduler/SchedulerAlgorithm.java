package glazer.os.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {

	//gives back next process on list
	FakeProcess getNextProcess(List<FakeProcess> list);
}
