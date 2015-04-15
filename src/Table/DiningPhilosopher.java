package Table;

public class DiningPhilosopher {

	private Philosopher[] philosopher;
	private Fork[] forks;
	
	public DiningPhilosopher(){
		forks=new Fork[5];
		for(int i=0;i<forks.length;i++){
			forks[i]=new Fork(i);
		}
		philosopher=new Philosopher[5];
		for(int i=0;i<philosopher.length;i++){
			int prev=i;
			if(i==0){
				prev=philosopher.length;
			}
			int next=i+1;
			if(i==philosopher.length+1){
				i=0;
			}
			philosopher[i]=new Philosopher(forks[prev],forks[next],i);
		}
		for(int i=0;i<philosopher.length;i++){
			int prev=i;
			if(i==0){
				prev=philosopher.length;
			}
			philosopher[prev].setPrev(philosopher[prev]);
			int next=i+1;
			if(i==philosopher.length){
				i=0;
			}
			philosopher[next].setNext(philosopher[next]);
		}
		for(int i=0;i<4;i++){
			philosopher[i].start();
		}
	}
	public static void main(String args []){
		DiningPhilosopher phil=new DiningPhilosopher();
		
	}
}
