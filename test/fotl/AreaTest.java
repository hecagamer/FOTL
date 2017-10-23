package fotl;

import static org.junit.Assert.*;

import org.junit.Test;

public class AreaTest {

	@Test
	public void testChangeLevel() 
	{
		Area area1 = new Area("Sunning rock", AreaLevel.LEVEL_2);
		
		area1.changeLvl(-1);
		
		assertTrue(area1.getLevel() == AreaLevel.LEVEL_1);
	}

}
