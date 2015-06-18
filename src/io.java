import java.util.Scanner;

/*
 * the class to get input data and display results on the screen
 */
public class io {

	// get the variables
	public void input() {
		Scanner in = new Scanner(System.in);

		System.out.println("Please input altruism probability (0-0.5):");
		main.altProb = in.nextFloat();

		System.out.println("Please input selfish probability (0-0.5):");
		main.selfProb = in.nextFloat();

		System.out.println("Please input altruism cost (0-1):");
		main.altCost = in.nextFloat();

		System.out.println("Please input altruism benefit (0-1):");
		main.benefitFromAlt = in.nextFloat();

		System.out.println("Please input disease (0-1):");
		main.disease = in.nextFloat();

		System.out.println("Please input harshness (0-1):");
		main.harshness = in.nextFloat();
	}

	// display the number of each agent
	public void numPrint(Grid w) {
		System.out.print("A,S,E:");
		System.out.printf("%d,%d,%d", w.aNum, w.sNum, w.eNum);
		System.out.print("\n");
		System.out.print("\n");

	}

	// display the world
	public void outputWorld(Grid w) {
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				if (w.world[x][y].type == agent.a) {
					System.out.print("A" + ",");
				} else if (w.world[x][y].type == agent.s) {
					System.out.print("S" + ",");
				} else if (w.world[x][y].type == agent.e) {
					System.out.print(" " + ",");
				}
			}
			System.out.print("\n");
		}
	}
}
