package fotl;

public class Main 
{

	public static void main(String[] args) 
	{
		//@TODO Dynamic variable naming.
		Individual apprChar = new Individual("Amberpaw");
		Individual huntChar = new Individual("Lionheart", IndivSpecialty.HUNTER);
		Individual guardChar = new Individual("Shadowstep", IndivSpecialty.GUARDIAN);
		
		PatrolHunting huntPat1 = new PatrolHunting();
		
		Clan clan1 = new Clan("Leafclan");
		
		clan1.addMember(apprChar);
		clan1.addMember(huntChar);
		clan1.addMember(guardChar);
		
		huntPat1.addMember(apprChar);
		huntPat1.addMember(huntChar);
		huntPat1.addMember(guardChar);
		
		Area area1 = new Area("Sunning rock", AreaLevel.LEVEL_2);
		
		clan1.addArea(area1);
		
		huntPat1.setCurentArea(area1);
		
		huntPat1.hunt();
		
		System.out.println(apprChar.getNbPatrols());
		System.out.println(huntChar.getNbPatrols());
		System.out.println(guardChar.getNbPatrols());
		
		System.out.println(area1.getName());
		System.out.println(area1.getLevel());
		System.out.println(area1.getAllegianceName());
		
		
		System.out.println(clan1.getPop());
		System.out.println(clan1.getIndivList());
	}

}
