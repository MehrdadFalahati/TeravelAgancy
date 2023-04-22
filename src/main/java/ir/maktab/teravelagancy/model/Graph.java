package ir.maktab.teravelagancy.model;

import java.util.*;

public class Graph {
    private final Map<Integer, Map<Integer, Set<Integer>>> cityRoads = new HashMap<>();

    public void addRoad(Integer start, Integer end, Integer road) {
        Map<Integer, Set<Integer>> citySetMap = cityRoads.computeIfAbsent(start, k -> new HashMap<>());
        Set<Integer> roads = citySetMap.computeIfAbsent(end, k -> new TreeSet<>());
        roads.add(road);
    }

    public Set<Integer> getRoads(Integer start, Integer end) {
        return Optional.ofNullable(cityRoads.get(start))
                .map(map -> map.get(end))
                .orElse(Collections.emptySet());
    }
}
