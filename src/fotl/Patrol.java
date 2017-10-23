package fotl;
import java.util.List; 
import java.util.ArrayList;

public abstract class Patrol 
{
	protected List<Individual> members = new ArrayList<Individual>();
	
	public int getQtyMber()
	{
		return members.size();
	}
	
	public String getMemberList()
	{
		String tmp = "";
		for(Individual cat : members)
		{
			tmp = tmp + cat.getName() + "\n";
		}
		
		return tmp;
	}
	
	public int addMember(Individual i)
	{
		if(i.isInPatrol() == false && i.isWounded() == false && i.isDisabled() == false)
		{
			members.add(i);
			i.setInPatrol(true);
			return 0;
		}
		else
			return 1;
	}
	
	public void rmMember(Individual i)
	{
		members.remove(i);
	}
	
	public Individual[] getMembers()
	{
		return members.toArray(new Individual[0]);
	}
}
