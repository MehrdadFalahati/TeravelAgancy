package ir.maktab.teravelagancy.model;

public class BaseModel {
    protected final int id;
    protected final String name;

    public BaseModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
