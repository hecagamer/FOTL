package fotl;

public enum AreaLevel 
{
	LEVEL_0(0, 0.0),
	LEVEL_1(3, 0.1),
	LEVEL_2(5, 0.4),
	LEVEL_3(6, 0.6),
	LEVEL_4(8, 0.8);
	
	private int maxIn;
	private double prob;
	
	AreaLevel(int in, double pb)
	{
		maxIn = in;
		prob = pb;
	}
	
	public int getMaxIn()
	{
		return maxIn;
	}
	
	public double getProb()
	{
		return prob;
	}
	
	//change est la valeur du changement (-1, 1)
	public AreaLevel changeLevel(int change)
    {
        change = ordinal() + change;
        change = Math.max(0, Math.min(4, change));
        
        return values()[change];
    }
}
