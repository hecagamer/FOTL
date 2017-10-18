package fotl;

public class Individual 
{
	private String name;
	private boolean disabled, warrior, isInPatrol; 
	private int recoveryTime, nbPatrols, malnourished;
	private IndivSpecialty spec;
	
	public Individual(String n, IndivSpecialty sp)
	{
		name = n;
		recoveryTime = 0;
		nbPatrols = 0; 
		malnourished = 0;
		spec = sp;
		disabled = false;
		isInPatrol = false; 
		if(sp == IndivSpecialty.NOVICE)
			warrior = false;
		else
			warrior = true;
	}
	
	public Individual(String n)
	{
		name = n;
		recoveryTime = 0;
		nbPatrols = 0; 
		malnourished = 0;
		disabled = false;
		isInPatrol = false;
		spec = IndivSpecialty.NOVICE;
		warrior = false;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setSpec(IndivSpecialty spec) 
	{
		this.spec = spec;
	}

	public String getName() 
	{
		return name;
	}
	
	public IndivSpecialty getSpec() 
	{
		return spec;
	}
	
	public boolean isDisabled() 
	{
		return disabled;
	}

	public void setDisabled(boolean disabled) 
	{
		this.disabled = disabled;
	}

	public int getNbPatrols() 
	{
		return nbPatrols;
	}

	public void setNbPatrols(int nbPatrols) 
	{
		this.nbPatrols = nbPatrols;
	}
	
	public void incrPatrolNb()
	{
		nbPatrols++;
	}

	public void setRecoveryTime(int time)
	{
		recoveryTime = time;
	}
	
	public boolean isWounded()
	{
		if(recoveryTime == 0)
			return false;
		else
			return true;
	}

	public boolean isInPatrol() 
	{
		return isInPatrol;
	}

	public void setInPatrol(boolean isInPatrol) 
	{
		this.isInPatrol = isInPatrol;
	}
}
