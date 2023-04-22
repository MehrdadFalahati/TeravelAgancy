package ir.maktab.teravelagancy.service;

import ir.maktab.teravelagancy.model.Road;
import ir.maktab.teravelagancy.model.Graph;
import ir.maktab.teravelagancy.persentation.TextUtil;

import java.util.*;

public class RoadService {
    private static final Map<Integer, Road> roads = new TreeMap<>();
    private static final Graph graph = new Graph();
    private final TextUtil textUtil;

    public RoadService(TextUtil textUtil) {
        this.textUtil = textUtil;
    }

    public boolean containsId(int id) {
        return roads.containsKey(id);
    }

    public Road loadRoadById(int id) {
        return roads.get(id);
    }

    public Set<Integer> loadRoadsBetweenTwoCity(int from, int to) {
        return graph.getRoads(from, to);
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
        List<Integer> through = road.getThrough();
        addRoadToAllRouteCities(through, road.getId());
        if (road.isBiDirectional()) {
            List<Integer> reversedRouteItems = new ArrayList<>(through);
            Collections.reverse(reversedRouteItems);
            addRoadToAllRouteCities(reversedRouteItems, road.getId());
        }
    }

    private void addRoadToAllRouteCities(List<Integer> orderedCities, int roadId) {
        for (int i = 0; i < orderedCities.size(); i++) {
            for (int j = i + 1; j < orderedCities.size(); j++)
                graph.addRoad(orderedCities.get(i), orderedCities.get(j), roadId);
        }
    }

    public void deleteRoadById(int id) {
        if (roads.get(id) != null)
            textUtil.print(roads.remove(id) + ":" + id + " deleted!");
        else
            textUtil.print("Road with id:" + id + " not found");
    }
}
