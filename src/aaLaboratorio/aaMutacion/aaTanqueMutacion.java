package aaLaboratorio.aaMutacion;

import java.util.Scanner;
import aaLaboratorio.aaProterozoico.aaFanerozoico.aaFrog;

public class aaTanqueMutacion {

    public aaTanqueMutacion() {}

     //Refactorización, se unio en un solo método
    public aaFrog aaMutacion() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el animal que desea mutar: ");
        String animal = sc.nextLine().trim().toLowerCase();

        if (!animal.equals("frog") && !animal.equals("rana")) {
            System.out.println(" Mutación no permitida. Solo se puede mutar un 'frog'.");
            return null;
        }


        System.out.print("Ingrese su apellido para la mutación: ");
        String aaapellido = sc.nextLine().trim();

        System.out.println("\n Autorización aprobada. Iniciando mutación...\n");
    
        
        char[] spinner = {'-', '\\', '|', '/'};
        int s = 0;

        int dosis = (int) (Math.random() * (1000 - 100 + 1)) + 100;

        for (int i = 0; i <= 100; i++) {
            if (s == 4) s = 0;

            System.out.print(spinner[s] + "  " + i + "%  "
                    + (i * dosis / 100) + " / " + dosis + " mSv\r");

            s++;
            try { Thread.sleep(40); } catch (InterruptedException e) {}
        }

        System.out.println("\n\nMutación completada con éxito.");
        System.out.println("Resultado: FROG mejorado.\n");

        // ---------------------------
        //   PRESENTACIÓN DEL MUTADO
        // ---------------------------
        
        String aanombreMutado = "Frog" + aaapellido;
        aaFrog aafrogMutado = new aaFrog(aanombreMutado, "-");
        aafrogMutado.aapresentar();
        aafrogMutado.aacomer();
        System.out.println();

        return aafrogMutado;
    }
}