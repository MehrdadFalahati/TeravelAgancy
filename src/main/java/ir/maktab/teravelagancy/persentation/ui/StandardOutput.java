package ir.maktab.teravelagancy.persentation.ui;

public class StandardOutput implements Output {

    @Override
    public void print(String output) {
        System.out.println(output);
    }

    @Override
    public void close() {
        System.out.println("Exit!");
    }
}
