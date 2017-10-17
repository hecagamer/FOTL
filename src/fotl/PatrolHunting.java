package fotl; 

public class PatrolHunting extends Patrol
{
	private Area curentArea;

	public Area getCurentArea() 
	{
		return curentArea;
	}

	public void setCurentArea(Area curentArea) 
	{
		this.curentArea = curentArea;
	}
	
	public int hunt()
	{
		if(curentArea == null)
		{
			return 0;
		}
		int nbKill = 0;
		for(Individual chat : members)
		{
			for(int i=0; i<5; i++)
			{
				if(Math.random() <= curentArea.getLevel().getProb())
				{
					if(Math.random() <= chat.getSpec().getHunt())
					{
						nbKill++;
					}
				}
			}
		}
		curentArea.setNoHuntCycle(5);
		
		if(curentArea.getLevel().getMaxIn() < nbKill)
		{
			int penalty = (nbKill + 1 - curentArea.getLevel().getMaxIn())/2;
			curentArea.changeLvl(-penalty);
		}
		incrementPat(IndivSpecialty.NOVICE, IndivSpecialty.GUARDIAN);
		//TODO remove!
		System.out.println(nbKill);
		return nbKill; 
	}
}
