package ir.maktab.teravelagancy.persentation.ui;

import ir.maktab.teravelagancy.exception.InvalidDataException;

import java.util.Scanner;

public class Input {

    private static final Scanner INPUT = new Scanner(System.in);

    public static String getString() {
        String next = INPUT.nextLine();
        if (next.equals("") || next.equals(" "))
            throw new InvalidDataException("Invalid input. Please enter 1 for more info.");
        return next;
    }

    public static int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (Exception e) {
            throw new InvalidDataException("Invalid input. Please enter 1 for more info.");
        }
    }
}
