import java.util.ArrayList;
import java.util.List;

public class Compositee {
    public static void main(String[] args) {
        Shape Squqrtee1 = new Squartee();
        Shape Squqrtee2 = new Squartee();
        Shape Squqrtee3 = new Squartee();
        Shape Circlee = new Circlee();
        Shape Trianglee = new Trianglee();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(Circlee);
        composite2.addComponent(Squqrtee2);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.Draw();


    }

}
interface Shape {
    void Draw();
}
class Squartee implements Shape{

    @Override
    public void Draw() {
        System.out.println("Я квадрат");
        }
}
class Trianglee implements Shape{

    @Override
    public void Draw() {
        System.out.println("Я треугольник");
    }
}
class Circlee implements Shape{

    @Override
    public void Draw() {
        System.out.println("Я круг  ");
    }
}
class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component) {
        components.remove(component);
    }
        @Override
    public void Draw() {
        for (Shape component : components){
            component.Draw();
        }


    }
}