package fotl;
import java.util.List; 
import java.util.ArrayList;

public class CycleManager 
{
	//@TODO clansList is not created.
	public static List<Clan> clansList = new ArrayList<Clan>();
	
		public static int addClan(Clan i)
		{
			for(Clan cl : clansList)
			{
				if(cl == i)
					return 1;
			}
			clansList.add(i);
			return 0;
		}
		
		public static void rmClan(Clan i)
		{
			clansList.remove(i);
		}
		
		public static List<Clan> getClan()
		{
			return clansList;
		}
		
		public static String getClanList()
		{
			String tmp = "";
			for(Clan cl : clansList)
			{
				tmp = tmp + cl.getName() + "\n";
			}
			
			return tmp;
		}
	
	public static void cycleStart()
	{
		for(Clan clans : clansList)
		{
			clans.newCycle();
		}
	}
}
