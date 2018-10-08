package pl.edu.pjatk.tau;

public class Obiekt {
    private static int counter = 0;

    private int ID;
    private String name;

    public Obiekt(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
