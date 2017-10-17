package fotl;
import java.util.List; 
import java.util.ArrayList;

public class Clan 
{
	private String name;
	private int food, daysSinceLastFed;
	
	//Constructor.
	public Clan(String n)
	{
		name = n; 
		daysSinceLastFed = 0;
		CycleManager.addClan(this);
	}
	
	public String getName() 
	{
		return name;
	}

	
	private List<Individual> population = new ArrayList<Individual>();
	
		public List<Individual> getIndividuals() 
		{
			return population;
		}
		
		public String getIndivList()
		{
			String tmp = "";
			for(Individual cat : population)
			{
				tmp = tmp + cat.getName() + "\n";
			}
			
			return tmp;
		}
		
		public int getPop()
		{
			return population.size();
		}
		
		public void addMember(Individual i)
		{
			population.add(i);
		}
		
		public void rmMember(Individual i)
		{
			population.remove(i);
		}
		
		public Individual[] getMembers()
		{
			return population.toArray(new Individual[0]);
		}
		
	private List<Area> territory = new ArrayList<Area>();
		
	//Use this to change Area allegiance!
		public void addArea(Area a)
		{
			if(a.getAlegiance() != null)
				a.getAlegiance().rmArea(a);
			a.setAlegiance(this);
			territory.add(a);
		}
		
		public void rmArea(Area a)
		{
			a.setAlegiance(null);
			territory.remove(a);
		}
		
	private List<PatrolHunting> huntPats = new ArrayList<PatrolHunting>(); 
		
		public void addHuntPat(PatrolHunting hp)
		{
			huntPats.add(hp);
		}
		
		public void rmHuntPat(PatrolHunting hp)
		{
			huntPats.remove(hp);
		}
	
	public String toString()
	{
		return name +" "+ food +" "+ daysSinceLastFed;
	}

	public void newCycle()
	{
		for(PatrolHunting hunting : huntPats)
		{
			food += hunting.hunt();
		}
		food -= population.size();
		if(food < 0)
		{
			food = 0;
			daysSinceLastFed ++;
		}
		else
			daysSinceLastFed = 0;
		
		for(Area ter : territory)
		{
			ter.newHuntCycle();
		}
	}
}
