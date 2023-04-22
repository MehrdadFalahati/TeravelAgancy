package ir.maktab.teravelagancy.persentation;

import ir.maktab.teravelagancy.exception.InvalidDataException;
import ir.maktab.teravelagancy.persentation.cmd.*;
import ir.maktab.teravelagancy.persentation.ui.Input;
import ir.maktab.teravelagancy.persentation.ui.Output;

import java.util.List;

public class Menu {
    private final Output output;
    private final MenuCommandExecutor menuCommandExecutor;

    public Menu(Output output) {
        this.output = output;
        this.menuCommandExecutor = new MenuCommandExecutor(initialCommand());
    }

    private List<MenuCommand> initialCommand() {
        return List.of(new HelpCommand(output),
                new AddItemCommand(output), new DeleteItemCommand(output),
                new PathCommand(output));
    }

    public void startApplication() {
        boolean showMenu = true;
        while (showMenu) {
            menu();
            try {
                showMenu = chooseMenu();
            } catch (InvalidDataException e) {
                output.print(e.getMessage());
            }
        }
        output.close();
    }

    private boolean chooseMenu() {
        int selected = Input.getInt();
        if (selected >= 5)
            return false;
        menuCommandExecutor.execute(selected);
        return true;
    }

    private void menu() {
        output.print("Main Menu - Select an action:");
        output.print("1. Help");
        output.print("2. Add");
        output.print("3. Delete");
        output.print("4. Path");
        output.print("5. Exit");
    }
}
