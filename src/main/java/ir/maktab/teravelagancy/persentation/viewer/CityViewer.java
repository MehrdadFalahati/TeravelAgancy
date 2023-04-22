package ir.maktab.teravelagancy.persentation.viewer;

import ir.maktab.teravelagancy.model.City;
import ir.maktab.teravelagancy.persentation.TextUtil;
import ir.maktab.teravelagancy.persentation.ui.Input;
import ir.maktab.teravelagancy.service.CityService;

public class CityViewer {
    private final CityService cityService;
    private final TextUtil textUtil;
    public CityViewer(TextUtil textUtil) {
        this.textUtil = textUtil;
        this.cityService = new CityService(textUtil);
    }

    public void addCity() {
        int selectedItem;
        do {
            addCityInternal();
            selectedItem = Input.getInt();
        } while (selectedItem == 1);
    }

    private void addCityInternal() {
        textUtil.print("id=?");
        int id = Input.getInt();
        textUtil.print("name=?");
        String name = Input.getString();
        City city = new City(id, name);
        cityService.addCity(city);
        textUtil.showNextAction(id, city);
    }

    public void removeCity() {
        int id = Input.getInt();
        cityService.deleteCityById(id);
    }
}
