package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * Test the delete operation.
     */
    @Test
    public void testdelete()
    {
        CityList cityList=new CityList();
        City city=new City("Pirganj","Rangpur");
        City city1=new City("Sherpur","Bogura");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Test the delete exception operation.
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList=new CityList();
        City city=new City("Pirganj","Rangpur");
        City city1=new City("Sherpur","Bogura");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Test the Count operation.
     */
    @Test
    public void testCount()
    {
        CityList cityList=new CityList();
        City city=new City("Pirganj","Rangpur");
        City city1=new City("Sherpur","Bogura");
        City city2=new City("Dinajpur","Rangpur");
        cityList.add(city);
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(3,cityList.count());
        cityList.delete(city1);
        assertEquals(2,cityList.count());
    }
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * Test the Sort operation.
     */
    @Test
    public void testSort()
    {
        CityList cityList=new CityList();
        City city1=new City("Walnut","California");
        cityList.add(city1);
        assertEquals(0,city1.compareTo(cityList.getCities(1).get(0)));

        City city=new City("Caracas","Venezuela");
        cityList.add(city);
        assertEquals(0,city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0,city1.compareTo(cityList.getCities(2).get(0)));

    }
}
