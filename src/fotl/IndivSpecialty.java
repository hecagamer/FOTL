package fotl;

public enum IndivSpecialty 
{
	NOVICE(0.4, 0, 2, 0, 2), 
	HUNTER(0.8, 0, 2, 0, 4), 
	GUARDIAN(0.4, 2, 4, 1, 2),
	FIGHTER(0.6, 1, 3, 2, 4);
	
	private double hunt;
	private int defMin;
	private int defMax;
	private int atkMin;
	private int atkMax;
	
	IndivSpecialty(double h, int dMin, int dMax, int aMin, int aMax) 
	{
		hunt = h;
		defMin = dMin;
		defMax = dMax;
		atkMin = aMin;
		atkMax = aMax;
	}

	public double getHunt() 
	{
		return hunt;
	}

	public int getDefMin() 
	{
		return defMin;
	}

	public int getDefMax() 
	{
		return defMax;
	}

	public int getAtkMin() 
	{
		return atkMin;
	}

	public int getAtkMax() 
	{
		return atkMax;
	}
	
	
}
