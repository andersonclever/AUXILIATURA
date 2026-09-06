import java.util.Scanner;

public class TestBus {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Bus bus = new Bus(40);

        System.out.println("----- DATOS DEL BUS -----");
        bus.mostrarDatos();

     
        System.out.print("\n¿Cuántos pasajeros desean subir? ");
        int cantidad = teclado.nextInt();

    
        bus.subirPasajeros(cantidad);

        System.out.println("\n----- ASIENTOS -----");
        bus.mostrarAsientosDisponibles();

        System.out.println("\n----- COBRO -----");
        bus.cobrarPasaje();

        teclado.close();
    }
}