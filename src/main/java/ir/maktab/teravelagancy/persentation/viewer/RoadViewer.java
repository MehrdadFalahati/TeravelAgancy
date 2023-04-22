package ir.maktab.teravelagancy.persentation.viewer;

import ir.maktab.teravelagancy.exception.InvalidDataException;
import ir.maktab.teravelagancy.model.Road;
import ir.maktab.teravelagancy.persentation.TextUtil;
import ir.maktab.teravelagancy.persentation.ui.Input;
import ir.maktab.teravelagancy.service.RoadService;

import java.util.ArrayList;
import java.util.List;

public class RoadViewer {
    private final RoadService roadService;
    private final TextUtil textUtil;
    public RoadViewer(TextUtil textUtil) {
        this.textUtil = textUtil;
        this.roadService = new RoadService(textUtil);
    }

    public void addRoad() {
        int selectedItem;
        do {
            addRoadInternal();
            selectedItem = Input.getInt();
        } while (selectedItem == 1);
    }

    private void addRoadInternal() {
        Road newRoad = createRoadFromInput();
        roadService.addRoad(newRoad);
        textUtil.showNextAction(newRoad.getId(), newRoad);
    }

    private Road createRoadFromInput() {
        textUtil.print("id=?");
        int id = Input.getInt();
        textUtil.print("name=?");
        String name = Input.getString();
        textUtil.print("from=?");
        int from = Input.getInt();
        textUtil.print("to=?");
        int to = Input.getInt();
        textUtil.print("through=?");
        String throughRawInput = Input.getString();
        if (checkInvalidListData(throughRawInput)) {
            throw new InvalidDataException("invalid input");
        }
        List<Integer> throughCityIds = getThroughCityIds(from, to, throughRawInput.replaceAll("[()\\[\\]]", ""));
        textUtil.print("speedLimit=?");
        int speedLimit = Input.getInt();
        textUtil.print("length=?");
        int length = Input.getInt();
        textUtil.print("biDirectional=?");
        int biDirectional = Input.getInt();
        if (biDirectional < 0 || biDirectional > 1)
            throw new InvalidDataException("Invalid data");
        return Road.builder()
                .id(id)
                .name(name)
                .from(from)
                .to(to)
                .through(throughCityIds)
                .speedLimit(speedLimit)
                .length(length)
                .biDirectional(biDirectional == 1)
                .build();
    }

    private boolean checkInvalidListData(String throughRawInput) {
        return (throughRawInput.startsWith("[") && !throughRawInput.endsWith("]")) ||
                (!throughRawInput.startsWith("[") && throughRawInput.endsWith("]")) ||
                (!throughRawInput.startsWith("[") && !throughRawInput.endsWith("]"));
    }

    private List<Integer> getThroughCityIds(int from, int to, String throughRawInput) {
        List<Integer> throughCityIds = new ArrayList<>();
        if (!throughRawInput.isEmpty()) {
            String[] through = throughRawInput.split(",");
            for (String s : through) {
                throughCityIds.add(Integer.parseInt(s));
            }
        }
        if (!throughCityIds.contains(to))
            throughCityIds.add(to);
        if (!throughCityIds.contains(from))
            throughCityIds.add(0, from);
        return throughCityIds;
    }

    public void removeRoad() {
        int id = Input.getInt();
        roadService.deleteRoadById(id);
    }
}
