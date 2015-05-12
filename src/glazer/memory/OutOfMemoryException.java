package glazer.memory;

public class OutOfMemoryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OutOfMemoryException(){
		super("Memory full. Unable to allocate storage space.");
	}

}
