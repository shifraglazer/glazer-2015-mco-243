package glazer.concurrent;

public class Elevator {
	private int currentFloor;
	private int requestedFloor;

	
	//not thread safe because two can call at once
	public void setRequestedFloor(int requestedFloor) {
		synchronized(this){
	
			if(!isInUse()){
				
			}
			}
		this.requestedFloor = requestedFloor;
	}


	public boolean isInUse() {
		return requestedFloor > 0;
	}
}
