public class Bridge {
    public static void main(String[] args) {
        Carr c = new Sedan(new Kia());
                c.ShowDetails();

    }
}

abstract class Carr {
    Make make;

    public Carr(Make m) {
        make = m;
    }
    abstract void ShowDetails();

}

class Sedan extends Carr {

    public Sedan(Make m) {
        super(m);

    }

    @Override
    void ShowDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}

class Hatchback extends Carr {

    public Hatchback(Make m) {
        super(m);

    }

    @Override
    void ShowDetails() {
        System.out.println("Hatchback");
        make.setMake();
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {

    @Override
    public void setMake() {
        System.out.println("Kia");

    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");

    }
}