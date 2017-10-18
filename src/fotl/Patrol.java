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
	
	public int addMember(Individual i)
	{
		if(i.isInPatrol() == false)
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
	
	protected void incrementPat(IndivSpecialty... spec)
	{
		for(Individual cat : members)
		{
			for(IndivSpecialty _spec : spec)
			{
				if(cat.getSpec() == _spec)
				{
					cat.incrPatrolNb();
					break;
				}
			}
		}
	}
}
