public class TestCuentaBancaria {

    public static void main(String[] args) {

        CuentaBancaria cuenta =
                new CuentaBancaria("Juan Perez", "0012345", 1000);


        System.out.println("----- DATOS INICIALES -----");
        cuenta.mostrarDatos();

        
        System.out.println("\n----- DEPOSITO -----");
        cuenta.depositar(500);

    
        cuenta.mostrarDatos();

        
        System.out.println("\n----- DEPOSITO INVALIDO -----");
        cuenta.depositar(0);

        
        System.out.println("\n----- RETIRO -----");
        cuenta.retirar(300);

        cuenta.mostrarDatos();

        
        System.out.println("\n----- RETIRO INVALIDO -----");
        cuenta.retirar(5000);

       
        System.out.println("\n----- DATOS FINALES -----");
        cuenta.mostrarDatos();
    }
}