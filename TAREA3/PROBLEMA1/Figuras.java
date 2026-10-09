abstract class Figura {
protected String color;


public Figura(String color) {
    this.color = color;
}

public abstract double obtenerArea();


}

class Cuadrado extends Figura {
private int lado;


public Cuadrado(String color, int lado) {
    super(color);
    this.lado = lado;
}

@Override
public double obtenerArea() {
    return lado * lado;
}


}

class Triangulo extends Figura {
private int lado1;
private int lado2;
private int lado3;


public Triangulo(String color, int lado1, int lado2, int lado3) {
    super(color);
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
}

@Override
public double obtenerArea() {
    double s = (lado1 + lado2 + lado3) / 2.0;

    return Math.sqrt(s * (s - lado1)
            * (s - lado2) * (s - lado3));
}


}

class Redondo extends Figura {
private int radio;


public Redondo(String color, int radio) {
    super(color);
    this.radio = radio;
}

@Override
public double obtenerArea() {
    return Math.PI * radio * radio;
}


}

class Figuras {

public static void Figuras(String[] args) {
Cuadrado c1 = new Cuadrado("Rojo", 5);
Cuadrado c2 = new Cuadrado("Azul", 3);


    Triangulo t1 = new Triangulo("Verde", 3, 4, 5);
    Triangulo t2 = new Triangulo("Amarillo", 6, 6, 6);

    Redondo r1 = new Redondo("Morado", 4);
    Redondo r2 = new Redondo("Naranja", 2);

    System.out.println("CUADRADOS");
    System.out.println(c1.color + ": " + c1.obtenerArea());
    System.out.println(c2.color + ": " + c2.obtenerArea());

    System.out.println("\nTRIANGULOS");
    System.out.println(t1.color + ": " + t1.obtenerArea());
    System.out.println(t2.color + ": " + t2.obtenerArea());

    System.out.println("\nREDONDOS");
    System.out.println(r1.color + ": " + r1.obtenerArea());
    System.out.println(r2.color + ": " + r2.obtenerArea());

    System.out.println("\nCOMPARACION");

    if (c1.obtenerArea() > t1.obtenerArea()) {
        System.out.println("El cuadrado tiene mayor area.");
        System.out.println("Color: " + c1.color);
    } else if (t1.obtenerArea() > c1.obtenerArea()) {
        System.out.println("El triangulo tiene mayor area.");
        System.out.println("Color: " + t1.color);
    } else {
        System.out.println("Ambas figuras tienen la misma area.");
    }
}


}
