package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertEquals((list.getCities().contains(city)),city);
    }


}
