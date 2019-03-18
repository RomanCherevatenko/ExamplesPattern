public class Singleton {
    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;                     //Создание 1000 потоков
        Thread t[] = new Thread[SIZE];            //    Инициализируем каждый потом новым экземпляром потока  и
                                                 // передаем в него экземпляр нащего класа
                                                 //который реализует интерыейс
         for (int i=0;i<SIZE;i++){
            t[i] = new Thread(new R());
            t[i].start();                     //тут же стартуем наши потоки
        }
        for (int i=0;i<SIZE;i++){
            t[i].join();                 //приесоедениться к потоку t[i]       //что бы у нас не пролетело стару на SOUT ,а что бы мы подождали когда все потоки выполняться
        }

            System.out.println(Singletonn.counter   );

    }
}
class R implements Runnable{

    @Override
    public void run() {
        Singletonn.getInstance();

    }
}

class Singletonn {
    public static int counter = 0;
    private static volatile Singletonn instance = null;
    private Singletonn() {
        counter++;
    }

    public static Singletonn getInstance() {      // Безопасный метод для работы в многопоточной среде .
        if (instance == null) {
            synchronized (Singletonn.class) {
                if (instance == null) {
                }
                instance = new Singletonn();
            }
        }return instance;
    }
}