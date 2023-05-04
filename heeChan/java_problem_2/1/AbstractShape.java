package practice;

public abstract class AbstractShape {


    private int x;
    private int y;
    private int r;
    public AbstractShape(int r) {
        this.r = r;
    }
    public AbstractShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }


    public abstract double getArea();

}
