public class Builder {

    public static void main(String[] args) {
        Car car = new CarBilder()
                .buildMake("cw")
                .builTransmission(Transmission.MANUAl)
                .buildMax(134)
                .bild();
        System.out.println(car);

    }
}

enum Transmission {
    MANUAl, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int Max;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMax(int max) {
        this.Max = max;
    }

    @Override
    public String toString() {
        return "Car [ make = " + make + "Transmission " + transmission + " Spead " + Max + "]";
    }
}

class CarBilder {
    String m = "Def";
    Transmission t = Transmission.AUTO;
    int s = 120;

    CarBilder buildMake(String m) {
        this.m = m;
        return this;
    }

    CarBilder builTransmission(Transmission t) {
        this.t = t;
        return this;
    }

    CarBilder buildMax(int s) {
        this.s = s;
        return this;
    }

    Car bild() {
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMax(s);
        return car;
    }
}