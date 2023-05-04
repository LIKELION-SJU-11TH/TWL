package practice;

public class Circle extends AbstractShape{

    public Circle(int r) {
        super(r);
    }

    @Override
    public double getArea() {
        final double PI=3.14;
        return getR()*getR()*PI;
    }
}
