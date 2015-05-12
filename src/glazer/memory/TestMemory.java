package glazer.memory;

import org.junit.Test;

public class TestMemory {

	@Test
	public void testMemory() {
		FirstFit fit=new FirstFit();
		MemoryManager manager=new MemoryManager(900,fit);
		try {
			manager.allocate(9, 100);
			manager.allocate(8, 32);
			manager.allocate(2, 28);
			manager.allocate(1, 200);
		} catch (OutOfMemoryException e) {
			System.out.println(e.getMessage());
		}
	
		manager.print();
	}

}
