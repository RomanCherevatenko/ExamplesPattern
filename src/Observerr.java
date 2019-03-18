import java.util.ArrayList;
import java.util.List;

public class Observerr {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.setMeasurements(23,787);

    }
}
interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
interface Observer{
    void handleEvent(int temp ,int pressed);

}
class MeteoStation implements Observed{
     private int temperature ;
     private int pressure;
   private List<Observer> observers = new ArrayList<>();
    public void setMeasurements (int t, int p){
        temperature = t;
        pressure = p;
        notifyObserver();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObserver() {
        for (Observer o : observers){
            o.handleEvent(temperature,pressure);
        }
    }
}
class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int pressed) {
        System.out.println("Погода изменилась.Температура -" + temp + "Давление =  " + pressed);
    }
}