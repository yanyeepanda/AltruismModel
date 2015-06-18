import java.util.*;
import java.io.*;

public class main {

	/**
	 * @param args
	 */
	public static float altProb; // Altruism Probability
	public static float selfProb; // Selfish Probability
	public static float altCost; // Cost of Altruism
	public static float benefitFromAlt; // Benefit form Altruism
	public static float disease; // the possibility that the agents in occupied spots will die
	public static float harshness;// the resistance of empty patch spots to being populated by agents

	public static void main(String[] args) {
		Grid W = new Grid();
		io dataIO = new io();
		fitness fit = new fitness();
		lottery lott = new lottery();
		numList list = new numList();

		patch initP = new patch(); // initialize patch
		initP.benefitOut = 0;
		initP.benefOutNeighb = 0;

		initP.type = agent.e;

		initP.altBenefit = 0;
		initP.fitness = 0;

		initP.selfWeight = 0;
		initP.altWeight = 0;
		initP.harshWeight = 0;

		initP.selfFitness = 0;
		initP.altFitness = 0;
		initP.harshFitness = 0;

		initP.fitnessSum = 0;

		// initialize the world
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				try {
					W.world[x][y] = (patch) initP.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}

		dataIO.input(); // input 6 variables

		// setup according to altruism probability and selfish probability
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				lott.setup(W.world[x][y]);
			}
		}

		dataIO.outputWorld(W); // output the world after setup
		W.numCalc();
		dataIO.numPrint(W); // output the number of each agent
		list.aList[0] = W.aNum; // put the number of each agent in a array to
								// save as csv
		list.sList[0] = W.sNum;
		W.numClear();

		// do generation for TIME times
		for (int i = 0; i < numList.TIME; i++) {
			fit.sumBenefOutNeighb(W);
			fit.benefitCalc(W);

			fit.fitnessCalc(W);
			fit.fitnessRecord(W);
			fit.updateFitnessNeighb(W);

			lott.weightCalc(W);
			fit.clearFitness(W);
			lott.nextGeneration(W);
			lott.clearWeight(W);

			System.out.print(i + 1 + " \n");
			dataIO.outputWorld(W); // output the world after each generation
			W.numCalc(); // output the number of each agent
			dataIO.numPrint(W);
			list.aList[i + 1] = W.aNum;
			list.sList[i + 1] = W.sNum;
			W.numClear();
		}

		outputCSV csv = new outputCSV(); // save as csv file
		csv.csvName();
		csv.generateCSV(list);
	}

}
