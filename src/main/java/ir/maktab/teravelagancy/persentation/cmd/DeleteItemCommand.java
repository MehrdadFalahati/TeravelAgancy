package ir.maktab.teravelagancy.persentation.cmd;

import ir.maktab.teravelagancy.persentation.TextUtil;
import ir.maktab.teravelagancy.persentation.ui.Input;
import ir.maktab.teravelagancy.persentation.ui.Output;
import ir.maktab.teravelagancy.persentation.viewer.CityViewer;
import ir.maktab.teravelagancy.persentation.viewer.RoadViewer;

public class DeleteItemCommand implements MenuCommand {
    private final TextUtil textUtil;
    private final CityViewer cityViewer;
    private final RoadViewer roadViewer;

    public DeleteItemCommand(Output output) {
        this.textUtil = new TextUtil(output);
        cityViewer = new CityViewer(textUtil);
        roadViewer = new RoadViewer(textUtil);
    }

    @Override
    public int select() {
        return 3;
    }

    @Override
    public void execute() {
        textUtil.showAddMenu();
        int selectedItem = Input.getInt();
        if (selectedItem == 1)
            cityViewer.removeCity();
        else if (selectedItem == 2)
            roadViewer.removeRoad();
    }
}
