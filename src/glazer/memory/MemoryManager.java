package glazer.memory;

public class MemoryManager {

	private int totalBytes;
	private char memory[][];
	private MemoryPlacementStrategy strategy;
	public MemoryManager(int totalBytes,MemoryPlacementStrategy strategy){
		this.totalBytes=totalBytes;
		this.strategy=strategy;
		memory=new char [(int)Math.floor(totalBytes/128)][128];
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				memory[i][j]='-';
			}
		}
	}
	public boolean allocate(int pid,int numBytes) throws OutOfMemoryException{
		int index=strategy.writeLocation(memory, numBytes);
		int row=(int)Math.ceil(index/memory[0].length);
		int col=index-(row*memory[0].length);
		int bytes=0;
		for(int i=row;i<memory.length;i++){
			for(int j=col;j<memory[i].length;j++){
				if(bytes==numBytes){
					return true;
				}
				else if(j==col&& i!=row){
					j=0;
				}
				memory[i][j]=(char)('0'+pid);
				bytes++;
			}
		}
		throw new OutOfMemoryException();
		}
	public boolean free(int pid){
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				if(memory[i][j]==pid){
					memory[i][j]='-';
					}
				}
			}
		return true;
	}
	public void print(){
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				System.out.print(memory[i][j]+" ");
			}
			System.out.println();
	}
	}
}
