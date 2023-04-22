package ir.maktab.teravelagancy;

import ir.maktab.teravelagancy.persentation.Menu;
import ir.maktab.teravelagancy.persentation.ui.StandardOutput;

public class Main {

    public static void main(String[] args) {
        new Menu(new StandardOutput()).startApplication();
    }
}
