package ir.maktab.teravelagancy.persentation.cmd;

import ir.maktab.teravelagancy.persentation.ui.Output;

public class HelpCommand implements MenuCommand {
    private final Output output;

    public HelpCommand(Output output) {
        this.output = output;
    }

    @Override
    public int select() {
        return 1;
    }

    @Override
    public void execute() {
        output.print("Select a number from shown menu and enter. For example 1 is for help.");
    }
}
