import java.util.Scanner;

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);

        System.out.print("Ingrese el nombre de la nave a buscar: ");
        String nombreBuscado = sc.next();
        mostrarPorNombre(misNaves, nombreBuscado);

        System.out.print("Ingrese el número de puntos máximo: ");
        int puntosMaximos = sc.nextInt();
        mostrarPorPuntos(misNaves, puntosMaximos);

        System.out.println("\nNave con mayor número de puntos:");
        Nave naveMayorPuntos = mostrarMayorPuntos(misNaves);
        if (naveMayorPuntos != null) {
            naveMayorPuntos.mostrarInformacion();
        } else {
            System.out.println("No se encontró ninguna nave activa.");
        }

        ordenarPorPuntosBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por puntos (Burbuja):");
        mostrarNaves(misNaves);

        ordenarPorNombreBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Burbuja):");
        mostrarNaves(misNaves);

        ordenarPorPuntosSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (Selección):");
        mostrarNaves(misNaves);

        ordenarPorNombreSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Selección):");
        mostrarNaves(misNaves);

        ordenarPorPuntosInsercion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (Inserción):");
        mostrarNaves(misNaves);

        ordenarPorNombreInsercion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Inserción):");
        mostrarNaves(misNaves);
    }

    static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            nave.mostrarInformacion();
        }
    }

    static void mostrarPorNombre(Nave[] flota, String nombre) {
        boolean encontrado = false;
        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombre)) {
                nave.mostrarInformacion();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nave no encontrada.");
        }
    }

    static void mostrarPorPuntos(Nave[] flota, int puntosMaximos) {
        System.out.println("Naves con puntos menores o iguales a " + puntosMaximos + ":");
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMaximos) {
                nave.mostrarInformacion();
            }
        }
    }

    static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave mayorPuntos = null;
        for (Nave nave : flota) {
            if (mayorPuntos == null || nave.getPuntos() > mayorPuntos.getPuntos()) {
                mayorPuntos = nave;
            }
        }
        return mayorPuntos;
    }

    static void ordenarPorPuntosBurbuja(Nave[] flota) {
        int n = flota.length;
        boolean intercambio;
        do {
            intercambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (flota[i].getPuntos() > flota[i + 1].getPuntos()) {
                    // Intercambiar las naves
                    Nave temp = flota[i];
                    flota[i] = flota[i + 1];
                    flota[i + 1] = temp;
                    intercambio = true;
                }
            }
        } while (intercambio);
    }

    static void ordenarPorNombreBurbuja(Nave[] flota) {
        int n = flota.length;
        boolean intercambio;
        do {
            intercambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (flota[i].getNombre().compareToIgnoreCase(flota[i + 1].getNombre()) > 0) {
                    // Intercambiar las naves
                    Nave temp = flota[i];
                    flota[i] = flota[i + 1];
                    flota[i + 1] = temp;
                    intercambio = true;
                }
            }
        } while (intercambio);
    }

}