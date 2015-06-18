/*
 * the class contain all the functions about fitness calculations
 */
public class fitness {
	
	//calculate the number of altruism in the neighbors
	public void sumBenefOutNeighb(Grid w) {
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				w.world[x][y].benefOutNeighb 
						= w.world[(x + 1 + Grid.SIZE) % Grid.SIZE][y].benefitOut
						+ w.world[(x - 1 + Grid.SIZE) % Grid.SIZE][y].benefitOut
						+ w.world[x][(y + 1 + Grid.SIZE) % Grid.SIZE].benefitOut
						+ w.world[x][(y - 1 + Grid.SIZE) % Grid.SIZE].benefitOut;
			}
		}
	}

	//calculate the benefit that the patch can get
	public void benefitCalc(Grid w) {
		for (int y = 0; y < Grid.SIZE; y++) {
			for (int x = 0; x < Grid.SIZE; x++) {
				w.world[x][y].altBenefit = main.benefitFromAlt * (w.world[x][y].benefitOut + w.world[x][y].benefOutNeighb) / 5;
			}
		}
	}
	
	//calculate the fitness of the patch
	public void fitnessCalc(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				switch (w.world[x][y].type) {
		        case a:
		        	w.world[x][y].fitness = 1 - main.altCost + w.world[x][y].altBenefit;
		            break;
		        case s:
		        	w.world[x][y].fitness = 1 + w.world[x][y].altBenefit;
		            break;
		        case e:
		        	w.world[x][y].fitness = main.harshness;
		            break;
				}	
			}
		}
	}
	
	//record the patch's fitness according to its type
	public void fitnessRecord(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				switch (w.world[x][y].type) {
		        case a:
		        	w.world[x][y].altFitness = w.world[x][y].fitness;
		            break;
		        case s:
		        	w.world[x][y].selfFitness = w.world[x][y].fitness;
		            break;
		        case e:
		        	w.world[x][y].harshFitness = w.world[x][y].fitness;
		            break;
				}	
			}
		}		
	}
	
	//update the patch's fitness from its 4 neighbors
	public void updateFitnessNeighb(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				switch (w.world[(x+1+Grid.SIZE)%Grid.SIZE][y].type) {
		        case a:
		            w.world[x][y].altFitness = w.world[x][y].altFitness + w.world[(x+1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
		        case s:
		        	w.world[x][y].selfFitness = w.world[x][y].selfFitness + w.world[(x+1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
		        case e:
		        	w.world[x][y].harshFitness = w.world[x][y].harshFitness + w.world[(x+1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
				}
				
				switch (w.world[(x-1+Grid.SIZE)%Grid.SIZE][y].type) {
		        case a:
		            w.world[x][y].altFitness = w.world[x][y].altFitness + w.world[(x-1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
		        case s:
		        	w.world[x][y].selfFitness = w.world[x][y].selfFitness + w.world[(x-1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
		        case e:
		        	w.world[x][y].harshFitness = w.world[x][y].harshFitness + w.world[(x-1+Grid.SIZE)%Grid.SIZE][y].fitness;
		            break;
				}
				
				switch (w.world[x][(y+1+Grid.SIZE)%Grid.SIZE].type) {
		        case a:
		            w.world[x][y].altFitness = w.world[x][y].altFitness + w.world[x][(y+1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
		        case s:
		        	w.world[x][y].selfFitness = w.world[x][y].selfFitness + w.world[x][(y+1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
		        case e:
		        	w.world[x][y].harshFitness = w.world[x][y].harshFitness + w.world[x][(y+1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
				}
				
				switch (w.world[x][(y-1+Grid.SIZE)%Grid.SIZE].type) {
		        case a:
		            w.world[x][y].altFitness = w.world[x][y].altFitness + w.world[x][(y-1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
		        case s:
		        	w.world[x][y].selfFitness = w.world[x][y].selfFitness + w.world[x][(y-1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
		        case e:
		        	w.world[x][y].harshFitness = w.world[x][y].harshFitness + w.world[x][(y-1+Grid.SIZE)%Grid.SIZE].fitness;
		            break;
				}
				
			}
		}
		
	}

	//clear the fitness
	public void clearFitness(Grid w){
		for (int y = 0; y < Grid.SIZE; y++){
			for (int x = 0; x < Grid.SIZE; x++){
				w.world[x][y].altFitness = 0;
				w.world[x][y].selfFitness = 0;
				w.world[x][y].harshFitness = 0;
			}
		}	
	}
}
