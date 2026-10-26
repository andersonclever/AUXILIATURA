

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jaeger
 */
public class COmpAgrega {

    public static void main(String[] args) {
        Pantalla p = new Pantalla();
        
        Laptop lap = new Laptop("samsung", 3, "lcd ips", 13, 7);
        Laptop lap1 = new Laptop("samsung", 12, "lcd ips", 13, 7);
        Laptop lap2 = new Laptop("samsung", 6, "lcd ips", 13, 7);
        Laptop lap3 = new Laptop("samsung", 24, "lcd ips", 13, 7);
        ArrayList<Laptop> vec = new ArrayList<>();
        vec.add(lap);
        vec.add(lap1);
        vec.add(lap2);
        vec.add(lap3);
        
        // inciso b
        int may = 0;
        for (Laptop l : vec) {
            if (l.getCantApp() > may) {
                may = l.getCantApp();
            }
        }
        for (Laptop l : vec) {
            if (l.getCantApp() == may) {
                System.out.println(l);
            }
        }
        
        Scanner te = new Scanner(System.in);
        
        // inciso c
        String x = te.nextLine();
        for (Laptop laptop : vec) {
            if (laptop.getModelo().equals(x)) {
                String nom = te.nextLine();
                int tam = te.nextInt();
                te.nextLine(); // limpiar buffer
                laptop.agregaApp(new Aplicacion(nom, tam));
            }
        }
        
        // inciso d
        int anchoY = te.nextInt();
        te.nextLine(); // limpiar buffer
        for (Laptop laptop : vec) {
            if (laptop.getPantalla().getAncho() == anchoY) {
                laptop.eliminarApps();
            }
        }
        
        // inciso e
        may = 0;
        for (Laptop l : vec) {
            if (l.getCantApp() > may) {
                may = l.getCantApp();
            }
        }
        for (Laptop l : vec) {
            if (l.getCantApp() == may) {
                System.out.println(l);
            }
        }
        
        // inciso f 
        for (Laptop l : vec) {
            l.getApps().sort((a1, a2) -> {
                if (a2.getTamanio() != a1.getTamanio()) {
                    return Integer.compare(a2.getTamanio(), a1.getTamanio());
                } else {
                    return a1.getNombre().compareTo(a2.getNombre());
                }
            });
        }
    }
}

class Laptop {
    private String modelo;
    private int cantApp;
    private ArrayList<Aplicacion> apps = new ArrayList<>();
    private Pantalla pantalla = new Pantalla();

    public Laptop(String modelo, int cantApp, String tipo, int ancho, int alto) {
        this.modelo = modelo;
        this.cantApp = cantApp;
        this.pantalla = new Pantalla(tipo, ancho, alto);
    }

    public void agregaApp(Aplicacion app) {
        this.apps.add(app);
        this.cantApp++;
    }

    public void eliminarApps() {
        this.apps.clear();
        this.cantApp = 0;
    }

    public int getCantApp() {
        return this.cantApp;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Pantalla getPantalla() {
        return this.pantalla;
    }

    public ArrayList<Aplicacion> getApps() {
        return this.apps;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCantApp(int cantApp) {
        this.cantApp = cantApp;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return "Laptop{" + "modelo=" + modelo + ", cantApp=" + cantApp + ", pantalla=" + pantalla + ", apps=" + apps + '}';
    }
}

class Pantalla {
    private String tipo;
    private int alto;
    private int ancho;

    public Pantalla(String tipo, int alto, int ancho) {
        this.tipo = tipo;
        this.alto = alto;
        this.ancho = ancho;
    }

    public Pantalla() {
        this.tipo = "amoled";
        this.alto = 6;
        this.ancho = 7;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Pantalla{" + "tipo=" + tipo + ", alto=" + alto + ", ancho=" + ancho + '}';
    }
}

class Aplicacion {
    private String nombre;
    private int tamanio;

    public Aplicacion(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    public Aplicacion() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    @Override
    public String toString() {
        return "Aplicacion{" + "nombre=" + nombre + ", tamanio=" + tamanio + '}';
    }
}