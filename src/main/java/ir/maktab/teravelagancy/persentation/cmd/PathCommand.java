package ir.maktab.teravelagancy.persentation.cmd;

import ir.maktab.teravelagancy.persentation.TextUtil;
import ir.maktab.teravelagancy.persentation.ui.Input;
import ir.maktab.teravelagancy.persentation.ui.Output;
import ir.maktab.teravelagancy.persentation.viewer.PathViewer;

public class PathCommand implements MenuCommand {
    private final PathViewer pathViewer;

    public PathCommand(Output output) {
        pathViewer =  new PathViewer(new TextUtil(output));
    }

    @Override
    public int select() {
        return 4;
    }

    @Override
    public void execute() {
        String path = Input.getString();
        String [] fromCityToCity = path.split(":");
        int from = Integer.parseInt(fromCityToCity[0]);
        int to = Integer.parseInt(fromCityToCity[1]);
        pathViewer.showPath(from, to);
    }
}
