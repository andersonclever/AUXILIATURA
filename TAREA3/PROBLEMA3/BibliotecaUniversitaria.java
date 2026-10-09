import java.util.ArrayList;
import java.util.Iterator;

class Documento {
    protected String titulo;
    protected String autores;
    protected String editorial;
    protected int anioPublicacion;

    public Documento(String titulo, String autores, String editorial, int anioPublicacion) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarDatos() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autores: " + autores);
        System.out.println("Editorial: " + editorial);
        System.out.println("Anio: " + anioPublicacion);
    }
}

class Libro extends Documento {
    public Libro(String titulo, String autores, String editorial, int anioPublicacion) {
        super(titulo, autores, editorial, anioPublicacion);
    }
}

class RevistaPapel extends Documento {
    protected int volumen;
    protected int numero;
    protected String mesSalida;

    public RevistaPapel(String titulo, String autores, String editorial,
                        int anioPublicacion, int volumen, int numero, String mesSalida) {
        super(titulo, autores, editorial, anioPublicacion);
        this.volumen = volumen;
        this.numero = numero;
        this.mesSalida = mesSalida;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Volumen: " + volumen);
        System.out.println("Numero: " + numero);
        System.out.println("Mes de salida: " + mesSalida);
    }
}

class DocumentoCD extends Documento {
    private String formatoCD;
    private String tipoLicencia;

    public DocumentoCD(String titulo, String autores, String editorial,
                       int anioPublicacion, String formatoCD, String tipoLicencia) {
        super(titulo, autores, editorial, anioPublicacion);
        this.formatoCD = formatoCD;
        this.tipoLicencia = tipoLicencia;
    }

    public String getFormatoCD() {
        return formatoCD;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Formato CD: " + formatoCD);
        System.out.println("Tipo de licencia: " + tipoLicencia);
    }
}

class RevistaInvestigacion extends RevistaPapel {
    private String campoInvestigacion;

    public RevistaInvestigacion(String titulo, String autores, String editorial,
                                int anioPublicacion, int volumen, int numero,
                                String mesSalida, String campoInvestigacion) {
        super(titulo, autores, editorial, anioPublicacion, volumen, numero, mesSalida);
        this.campoInvestigacion = campoInvestigacion;
    }

    public String getCampoInvestigacion() {
        return campoInvestigacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Campo de investigacion: " + campoInvestigacion);
    }
}

class Biblioteca {
    private String nombre;
    private ArrayList<Documento> documentos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public int contarDocumentos() {
        return documentos.size();
    }

