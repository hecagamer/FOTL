package fotl;

public class Main 
{

	public static void main(String[] args) 
	{
		//@TODO Dynamic variable naming, assign patrols to a clan on creation.
		Individual apprChar = new Individual("Amberpaw");
		Individual huntChar = new Individual("Lionheart", IndivSpecialty.HUNTER);
		Individual guardChar = new Individual("Shadowstep", IndivSpecialty.GUARDIAN);
		Individual disabledChar = new Individual("Whitenose", IndivSpecialty.FIGHTER);
		Individual woundedChar = new Individual("Adderpaw");
		
		disabledChar.setDisabled(true);
		woundedChar.setRecoveryTime(4);
		
		PatrolHunting huntPat1 = new PatrolHunting();
		PatrolHunting huntPat2 = new PatrolHunting();
		
		Clan clan1 = new Clan("Leafclan");
		
		clan1.addHuntPat(huntPat1);
		clan1.addHuntPat(huntPat2);
		
		clan1.addMember(apprChar);
		clan1.addMember(huntChar);
		clan1.addMember(guardChar);
		clan1.addMember(disabledChar);
		clan1.addMember(woundedChar);
		
		huntPat1.addMember(apprChar);
		huntPat1.addMember(guardChar);
		huntPat1.addMember(disabledChar);
		
		huntPat2.addMember(huntChar);
		huntPat2.addMember(woundedChar);
		huntPat2.addMember(guardChar);
		
		Area area1 = new Area("Sunning rock", AreaLevel.LEVEL_2);
		
		clan1.addArea(area1);
		
		CycleManager.addClan(clan1);
		
		System.out.println(area1.getAllegianceName() + " has a population of " + clan1.getPop() + " cats: \n" + clan1.getIndivList());
		
		
		for(int d = 1; d <= 10; d++)
		{
			huntPat1.setCurentArea(area1);
			
			System.out.println("Day " + d + "\n");
			
			System.out.println("This hunting patrol has " + huntPat1.getQtyMber() + " cats in it: \n" + huntPat1.getMemberList());
			System.out.println("The other hunting patrol has " + huntPat2.getQtyMber() + " cats in it: \n" + huntPat2.getMemberList());
			
			huntPat2.addMember(woundedChar);
			
			CycleManager.cycleStart();
			
			System.out.println("Today, the patrol has brought back " + huntPat1.getPreyCaught() + " food from " + huntPat1.getCurentArea().getName() + ".");
			
			for(Individual cat : clan1.getIndividuals())
			{
				System.out.println(cat.getName() + " has been on " + cat.getNbPatrols() + " patrols that aren't of their specialty.");
			}
			
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
