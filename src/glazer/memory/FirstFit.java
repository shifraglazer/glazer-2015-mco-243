package glazer.memory;

public class FirstFit implements MemoryPlacementStrategy{

	@Override
	public int writeLocation(char[][] memory,int numBytes) {
		int index=0;
		int bytes=0;
		for(int i=0;i<memory.length;i++){
			for(int j=0;j<memory[i].length;j++){
				if(bytes==numBytes){
					return index;
				}
				else if(memory[i][j]=='-'){
					if(bytes==0){
						index=(i*memory[0].length)+j;
					}
					bytes++;
				}
				else{
					bytes=0;
					}
				}
			}
		return -1;
	}
}
