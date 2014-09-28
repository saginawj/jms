package org.jms;

import org.jms.Saginawj;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTests {
    @Test
    public void canConstructAPersonWithAName() {
        Saginawj person = new Saginawj("Jon");
        assertEquals("Jon", person.getName());
    }
    @Test
    public void testWillPass() {
        Saginawj person = new Saginawj("Jon");
        assertEquals("Jon", person.getName());
    }
    @Test
    public void testWillFail() {
        Saginawj person = new Saginawj("Jon");
        assertEquals("Mike", person.getName());
    }
    @Test
    public void methodCheck3() {
        Saginawj person = new Saginawj("Jon");
        assertEquals("Jon", person.getName());
    }
}
