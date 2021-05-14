package de.luca.uebungsaufgaben.semester2.uebungsblatt03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EuroTest {

    private Euro two;

    @Before
    public void setUp() {
        two = new Euro(2.00);
    }

    @Test
    public void testAmount() {
        assertEquals(2.00, two.getAmount(), 0.0);
    }

    @Test
    public void testRounding() {
        Euro two = new Euro(1.995);
        assertEquals("amount not rounded", 2.00, two.getAmount(), 0.001);
    }

    @Test
    public void testAdding() {
        Euro three = two.add(new Euro(1.00));
        assertEquals("two is wrong", 2.00, two.getAmount(), 0.001);
        assertEquals("three is wrong", 3.00, three.getAmount(), 0.001);
    }
}
