package org.example;

import org.example.Item;
import org.example.SILab2;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void testEveryBranch() {
        // Test case where allItems is null
        try {
            SILab2.checkCart(null, 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("allItems list can't be null!", e.getMessage());
        }

        // Test case where item has no barcode
        try {
            SILab2.checkCart(Arrays.asList(new Item("Milk", null, 50, 0.1f)), 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("No barcode!", e.getMessage());
        }

        // Test case where item has invalid barcode character
        try {
            SILab2.checkCart(Arrays.asList(new Item("Milk", "1234$", 50, 0.1f)), 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Invalid character in item barcode!", e.getMessage());
        }

        // Test case where sum is within payment
        assertTrue(SILab2.checkCart(Arrays.asList(new Item("Milk", "12345", 50, 0.1f)), 100));

        // Test case where sum exceeds payment
        assertFalse(SILab2.checkCart(Arrays.asList(new Item("Milk", "12345", 150, 0.1f)), 10));
    }

    @Test
    public void testMultipleCondition() {
        // Test case: item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'
        assertTrue(SILab2.checkCart(Arrays.asList(new Item("ExpensiveItem", "01234", 400, 0.2f)), 100));

        // Test case: item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) != '0'
        assertFalse(SILab2.checkCart(Arrays.asList(new Item("ExpensiveItem", "11234", 400, 0.2f)), 100));

        // Test case: item.getPrice() <= 300
        assertFalse(SILab2.checkCart(Arrays.asList(new Item("CheapItem", "01234", 200, 0.2f)), 100));

        // Test case: item.getDiscount() <= 0
        assertFalse(SILab2.checkCart(Arrays.asList(new Item("ItemNoDiscount", "01234", 400, 0f)), 100));
    }
}