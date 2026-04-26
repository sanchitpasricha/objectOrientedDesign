package practice.abstraction;

// Abstract class cannot instantiated it can only be extended and implemented
abstract class Shape {
    protected String color;
    protected double area;
    
    public Shape(String color){
        this.color = color;
    } 

    public abstract double area();

    public void displayColor(){
        System.out.println("This shape is "+ color);
    }
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable{
    private double radius;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a cirlce");
    }
}

class ShapeMain {
    public static void main(String[] args) {
        Shape circle = new Circle("red", 5.0);
        circle.displayColor();
        System.out.println("Area: " + circle.area());
    }
}
