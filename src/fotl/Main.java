package fotl;

public class Main 
{

	public static void main(String[] args) 
	{
		//@TODO Dynamic variable naming, assign patrols to a clan on creation.
		Individual apprChar = new Individual("Amberpaw");
		Individual huntChar = new Individual("Lionheart", IndivSpecialty.HUNTER);
		Individual guardChar = new Individual("Shadowstep", IndivSpecialty.GUARDIAN);
		Individual disabledChar = new Individual("Adderpaw");
		
		//@TODO Set wounded.
		
		PatrolHunting huntPat1 = new PatrolHunting();
		PatrolHunting huntPat2 = new PatrolHunting();
		
		Clan clan1 = new Clan("Leafclan");
		
		clan1.addHuntPat(huntPat1);
		clan1.addHuntPat(huntPat2);
		
		clan1.addMember(apprChar);
		clan1.addMember(huntChar);
		clan1.addMember(guardChar);
		clan1.addMember(disabledChar);
		
		huntPat1.addMember(apprChar);
		huntPat1.addMember(huntChar);
		huntPat1.addMember(guardChar);
		
		Area area1 = new Area("Sunning rock", AreaLevel.LEVEL_4);
		
		clan1.addArea(area1);
		
		CycleManager.addClan(clan1);
		
		System.out.println(area1.getAllegianceName() + " has a population of " + clan1.getPop() + " cats: \n" + clan1.getIndivList());
		
		for(int i = 0; i < 10; i++)
		{
			huntPat1.setCurentArea(area1);
			
			CycleManager.cycleStart();
		
			System.out.println("Today, the patrol has brought back " + huntPat1.getPreyCaught() + " food from " + huntPat1.getCurentArea().getName() + ".");
		
			System.out.println("Amberpaw has been on " + apprChar.getNbPatrols() + " patrols that aren't of their specialty.");
			System.out.println("Lionheart has been on " + huntChar.getNbPatrols() + " patrols that aren't of their specialty.");
			System.out.println("Shadowstep has been on " + guardChar.getNbPatrols() + " patrols that aren't of their specialty.");
			
			switch(area1.getLevel())
			{
			case LEVEL_0:
				System.out.println("There is no prey left in " + area1.getName() + ".");
				break;
			case LEVEL_1:
				System.out.println("Most of the prey ran away from " + area1.getName() + ".");
				break;
			case LEVEL_2:
				System.out.println("There is some prey in " + area1.getName() + ".");
				break;
			case LEVEL_3:
				System.out.println("There is quite a lot of prey in " + area1.getName() + ".");
				break;
			case LEVEL_4:
				System.out.println(area1.getName() + " is teeming with prey!");
				break;
			}
			
			System.out.println(clan1.toString() + "\n\n");
		}
	}

}
