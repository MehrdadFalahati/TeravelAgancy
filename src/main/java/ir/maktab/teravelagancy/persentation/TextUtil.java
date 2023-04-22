package ir.maktab.teravelagancy.persentation;

import ir.maktab.teravelagancy.model.BaseModel;
import ir.maktab.teravelagancy.persentation.ui.Output;

public class TextUtil {

    private final Output output;

    public TextUtil(Output output) {
        this.output = output;
    }

    public void showAddMenu() {
        output.print("Select model:");
        output.print("1. City");
        output.print("2. Road");
    }

    public void showNextAction(int id, BaseModel model) {
        final String saveText = model + " with id=" + id + " added!";
        output.print(saveText);
        output.print("Select your next action");
        output.print("1. Add another " + model);
        output.print("2. Main Menu");
    }

    public void print(String text) {
        output.print(text);
    }
}
