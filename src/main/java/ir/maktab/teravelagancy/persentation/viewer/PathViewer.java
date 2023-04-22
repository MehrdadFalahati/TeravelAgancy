package ir.maktab.teravelagancy.persentation.viewer;

import ir.maktab.teravelagancy.model.City;
import ir.maktab.teravelagancy.model.Road;
import ir.maktab.teravelagancy.persentation.TextUtil;
import ir.maktab.teravelagancy.service.CityService;
import ir.maktab.teravelagancy.service.RoadService;

import java.util.LinkedHashSet;
import java.util.Set;

public class PathViewer {
    private final CityService cityService;
    private final RoadService roadService;
    private final TextUtil textUtil;

    public PathViewer(TextUtil textUtil) {
        this.textUtil = textUtil;
        this.cityService = new CityService(textUtil);
        this.roadService = new RoadService(textUtil);
    }

    public void showPath(int from, int to) {
        City fromCity = cityService.loadCityById(from);
        City toCity = cityService.loadCityById(to);
        if (fromCity == null || toCity == null)
            return;
        Set<Road> roads = new LinkedHashSet<>();
        Set<Integer> ids = roadService.loadRoadsBetweenTwoCity(from, to);
        for (Integer id : ids) {
            if (roadService.containsId(id)) {
                roads.add(roadService.loadRoadById(id));
            }
        }
        for (Road road : roads) {
            textUtil.print(fromCity.getName() + ":" + toCity.getName() + " via Road " + road.getName() + ": Takes " + road.timeString());
        }
    }
}
