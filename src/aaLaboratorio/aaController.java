package aaLaboratorio;

import aaLaboratorio.aaProterozoico.*;
import aaLaboratorio.aaProterozoico.aaFanerozoico.*;
import aaLaboratorio.aaMutacion.aaTanqueMutacion;

public class aaController {

    public void iniciarSistema() {
        try {
            System.out.println("===== SISTEMA EVOLUTIVO =====\n");
            Thread.sleep(400);

            cargarSpinner("Cargando jerarquía evolutiva");
            mostrarJerarquiaInicial();

            System.out.println("\nIniciando módulo de mutación...\n");
            Thread.sleep(500);

            aaTanqueMutacion tanque = new aaTanqueMutacion();
            aaFrog frogMutado = tanque.iniciarMutacion();

            if (frogMutado == null) {
                System.out.println("\n❗ No hubo mutación. Manteniendo jerarquía original.");
                System.out.println("\n===== FIN DEL SISTEMA =====");
                return;
            }

            System.out.println("\nCargando jerarquía post-mutación...\n");
            cargarSpinner("Procesando datos mutados");

            mostrarJerarquiaMutada(frogMutado);

            System.out.println("\n===== FIN DEL SISTEMA =====");

        } catch (InterruptedException e) {
            System.out.println("Error en el controlador.");
        }
    }

    private void cargarSpinner(String msg) throws InterruptedException {
        char[] spin = {'-', '\\', '|', '/'};
        int j = 0;
        for (int i = 0; i <= 100; i++) {
            if (j == 4) j = 0;
            System.out.print(msg + " " + spin[j] + "  " + i + "%\r");
            j++;
            Thread.sleep(20);
        }
        System.out.println();
    }

    private void mostrarJerarquiaInicial() {
        new aaGnathostomata("Gnathostomata", "-").imprimirArbol(0);
        new aaOsteichthyes("Osteichthyes", "-").imprimirArbol(1);
        new aaSarcopterygii("Sarcopterygii", "-").imprimirArbol(2);
        new aaTetrapoda("Tetrapoda", "-").imprimirArbol(3);

        new aaAmphibians("Amphibians", "-").imprimirArbol(4);
        new aaFrog("Frog", "-").imprimirArbol(5);


        // Amniona a la misma altura que Tetrapoda, pero después de la rana
        new aaAmniona("Amniona", "-").imprimirArbol(3);
    }

    private void mostrarJerarquiaMutada(aaFrog frogMutado) {
        new aaGnathostomata("Gnathostomata", "-").imprimirArbol(0);
        new aaOsteichthyes("Osteichthyes", "-").imprimirArbol(1);
        new aaSarcopterygii("Sarcopterygii", "-").imprimirArbol(2);
        new aaTetrapoda("Tetrapoda", "-").imprimirArbol(3);

        new aaAmphibians("Amphibians", "-").imprimirArbol(4);

        frogMutado.imprimirArbol(5);

        new aaAmniona("Amniona", "-").imprimirArbol(3);
    }
}
