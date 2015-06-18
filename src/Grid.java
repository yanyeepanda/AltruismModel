/*
 *the class of the world
	 */
public class Grid {
	public static int SIZE = 40; //the size of the world
	public patch[][] world = new patch[SIZE][SIZE]; //2D array to describe the world

	public int aNum; //the number of altruistic agent
	public int sNum; //the number of selfish agent
	public int eNum; //the number of empty patch

	//calculate the number of each agent
	public void numCalc() {
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				if (world[x][y].type == agent.a) {
					aNum++;
				} else if (world[x][y].type == agent.s) {
					sNum++;
				} else if (world[x][y].type == agent.e) {
					eNum++;
				}
			}
		}
	}
	
	//clear the number of each agent
	public void numClear() {
		aNum = 0;
		sNum = 0;
		eNum = 0;
	}
}
