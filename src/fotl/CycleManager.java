package fotl;
import java.util.List; 
import java.util.ArrayList;

public class CycleManager 
{
	private static List<Clan> clansList = new ArrayList<Clan>();
	
		public static void addClan(Clan i)
		{
			clansList.add(i);
		}
		
		public static void rmClan(Clan i)
		{
			clansList.remove(i);
		}
		
		public static Clan[] getClan()
		{
			return clansList.toArray(new Clan[0]);
		}
	
	public static void cycleStart()
	{
		for(Clan clans : clansList)
		{
			clans.newCycle();
		}
	}
}
