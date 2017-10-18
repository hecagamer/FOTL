package fotl;

public class Area 
{
	private int noHuntCycle;
	private String name;
	private AreaLevel level;
	private Clan allegiance;
	
	public Area(String n, AreaLevel l)
	{
		noHuntCycle = 5;
		name = n;
		level = l;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setNoHuntCycle(int noHuntCycle) 
	{
		this.noHuntCycle = noHuntCycle;
	}

	public AreaLevel getLevel()
	{
		return level;
	}
	
	public void changeLvl(int change)
	{
		level = level.changeLevel(change);
	}

	public Clan getAllegiance() 
	{
		return allegiance;
	}
	
	public String getAllegianceName()
	{
		return allegiance.getName();
	}
	
	//Don't use this to change Area allegiance!
	public void setAllegiance(Clan allegiance) 
	{
		this.allegiance = allegiance;
	}
	
	public void newHuntCycle()
	{
		noHuntCycle --;
		if(noHuntCycle <= 0)
		{
			noHuntCycle = 5;
			changeLvl(1);
		}
	}
}
