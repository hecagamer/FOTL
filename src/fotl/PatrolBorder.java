package fotl;

public class PatrolBorder extends Patrol
{
	public void borderWatch()
	{
		for(Individual chat : members)
		{
			chat.incrBorderPatsNb();
		}
	}
}
