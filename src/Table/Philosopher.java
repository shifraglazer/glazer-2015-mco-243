package Table;

import java.util.Random;

public class Philosopher extends Thread{


	private static final Random RANDOM=new Random();
	private Fork prevFork;
	private Fork nextFork;
	private int num;
	private int prevNum;
	private int nextNum;
	private boolean eating;
	public int getNum() {
		return num;
	}

	public Philosopher getPrev() {
		return prev;
	}

	public void setPrev(Philosopher prev) {
		this.prev = prev;
		prevNum=prev.getNum();
	}

	public void setNum(int num) {
		this.num = num;
		nextNum=next.getNum();
	}

	public Philosopher getNext() {
		return next;
	}

	public void setNext(Philosopher next) {
		this.next = next;
	}

	private Philosopher prev;
	private Philosopher next;
	public Philosopher(Fork prevFork, Fork nextFork, int num){
		this.prevFork=prevFork;
		this.nextFork=nextFork;
		this.num=num;
		
	}
	
	@Override
	public void run(){
		
		while(true){	
		eat();
		think();
		}
		
	}

	public void eat(){
	//synchronize on the forks
		synchronized(prev){
			synchronized(next){
				System.out.println(num+ " is eating");
				sleepRange(500,1500);
			}
		}
		
	}
	public void sleepRange(int i,int j){
		try {
			sleep(RANDOM.nextInt(j)+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void think(){
		System.out.println(num+ " is thinking");
		sleepRange(500,1500);
		
	}
	public boolean isEating() {
		return eating;
	}

	public void setEating(boolean eating) {
		this.eating = eating;
	}
}
