package pl.edu.pjatk.tau;

import java.util.List;

public class ZbiorObiektow {
    private List<Obiekt> obiekty = new List<Obiekt>;

    public List<Obiekt> getObiekty() {
        return obiekty;
    }

    public void setObiekty(List<Obiekt> obiekty) {
        if(obiekty != null)
            this.obiekty = obiekty;
    }

    public void addObiekt(Obiekt obiekt) {
        obiekty.add(obiekt);
    }

    public void addObiekt(String name) {
        obiekty.add(new Obiekt(name));
    }

    public void removeObiekt(Obiekt obiekt) {
        if(obiekty.contains(obiekt))
            obiekty.remove(obiekt);
    }

    public void updateObject(Obiekt obiekt) {

    }
}

