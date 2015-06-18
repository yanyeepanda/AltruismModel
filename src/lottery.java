/*
 * the class contain all the functions used in lottery 
 */
public class lottery {
	
	// lottery for setup the world
	public void setup(patch p){
		float patchType = (float) Math.random(); // use a random number between 0 and 1
		if (patchType < main.altProb){
			p.benefitOut = 1;
			p.type= agent.a;
		}
		else if (patchType < (main.altProb + main.selfProb)){
			p.benefitOut = 0;
			p.type = agent.s;
		}
		else if (patchType < 1){
			p.benefitOut = 0;
			p.type = agent.e;
		}
	}
	
	// calculate the weights for lottery
	public void weightCalc(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				w.world[x][y].fitnessSum = w.world[x][y].altFitness + w.world[x][y].selfFitness + w.world[x][y].harshFitness + main.disease;
				if (w.world[x][y].fitnessSum > 0){
					w.world[x][y].altWeight = w.world[x][y].altFitness / w.world[x][y].fitnessSum;
					w.world[x][y].selfWeight = w.world[x][y].selfFitness / w.world[x][y].fitnessSum;
					w.world[x][y].harshWeight = (w.world[x][y].harshFitness + main.disease)/ w.world[x][y].fitnessSum;
				}
				else{
					w.world[x][y].altWeight = 0;
					w.world[x][y].selfWeight = 0;
					w.world[x][y].harshWeight = 0;
				}
				
			}
		}
	}
	
	// the lottery to produce the next generation
	public void nextGeneration(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				float breedChance = (float) Math.random(); // use a random number between 0 and 1
				if (breedChance >= 0 && breedChance < w.world[x][y].altWeight){
					w.world[x][y].type = agent.a;
					w.world[x][y].benefitOut = 1;
				}
				else if (breedChance >= w.world[x][y].altWeight && breedChance < (w.world[x][y].altWeight + w.world[x][y].selfWeight)){
					w.world[x][y].type = agent.s;
					w.world[x][y].benefitOut = 0;
				}
				else {
					w.world[x][y].type = agent.e;
					w.world[x][y].benefitOut = 0;
					w.world[x][y].fitness = 0;
					w.world[x][y].altFitness = 0;
					w.world[x][y].selfFitness = 0;
					w.world[x][y].harshFitness = 0;
					w.world[x][y].altWeight = 0;
					w.world[x][y].selfWeight = 0;
					w.world[x][y].harshWeight = 0;
				}
				
			}
		}
	}
	
	// clear the weights after used
	public void clearWeight(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				w.world[x][y].altWeight = 0;
				w.world[x][y].selfWeight = 0;
				w.world[x][y].harshWeight = 0;
			}
		}
	}

}
