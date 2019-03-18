public abstract class AbstractFactor {
    public static void main(String[] args) {


    DeviceFactory factory = getFactoryByCountreCod("En");
    Mouse m = factory.getMouse();
    Keyboard k = factory.getKeyboard();
    Touchpad t = factory.getTouchpad();

    m.click();
    k.print();
    k.println();
    t.track(20,20);

}
    public static DeviceFactory getFactoryByCountreCod (String lang){
        switch (lang){
            case "Ru":
                return new RuDeviceFactory();
            case "En":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }

    public static void printMassage(String massage) {
        System.out.println(massage);
    }
}

interface Mouse {
    void click();

    void dbClick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();

}

class RuMous implements Mouse {

    @Override
    public void click() {
        AbstractFactor.printMassage("Один  щелчок");
    }

    @Override
    public void dbClick() {
        AbstractFactor.printMassage("Двойной елчок");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            AbstractFactor.printMassage("Скроллим вверх");
        } else if (direction < 0)
            AbstractFactor.printMassage("Скроллим вниз");
        else
            AbstractFactor.printMassage("Не скролим");
    }

}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        AbstractFactor.printMassage("Печатаем строку");
    }

    @Override
    public void println() {
        AbstractFactor.printMassage("Печатаем строку с переходом строки ");
    }
}

class RuTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        AbstractFactor.printMassage("Продвинулись  на " + s + "пикселей");
    }
}

class EnMous implements Mouse {

    @Override
    public void click() {
        AbstractFactor.printMassage("One click");
    }

    @Override
    public void dbClick() {
        AbstractFactor.printMassage("Double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            AbstractFactor.printMassage("Scroll up");
        } else if (direction < 0)
            AbstractFactor.printMassage("Scroll down");
        else
            AbstractFactor.printMassage("No scrolling");
    }

}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        AbstractFactor.printMassage("Print");
    }

    @Override
    public void println() {
        AbstractFactor.printMassage("Print line  ");
    }
}

class EnTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        AbstractFactor.printMassage("Moved " + s + "pix");
    }
}

class RuDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new RuMous();
    }

    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class EnDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new EnMous();
    }

    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}






















