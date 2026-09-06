public class Auto {


    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private String color;


    public Auto(String marca, String modelo, int anio, int kilometraje, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.color = color;
    }

    public void mostrarKilometraje() {
        int kilometros = kilometraje;
        int metros = kilometraje * 1000;

        System.out.println("Kilometraje: " + kilometros + " km");
        System.out.println("Kilometraje: " + metros + " metros");
    }


    public void cambiarColor(String nuevoColor) {
        color = nuevoColor;
    }


    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Kilometraje: " + kilometraje + " km");
        System.out.println("Color: " + color);
    }
}