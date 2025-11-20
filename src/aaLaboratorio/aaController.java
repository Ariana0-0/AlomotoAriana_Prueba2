package aaLaboratorio;

import aaLaboratorio.aaProterozoico.*;
import aaLaboratorio.aaProterozoico.aaFanerozoico.*;
import aaLaboratorio.aaMutacion.aaTanqueMutacion;

public class aaController {

    public void aainiciarSistema() {
        try {
            System.out.println("===== SISTEMA EVOLUTIVO =====\n");
            Thread.sleep(400);

            aacargarSpinner("Cargando jerarquía evolutiva");
            aamostrarJerarquiaInicial();

            System.out.println("\nIniciando módulo de mutación...\n");
            Thread.sleep(500);

            aaTanqueMutacion tanque = new aaTanqueMutacion();
            aaFrog frogMutado = tanque.aainiciarMutacion();

            if (frogMutado == null) {
                System.out.println("\n❗ No hubo mutación. Manteniendo jerarquía original.");
                System.out.println("\n===== FIN DEL SISTEMA =====");
                return;
            }

            System.out.println("\nCargando jerarquía post-mutación...\n");
            aacargarSpinner("Procesando datos mutados");

            aamostrarJerarquiaMutada(frogMutado);

            System.out.println("\n===== FIN DEL SISTEMA =====");

        } catch (InterruptedException e) {
            System.out.println("Error en el controlador.");
        }
    }

    private void aacargarSpinner(String msg) throws InterruptedException {
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

    private void aamostrarJerarquiaInicial() {
        new aaGnathostomata("Gnathostomata", "-").aaimprimirArbol(0);
        new aaOsteichthyes("Osteichthyes", "-").aaimprimirArbol(1);
        new aaSarcopterygii("Sarcopterygii", "-").aaimprimirArbol(2);
        new aaTetrapoda("Tetrapoda", "-").aaimprimirArbol(3);

        new aaAmphibians("Amphibians", "-").aaimprimirArbol(4);
        new aaFrog("Frog", "-").aaimprimirArbol(5);


        // Amniona a la misma altura que Tetrapoda, pero después de la rana
        new aaAmniona("Amniona", "-").aaimprimirArbol(3);
       aaFrog aaFrogInicial = new aaFrog("Pepe", "-");
       aaFrogInicial.aapresentar();
       aaFrogInicial.aacomer();
    }


    private void aamostrarJerarquiaMutada(aaFrog aafrogMutado) {
        new aaGnathostomata("Gnathostomata", "-").aaimprimirArbol(0);
        new aaOsteichthyes("Osteichthyes", "-").aaimprimirArbol(1);
        new aaSarcopterygii("Sarcopterygii", "-").aaimprimirArbol(2);
        new aaTetrapoda("Tetrapoda", "-").aaimprimirArbol(3);

        new aaAmphibians("Amphibians", "-").aaimprimirArbol(4);

        aafrogMutado.aaimprimirArbol(5);

        new aaAmniona("Amniona", "-").aaimprimirArbol(3);
        aafrogMutado.aapresentar();
        aafrogMutado.aacomer();
    }

}