    public int contarRevistas() {
        int cantidad = 0;

        for (Documento d : documentos) {
            if (d instanceof RevistaPapel) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int contarLibros() {
        int cantidad = 0;

        for (Documento d : documentos) {
            if (d instanceof Libro) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public void mostrarDocumentos() {
        System.out.println("\nBiblioteca: " + nombre);

        for (Documento d : documentos) {
            System.out.println("--------------------");
            d.mostrarDatos();
        }

        System.out.println("Total documentos: " + contarDocumentos());
        System.out.println("Total revistas: " + contarRevistas());
        System.out.println("Total libros: " + contarLibros());
    }

    public void trasladarRevistasA(Biblioteca destino) {
        if (destino == this) {
            return;
        }

        Iterator<Documento> iterador = documentos.iterator();

        while (iterador.hasNext()) {
            Documento d = iterador.next();

            if (d instanceof RevistaPapel) {
                destino.agregarDocumento(d);
                iterador.remove();
            }
        }
    }

    public void trasladarLibrosA(Biblioteca destino) {
        if (destino == this) {
            return;
        }

        Iterator<Documento> iterador = documentos.iterator();

        while (iterador.hasNext()) {
            Documento d = iterador.next();

            if (d instanceof Libro) {
                destino.agregarDocumento(d);
                iterador.remove();
            }
        }
    }

    public Biblioteca copiaSeguridad(String nombreCopia) {
        Biblioteca copia = new Biblioteca(nombreCopia);

        for (Documento d : documentos) {
            copia.agregarDocumento(copiarDocumento(d));
        }

        return copia;
    }

    private Documento copiarDocumento(Documento d) {
        if (d instanceof RevistaInvestigacion) {
            RevistaInvestigacion r = (RevistaInvestigacion) d;

            return new RevistaInvestigacion(
                r.titulo, r.autores, r.editorial, r.anioPublicacion,
                r.volumen, r.numero, r.mesSalida, r.getCampoInvestigacion()
            );
        }

        if (d instanceof RevistaPapel) {
            RevistaPapel r = (RevistaPapel) d;

            return new RevistaPapel(
                r.titulo, r.autores, r.editorial, r.anioPublicacion,
                r.volumen, r.numero, r.mesSalida
            );
        }

        if (d instanceof DocumentoCD) {
            DocumentoCD cd = (DocumentoCD) d;

            return new DocumentoCD(
                cd.titulo, cd.autores, cd.editorial, cd.anioPublicacion,
                cd.getFormatoCD(), cd.getTipoLicencia()
            );
        }

        if (d instanceof Libro) {
            return new Libro(
                d.titulo, d.autores, d.editorial, d.anioPublicacion
            );
        }

        return new Documento(
            d.titulo, d.autores, d.editorial, d.anioPublicacion
        );
    }
}

public class BibliotecaUniversitaria {

    public static void compararBibliotecas(Biblioteca b1, Biblioteca b2) {
        System.out.println("\nCOMPARACION DE BIBLIOTECAS");

        if (b1.contarRevistas() > b2.contarRevistas()) {
            System.out.println(b1.getNombre() + " tiene mas revistas.");
        } else if (b2.contarRevistas() > b1.contarRevistas()) {
            System.out.println(b2.getNombre() + " tiene mas revistas.");
        } else {
            System.out.println("Ambas tienen igual cantidad de revistas.");
        }

        if (b1.contarDocumentos() > b2.contarDocumentos()) {
            System.out.println(b1.getNombre() + " tiene mas documentos.");
        } else if (b2.contarDocumentos() > b1.contarDocumentos()) {
            System.out.println(b2.getNombre() + " tiene mas documentos.");
        } else {
            System.out.println("Ambas tienen igual cantidad de documentos.");
        }
    }

    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Biblioteca Central");
        Biblioteca b2 = new Biblioteca("Biblioteca de Informatica");

        b1.agregarDocumento(new Libro(
            "Java Basico", "Autor A", "Editorial A", 2024));

        b1.agregarDocumento(new RevistaPapel(
            "Ciencia", "Autor B", "Editorial B", 2025, 2, 10, "Marzo"));

        b1.agregarDocumento(new RevistaInvestigacion(
            "Inteligencia Artificial", "Autor C", "Editorial C",
            2026, 1, 5, "Abril", "Computacion"));

        b1.agregarDocumento(new DocumentoCD(
            "Curso Java", "Autor D", "Editorial D", 2023, "DVD", "Libre"));

        b2.agregarDocumento(new Libro(
            "Estructuras de Datos", "Autor E", "Editorial E", 2025));

        b2.agregarDocumento(new Libro(
            "Algoritmos", "Autor F", "Editorial F", 2024));

        b2.agregarDocumento(new RevistaPapel(
            "Tecnologia", "Autor G", "Editorial G", 2025, 3, 7, "Junio"));

        b2.agregarDocumento(new DocumentoCD(
            "Linux", "Autor H", "Editorial H", 2024, "CD", "GPL"));


        // AUXI AQUI LE MUESTRO LOS ENCISOS 
        // Inciso b: comparar las bibliotecas antes de los traslados
        compararBibliotecas(b1, b2);

        // Inciso c: trasladar todas las revistas a la primera biblioteca
        b2.trasladarRevistasA(b1);

        // Inciso c: trasladar todos los libros a la segunda biblioteca
        b1.trasladarLibrosA(b2);

        System.out.println("\nDESPUES DE LOS TRASLADOS");
        b1.mostrarDocumentos();
        b2.mostrarDocumentos();

        // Inciso d: crear copias de seguridad independientes
        Biblioteca respaldo1 = b1.copiaSeguridad("Respaldo Central");
        Biblioteca respaldo2 = b2.copiaSeguridad("Respaldo Informatica");

        System.out.println("\nCOPIAS DE SEGURIDAD");
        respaldo1.mostrarDocumentos();
        respaldo2.mostrarDocumentos();
    }
}