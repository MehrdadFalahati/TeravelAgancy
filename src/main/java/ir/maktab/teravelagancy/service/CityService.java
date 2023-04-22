package ir.maktab.teravelagancy.service;

import ir.maktab.teravelagancy.model.City;
import ir.maktab.teravelagancy.persentation.TextUtil;

import java.util.HashMap;
import java.util.Map;

public class CityService {
    private static final Map<Integer, City> cities = new HashMap<>();
    private final TextUtil textUtil;

    public CityService(TextUtil textUtil) {
        this.textUtil = textUtil;
    }

    public void addCity(City city) {
        cities.put(city.getId(), city);
    }

    public void deleteCityById(int id) {
        if (cities.get(id) != null) {
            final String deletedText = cities.remove(id) + ":" + id + " deleted!";
            textUtil.print(deletedText);
        } else {
            final String notFound = "City with id:" + id + " not found";
            textUtil.print(notFound);
        }
    }

    public City loadCityById(int id) {
        return cities.get(id);
    }
}
