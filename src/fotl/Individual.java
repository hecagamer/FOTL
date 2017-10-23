package fotl;

public class Individual 
{
	private String name;
	private boolean disabled, warrior, isInPatrol, isInClan; 
	private int recoveryTime, nbHuntPats, nbBorderPats, malnourished;
	private IndivSpecialty spec;
	
	public Individual(String n, IndivSpecialty sp)
	{
		name = n;
		recoveryTime = 0;
		switch(sp)
		{
		case NOVICE:
			nbHuntPats = 0;
			nbBorderPats = 0;
			break;
		case FIGHTER:
			nbHuntPats = 25;
			nbBorderPats = 25;
			break;
		case GUARDIAN:
			nbHuntPats = 0;
			nbBorderPats = 20;
			break;
		case HUNTER:
			nbHuntPats = 20;
			nbBorderPats = 0;
			break;
		default:
			break; 
		}
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
		nbHuntPats = 0;
		nbBorderPats = 0; 
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

	public boolean isInClan() 
	{
		return isInClan;
	}

	public void setInClan(boolean isInClan) 
	{
		this.isInClan = isInClan;
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
	
	public int getNbHuntPats() 
	{
		return nbHuntPats;
	}

	public void setNbHuntPats(int nbHuntPats) 
	{
		this.nbHuntPats = nbHuntPats;
	}

	public int getNbBorderPats() 
	{
		return nbBorderPats;
	}

	public void setNbBorderPats(int nbBorderPats) 
	{
		this.nbBorderPats = nbBorderPats;
	}

	public void incrHuntPatsNb()
	{
		nbHuntPats++;
	}
	
	public void incrBorderPatsNb()
	{
		nbBorderPats++;
	}
	
	public int getRecoveryTime() 
	{
		return recoveryTime;
	}

	public void setRecoveryTime(int time)
	{
		recoveryTime = time;
	}
	
	public void decrRecoveryTime()
	{
		recoveryTime--;
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
