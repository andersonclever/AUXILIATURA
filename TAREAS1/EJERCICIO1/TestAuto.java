public class TestAuto {

    public static void main(String[] args) {

        Auto auto1 = new Auto("Toyota", "Corolla", 2020, 50000, "Rojo");
        Auto auto2 = new Auto("Nissan", "Sentra", 2022, 30000, "Azul");

       
        System.out.println("----- AUTO 1 -----");
        auto1.mostrarDatos();

        System.out.println("\nKilometraje:");
        auto1.mostrarKilometraje();

       
        System.out.println("\n----- AUTO 2 -----");
        auto2.mostrarDatos();

        System.out.println("\nKilometraje:");
        auto2.mostrarKilometraje();

   
        auto1.cambiarColor("Negro");
        auto2.cambiarColor("Blanco");

       
        System.out.println("\n----- AUTOS CON NUEVO COLOR -----");

        auto1.mostrarDatos();

        System.out.println();

        auto2.mostrarDatos();
    }
}