package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "Sk"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * create the list
     * add city to the list
     * check if list contains the city specified
     */

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Calgary", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * add 2 cities to the list
     * check if 2 cities are in the list
     * remove 1 city
     * check if there are now only one city in the list
     * check if the city removed in not in the list
     * checks if assertion is raised when no cities are in the list
     */

    @Test
    public void deleteTest(){
        list = MockCityList();
        City city1 = new City("Vancouver", "BC");
        list.addCity(city1);
        City city2 = new City("Toronto", "ON");
        list.addCity(city2);
        assertEquals(list.getCount(), 2);
        list.delete(city1);
        assertEquals(list.getCount(), 1);
        assertFalse(list.hasCity(city1));
        list.delete(city2);
        assertThrows( NoSuchElementException.class, () -> {
            list.delete(city1); });
    }
}
