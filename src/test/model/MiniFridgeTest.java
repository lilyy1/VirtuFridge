package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniFridgeTest {

    MiniFridge fridge = new MiniFridge();
    Item apple = new Item("Apple", "2019-07-12");
    Item pear = new Item("Pear" , "2019-07-12");

    @Test
    void testAddFoodItem() {
        assertEquals(0,fridge.size());
        fridge.addFoodItem(apple);

        assertEquals(1,fridge.size());
        assertTrue(fridge.containsItem("Apple"));

        fridge.removeFood("Apple");
        assertTrue(fridge.isEmpty());

    }

    @Test
    void testGetFridge() {
        assertEquals(fridge.getFridge(),fridge.getFridge());
    }

    @Test
    void testItem() {
        assertEquals("Apple",apple.getItemName());
        assertEquals(apple.getExpiryDate(), "2019-07-12");
    }

    @Test
    void testContainsItem() {
        assertFalse(fridge.containsItem("Apple"));
        fridge.addFoodItem(apple);
        fridge.addFoodItem(pear);
        assertFalse(fridge.containsItem("Orange"));
        assertTrue(fridge.containsItem("Pear"));
        assertTrue(fridge.containsItem("Apple"));

    }

    @Test
    void testRemoveITem() {
        fridge.addFoodItem(apple);
        fridge.removeFood("Pear");
        fridge.addFoodItem(pear);
        fridge.removeFood("Pear");
        assertEquals(1,fridge.size());
        fridge.removeFood("Apple");
        assertTrue(fridge.isEmpty());
    }

    @Test
    void testEquals() {
        assertTrue(pear.equals(pear));
        assertFalse(apple.equals(pear));
        MiniFridge apple = new MiniFridge();
        assertFalse(pear.equals(apple));
        assertTrue(apple.equals(apple));

    }
}

