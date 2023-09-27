public class Nave {
    private String nombre;
    private int fila;
    private String columna;
    private boolean estado;
    private int puntos;

    // Constructor
    public Nave(String nombre, int fila, String columna, boolean estado, int puntos) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.puntos = puntos;
    }

    // Métodos mutadores
    public void setNombre(String n) {
        nombre = n;
    }

    public void setFila(int f) {
        fila = f;
    }

    public void setColumna(String c) {
        columna = c;
    }

    public void setEstado(boolean e) {
        estado = e;
    }

    public void setPuntos(int p) {
        puntos = p;
    }

    // Métodos accesores
    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getPuntos() {
        return puntos;
    }

    // Método para mostrar información de la nave
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fila: " + fila);
        System.out.println("Columna: " + columna);
        System.out.println("Estado: " + (estado ? "Activa" : "Inactiva"));
        System.out.println("Puntos: " + puntos);
    }

    // Método para recibir daño
    public void recibirDanio(int cantidadDanio) {
        if (estado) {
            puntos -= cantidadDanio;
            if (puntos <= 0) {
                estado = false;
                puntos = 0;
            }
        }
    }
}