package fotl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClanTest {
	
	private Clan clan1;
	private Clan clan2;
	
	private PatrolHunting huntPat1; 
	
	private Individual char1;
	
	@Before
	public void setup()
	{
		clan1 = new Clan("Leafclan");
		clan2 = new Clan("Lakeclan");
		
		huntPat1 = new PatrolHunting();
		
		char1 = new Individual("Smokeweed");
		
		
	}
	
	@Test
	public void testNoCatInTwoClans() 
	{
		assertEquals(0, clan1.getPop());
		assertEquals(0, clan2.getPop());
		
		clan1.addMember(char1);
		
		assertEquals(1, clan1.getPop());
		assertEquals(0, clan2.getPop());
		
		clan2.addMember(char1);
		
		assertEquals(1, clan1.getPop());
		assertEquals(0, clan2.getPop());
		
		clan1.rmMember(char1);
		
		assertEquals(0, clan1.getPop());
		assertEquals(0, clan2.getPop());
		
		clan2.addMember(char1);
		
		assertEquals(0, clan1.getPop());
		assertEquals(1, clan2.getPop());
	}

	@Test
	public void testNoOutsiderInPatrol()
	{
		assertEquals(0, huntPat1.getQtyMber());
		
		clan1.addMember(char1);
		huntPat1.addMember(char1);
		
		assertEquals(1, huntPat1.getQtyMber());
		
		huntPat1.rmMember(char1);
		clan1.rmMember(char1);
		
		assertEquals(0, huntPat1.getQtyMber());
		
		huntPat1.addMember(char1);
		
		assertEquals(0, huntPat1.getQtyMber());
		
		clan2.addMember(char1);
		huntPat1.addMember(char1);
		
		assertEquals(0, huntPat1.getQtyMber());
	}
}