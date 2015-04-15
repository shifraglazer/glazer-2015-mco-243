package Table;

public class Fork {

	private boolean inUse;
	private int num;

	public Fork(int num){
		this.num=num;
	}
	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
}
