
/*
 * the class of patch
 * including the attributes that one agent should have
 */
public class patch implements Cloneable{
	public int benefitOut; //whether the  patch will give out benefit
	public int benefOutNeighb; //benefit out from neighbor
	
	public agent type; //the type of agent (a,s,e)
	
	public float altBenefit; //one patch's benefit from its neighbour
	public float fitness; //one patch's fitness
	
	public float selfFitness; //one patch's selfish fitness
	public float altFitness; //one patch's altruistic fitness
	public float harshFitness; //one patch's harsh fitness
	
	public float selfWeight; //one patch's selfish weight for lottery
	public float altWeight; //one patch's altruistic weight for lottery
	public float harshWeight; //one patch's harshness weight for lottery
	
	public float fitnessSum; // the sum of 3 kinds of fitness of the patch
	
	//for the initialization of each patch
	protected Object clone() throws CloneNotSupportedException { 
		return super.clone();
	}
}
