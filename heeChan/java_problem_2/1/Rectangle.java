package practice;

public class Rectangle extends AbstractShape{
    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public double getArea() {


        return getX()*getY();
    }
}
