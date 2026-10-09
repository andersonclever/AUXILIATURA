class Animal {
protected int edad;
protected double peso;
protected String especie;


public Animal(int edad, double peso, String especie) {
    this.edad = edad;
    this.peso = peso;
    this.especie = especie;
}

public void mostrarDatos() {
    System.out.println("Edad: " + edad);
    System.out.println("Peso: " + peso);
    System.out.println("Especie: " + especie);
}


}

class Terrestre extends Animal {
private int numeroPatas;
private double velocidad;


public Terrestre(int edad, double peso, String especie,
                 int numeroPatas, double velocidad) {
    super(edad, peso, especie);
    this.numeroPatas = numeroPatas;
    this.velocidad = velocidad;
}

public void caminar() {
    System.out.println(especie + " esta caminando.");
}

public void correr() {
    System.out.println(especie + " corre a " + velocidad + " km/h.");
}


}

class Aereo extends Animal {
private double alturaVuelo;
private double envergadura;


public Aereo(int edad, double peso, String especie,
             double alturaVuelo, double envergadura) {
    super(edad, peso, especie);
    this.alturaVuelo = alturaVuelo;
    this.envergadura = envergadura;
}

public void volar() {
    System.out.println(especie + " esta volando a "
            + alturaVuelo + " metros.");
}

public void aterrizar() {
    System.out.println(especie + " esta aterrizando.");
}

}

class Acuatico extends Animal {
private double profundidad;
private boolean aguaSalada;


public Acuatico(int edad, double peso, String especie,
                double profundidad, boolean aguaSalada) {
    super(edad, peso, especie);
    this.profundidad = profundidad;
    this.aguaSalada = aguaSalada;
}

public void nadar() {
    System.out.println(especie + " esta nadando.");
}

public void sumergirse() {
    System.out.println(especie + " puede sumergirse hasta "
            + profundidad + " metros.");
}


}

public class Animales {
public static void main(String[] args) {


    Terrestre t = new Terrestre(5, 80, "Perro", 4, 40);
    Aereo a = new Aereo(2, 1.5, "Aguila", 3000, 2.0);
    Acuatico ac = new Acuatico(3, 25, "Delfin", 300, false);

    System.out.println("ANIMAL TERRESTRE");
    t.mostrarDatos();
    t.caminar();
    t.correr();

    System.out.println("\nANIMAL AEREO");
    a.mostrarDatos();
    a.volar();
    a.aterrizar();

    System.out.println("\nANIMAL ACUATICO");
    ac.mostrarDatos();
    ac.nadar();
    ac.sumergirse();
}


}
