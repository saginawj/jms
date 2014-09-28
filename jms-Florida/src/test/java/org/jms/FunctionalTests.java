package org.jms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionalTests {

	 @Test
	    public void methodCheck() {
	        Saginawj person = new Saginawj("Jon");
	        assertEquals("Jon", person.getName());
	    }
	    @Test
	    public void methodCheck2() {
	        Saginawj person = new Saginawj("Jon");
	        assertEquals("Jon", person.getName());
	    }

}
