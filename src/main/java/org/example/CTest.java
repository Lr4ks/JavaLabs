package org.example;

import org.example.CustomerContainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CTest {

    @Test
    public void testAdd() {
        CustomerContainer container = new CustomerContainer();
        container.add(5);
        assertEquals(1,  container.size());
    }
    @Test
    public void testGet() {
        CustomerContainer container = new CustomerContainer();

        container.add(5);
        container.add(6);
        container.add(7);

        assertEquals(5, container.get(0));
        assertEquals(6, container.get(1));
        assertEquals(7, container.get(2));
    }

    @Test
    public void testGetOutOfBounds() {
        CustomerContainer container = new CustomerContainer();
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(5));
    }
    @Test
    public void testRemove() {
        CustomerContainer container = new CustomerContainer();
        container.add(10);
        container.remove(1);

        assertEquals(1, container.size());
    }
    @Test
    public void testRemoveOutOfBounds() {
        CustomerContainer container = new CustomerContainer();
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }
}

