import java.util.Scanner;

public class TestComputadora {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

    
        Computadora computadora1 =
                new Computadora("HP", "Intel Core i5", 8, 512);

        Computadora computadora2 =
                new Computadora("Lenovo", "AMD Ryzen 7", 16, 1000);

       
        System.out.println("----- COMPUTADORA 1 -----");
        computadora1.mostrarDatos();

        System.out.println("\n----- COMPUTADORA 2 -----");
        computadora2.mostrarDatos();


        System.out.print("\nIngrese la cantidad de RAM X: ");
        int x = teclado.nextInt();

        System.out.println("\nResultado:");

        if (computadora1.tieneRam(x)) {
            System.out.println("La computadora 1 tiene " + x + " GB de RAM.");
        }

        if (computadora2.tieneRam(x)) {
            System.out.println("La computadora 2 tiene " + x + " GB de RAM.");
        }

        if (!computadora1.tieneRam(x) && !computadora2.tieneRam(x)) {
            System.out.println("Ninguna computadora tiene " + x + " GB de RAM.");
        }

   
        System.out.println("\n----- MAYOR ALMACENAMIENTO -----");

        if (computadora1.getAlmacenamiento() >
            computadora2.getAlmacenamiento()) {

            computadora1.mostrarDatos();

        } else {

            computadora2.mostrarDatos();
        }

        teclado.close();
    }
}