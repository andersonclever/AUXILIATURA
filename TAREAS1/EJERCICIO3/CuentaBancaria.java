public class CuentaBancaria {


    private String titular;
    private String proCuenta;
    private double saldo;

    
    public CuentaBancaria(String titular, String proCuenta, double saldo) {
        this.titular = titular;
        this.proCuenta = proCuenta;
        this.saldo = saldo;
    }


    public void depositar(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("Error: el depósito debe ser mayor que 0.");
        } else {
            saldo = saldo + cantidad;
            System.out.println("Depósito realizado correctamente.");
        }
    }


    public void retirar(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("Error: el retiro debe ser mayor que 0.");
        } else if (cantidad > saldo) {
            System.out.println("Error: no hay suficiente dinero en la cuenta.");
        } else {
            saldo = saldo - cantidad;
            System.out.println("Retiro realizado correctamente.");
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + proCuenta);
        System.out.println("Saldo: Bs. " + saldo);
    }
}