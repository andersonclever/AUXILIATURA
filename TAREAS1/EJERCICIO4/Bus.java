public class Bus {

    private int capacidad;
    private int pasajeros;
    private double precioPasaje;

  
    public Bus(int capacidad) {
        this.capacidad = capacidad;
        pasajeros = 0;
        precioPasaje = 1.50;
    }

   
    public void subirPasajeros(int cantidad) {

        if (cantidad <= 0) {
            System.out.println("Error: la cantidad debe ser mayor que 0.");

        } else if (pasajeros + cantidad > capacidad) {
            System.out.println("No pueden subir todos los pasajeros.");
            System.out.println("No hay suficientes asientos.");

        } else {
            pasajeros = pasajeros + cantidad;
            System.out.println(cantidad + " pasajeros subieron al bus.");
        }
    }

  
    public void cobrarPasaje() {

        double total = pasajeros * precioPasaje;

        System.out.println("Pasajeros: " + pasajeros);
        System.out.println("Precio del pasaje: Bs. " + precioPasaje);
        System.out.println("Total recaudado: Bs. " + total);
    }

  
    public void mostrarAsientosDisponibles() {

        int disponibles = capacidad - pasajeros;

        System.out.println("Asientos disponibles: " + disponibles);
    }

  
    public void mostrarDatos() {

        System.out.println("Capacidad del bus: " + capacidad);
        System.out.println("Pasajeros actuales: " + pasajeros);
        System.out.println("Precio del pasaje: Bs. " + precioPasaje);
    }
}