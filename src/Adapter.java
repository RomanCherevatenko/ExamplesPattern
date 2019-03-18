import java.awt.image.Raster;

public class Adapter {
    public static void main(String[] args) {
        VectorGrafhicsInterface vectorGrafhicsInterface = new VectorAdapterFromRAster();
        vectorGrafhicsInterface.drawLine();
        vectorGrafhicsInterface.drawSquare();

        VectorGrafhicsInterface vectorGrafhicsInterface2 = new VectorAdapterFromRAster();
        vectorGrafhicsInterface.drawLine();
        vectorGrafhicsInterface.drawSquare();

    }
}

interface VectorGrafhicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRAster extends RasterGraphics implements VectorGrafhicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRAster2 implements VectorGrafhicsInterface{
  RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();

    }
}