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

	public int getFood() 
	{
		return food;
	}
	
	public int getDaysSinceLastFed() 
	{
		return daysSinceLastFed;
	}

	private List<Individual> population = new ArrayList<Individual>();
	
		public List<Individual> getIndividuals() //retourne une liste.
		{
			return population;
		}
		
		public String getIndivList() //Retourne une liste écrite des individus.
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
			if(a.getAllegiance() != null)
				a.getAllegiance().rmArea(a);
			a.setAllegiance(this);
			territory.add(a);
		}
		
		public void rmArea(Area a)
		{
			a.setAllegiance(null);
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
		return name + " has " + food + " of food in its storage. They've spent " + daysSinceLastFed + " days without eating.";
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
