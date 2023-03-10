package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * When given a city, return whether or not it belongs in the list
     * @param city This is the city that is searched for in list of cities
     * @return Returns a boolean true if city is present and boolean false if not
     */
    public boolean hasCity(City city) {
        boolean cityBool = cities.contains(city);
        return cityBool;
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }


    /**
     * Check if a city is present in the list. If it does then remove it from the list, if not then throw an exception
     * @param city a city to search for and delete
     * @throws NoSuchElementException when trying to delete a city that does not exist in the list of cities
     */
    public void delete(City city) {
        boolean found = false;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == city) {
                found = true;
                cities.remove(i);
            }
        }
        if (!found) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Return how many cities are in the list
     * @return Returns the number of cities in list
     */
    public int countCities() {
        return cities.size();
    }
}
