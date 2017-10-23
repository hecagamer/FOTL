package fotl;

public class Main 
{

	public static void main(String[] args) 
	{
		//@TODO Dynamic variable naming, assign patrols to a clan on creation.
		Individual noviceChar = new Individual("Amberwing", IndivSpecialty.NOVICE);
		Individual huntChar = new Individual("Lionheart", IndivSpecialty.HUNTER);
		Individual guardChar = new Individual("Shadowstep", IndivSpecialty.GUARDIAN);
		Individual disabledChar = new Individual("Whitenose", IndivSpecialty.FIGHTER);
		Individual woundedChar = new Individual("Adderpaw");
		
		disabledChar.setDisabled(true);
		woundedChar.setRecoveryTime(2);
		
		noviceChar.setNbHuntPats(18);
		
		PatrolHunting huntPat1 = new PatrolHunting();
		PatrolHunting huntPat2 = new PatrolHunting();
		
		Clan clan1 = new Clan("Leafclan");
		
		clan1.addHuntPat(huntPat1);
		clan1.addHuntPat(huntPat2);
		
		clan1.addMember(noviceChar);
		clan1.addMember(huntChar);
		clan1.addMember(guardChar);
		clan1.addMember(disabledChar);
		clan1.addMember(woundedChar);
		
		huntPat1.addMember(noviceChar);
		huntPat1.addMember(guardChar);
		huntPat1.addMember(disabledChar);
		
		huntPat2.addMember(huntChar);
		huntPat2.addMember(woundedChar);
		huntPat2.addMember(guardChar);
		
		Area area1 = new Area("Sunning rock", AreaLevel.LEVEL_2);
		Area area2 = new Area("The clearing", AreaLevel.LEVEL_3);
		
		clan1.addArea(area1);
		clan1.addArea(area2);
		
		CycleManager.addClan(clan1);
		
		System.out.println(area1.getAllegianceName() + " has a population of " + clan1.getPop() + " cats: \n" + clan1.getIndivList());
		
		int i; 
		
		for(int d = 1; d <= 5; d++)
		{
			clan1.assignHuntPat(huntPat1, area1);
			clan1.assignHuntPat(huntPat2, area2);
			clan1.assignHuntPat(huntPat2, area1);
			
			System.out.println("Day " + d + "\n");
			
			
			
			i = 1;
			
			for(PatrolHunting huntPat : clan1.getHuntPats())
			{
				System.out.println("The hunting patrol " + i + " has " + huntPat.getQtyMber() + " cats in it: \n" + huntPat.getMemberList());
				System.out.println("It's hunting in " + huntPat.curentAreaName() + ".\n");
				i++;
			}
			
			huntPat2.addMember(woundedChar);
			
			if(woundedChar.isWounded())
				System.out.println(woundedChar.getName() + " is wounded. The medicine cat estimate that he'll need " + woundedChar.getRecoveryTime() + " days to recover.\n");
			
			CycleManager.cycleStart();
			
			i = 1;
			for(PatrolHunting huntPat : clan1.getHuntPats())
			{
				System.out.println("Today, the patrol "+ i +" has brought back " + huntPat.getPreyCaught() + " food from " + huntPat.getCurentArea().getName() + ".\n");
				i++;
			}
			
			
			for(Individual cat : clan1.getIndividuals())
			{
				System.out.println(cat.getName() + " has been on " + cat.getNbBorderPats() + " border patrols and " + cat.getNbHuntPats() + " hunting patrols.");
			}
			
			for(Area area : clan1.getTerritory())
			{
				switch(area.getLevel())
				{
				case LEVEL_0:
					System.out.println("There is no prey left in " + area.getName() + ".");
					break;
				case LEVEL_1:
					System.out.println("Most of the prey ran away from " + area.getName() + ".");
					break;
				case LEVEL_2:
					System.out.println("There is some prey in " + area.getName() + ".");
					break;
				case LEVEL_3:
					System.out.println("There is quite a lot of prey in " + area.getName() + ".");
					break;
				case LEVEL_4:
					System.out.println(area.getName() + " is teeming with prey!");
					break;
				}
			}
			
			System.out.println(clan1.toString() + "\n\n");
		}
	}

}
