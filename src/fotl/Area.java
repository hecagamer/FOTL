package fotl;

public class Area 
{
	private int noHuntCycle;
	private String name;
	private AreaLevel level;
	private Clan alegiance;
	
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

	public Clan getAlegiance() 
	{
		return alegiance;
	}
	//Don't use this to change Area alegiance!
	public void setAlegiance(Clan alegiance) 
	{
		this.alegiance = alegiance;
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
