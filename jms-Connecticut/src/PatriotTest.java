import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class PatriotTest {

	@Test
	public void testPatriotNameTrue() {
		boolean condition = true;
		assertTrue(condition);	
	}
	
	@Test
	public void testPatriotNameFalse() {
		boolean condition = false;
		assertTrue(condition);	
	}
}
