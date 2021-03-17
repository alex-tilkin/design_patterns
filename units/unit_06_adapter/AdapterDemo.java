package unit_06_adapter;


class Line {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")");
    }
}

class Quadrate {
    public void draw(int x, int y, int width, int height) {
        System.out.println("Quadrate with coordinate left-down point (" + x + ";" + y + "), width: " + width + ", height: " + height);
    }
}

interface IShape {
    void draw(int x, int y, int z, int j);
}

class LineAdapter implements IShape {
    private Line adaptee;

    public LineAdapter(Line line) {
        this.adaptee = line;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        adaptee.draw(x1, y1, x2, y2);
    }
}

class QuadrateAdapter implements IShape {
    private Quadrate adaptee;

    public QuadrateAdapter(Quadrate quadrate) {
        this.adaptee = quadrate;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        adaptee.draw(x, y, width, height);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        IShape[] shapes = {
        		new QuadrateAdapter(new Quadrate()), 
        		new LineAdapter(new Line())
        		};
        
        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 60;
        
        System.out.println("Drawing shapes using a common interface IShape");
        for (IShape shape : shapes) {
            shape.draw(x1, y1, x2, y2);
        }
    }
}