public class Computadora {

    private String marca;
    private String procesador;
    private int ram;
    private int almacenamiento;

   
    public Computadora(String marca, String procesador, int ram, int almacenamiento) {
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
    }

    public boolean tieneRam(int x) {
        return ram == x;
    }

  
    public int getAlmacenamiento() {
        return almacenamiento;
    }


    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Procesador: " + procesador);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Almacenamiento: " + almacenamiento + " GB");
    }
}