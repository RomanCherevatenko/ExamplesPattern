public class Delegate {
    public static void main(String[] args) {

        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();

    }
}
interface Graphics{
    void draw();
}
class Triangle implements Graphics{

    @Override
    public void draw() {
        System.out.println("Рисуем Треугольник");
    }
}
class Square implements Graphics{

    @Override
    public void draw() {
        System.out.println("Рисуем Квадрат");
    }
}
class Circle implements Graphics{

    @Override
    public void draw() {
        System.out.println("Рисуем круг");
    }
}
class Painter {
    Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;

    }
    void draw(){
        graphics.draw();
    }
}

