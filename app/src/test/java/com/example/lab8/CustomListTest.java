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
        assertEquals(2, list.getCount());
        list.delete(city1);
        assertEquals(1, list.getCount());
        assertFalse(list.hasCity(city1));
        list.delete(city2);
        assertThrows( NoSuchElementException.class, () -> {
            list.delete(city1); });
    }

    /**
     * adds 2 cities to the list
     * checks to see if amount of cities is 2
     * add another city
     * check the number of cities in the list, expect 3
     * delete 2 cities
     * check for 1 city in list
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        City city1 = new City("Halifax", "NS");
        City city2 = new City("Saskatoon", "SK");
        list.add(city1);
        list.add(city2);
        assertEquals(2, list.countCities());
        City city3 = new City("Charlottetown", "PE");
        list.add(city3);
        assertEquals(3, list.countCities());
        list.delete(city1);
        list.delete(city2);
        assertEquals(1, list.countCities());
    }
}
