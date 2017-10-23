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
		
		public int addMember(Individual i)
		{
			if(i.isInClan() == false)
			{
				population.add(i);
				i.setInClan(true);
				return 0;
			}
			else
				return 1;
		}
		
		public int rmMember(Individual i)
		{
			if(i.isInClan() == true)
			{
				population.remove(i);
				i.setInClan(false);
				return 0;
			}
			else
				return 1;
		}
		
		public Individual[] getMembers()
		{
			return population.toArray(new Individual[0]);
		}
		
	private List<Area> territory = new ArrayList<Area>();
		
		public List<Area> getTerritory() 
		{
			return territory;
		}

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
		
		public List<PatrolHunting> getHuntPats() 
		{
			return huntPats;
		}
		
		public int getNumOfHuntPats()
		{
			return huntPats.size();
		}

		public void addHuntPat(PatrolHunting hp)
		{
			huntPats.add(hp);
		}
		
		public void rmHuntPat(PatrolHunting hp)
		{
			huntPats.remove(hp);
		}
	
		public int assignHuntPat(PatrolHunting hp, Area ter)
		{
			for(PatrolHunting huntPat : huntPats)
			{
				if(huntPat.getCurentArea() == ter)
				{
					return 1;
				}
			}
			hp.setCurentArea(ter);
			return 0;
		}
		
	public String toString()
	{
		return name + " has " + food + " of food in its storage. They've spent " + daysSinceLastFed + " days without eating properly.";
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
		
		for(Individual cat : population)
		{
			if(cat.isWounded())
				cat.decrRecoveryTime();
			if(cat.getNbBorderPats() == 0 && cat.getNbHuntPats() == 0)
				cat.setSpec(IndivSpecialty.NOVICE);
			else if(cat.getNbBorderPats() == 20)
				cat.setSpec(IndivSpecialty.GUARDIAN);
			else if(cat.getNbHuntPats() == 20)
				cat.setSpec(IndivSpecialty.HUNTER);
			else if((cat.getNbBorderPats() >= 20 && cat.getNbHuntPats() == 25) || (cat.getNbBorderPats() == 25 && cat.getNbHuntPats() >= 25))
				cat.setSpec(IndivSpecialty.FIGHTER);
		}
		
		for(Area ter : territory)
		{
			ter.newHuntCycle();
		}
	}
}
