//Reactorizacion d etods la clase
package aaLaboratorio.aaProterozoico;

public abstract class aaAnimal {
    private String aaespecie;
    private String aasimbolo; //Refactorización 

    public aaAnimal(String aaespecie, String aasimbolo) {
        this.aaespecie = aaespecie;
        this.aasimbolo = aasimbolo;
    }

    public void aacomer(){
        System.out.println(getaaEspecie() + " está comiendo.");
    }

    protected String getaaIndentacion(int nivel) {
        return aasimbolo.repeat(nivel + 1);
    }

    public void aaimprimirArbol(int nivel) {
        // Spinner antes de imprimir
        char[] spin = {'-', '\\', '|', '/'};
        for (int i = 0; i < 8; i++) {
            System.out.print("\r" + spin[i % spin.length]);
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }

        // Imprimir con porcentaje 100%
        int guiones = 4 + (nivel * 12);
        System.out.println("\r|100%|" + "-".repeat(guiones) + " " + getaaEspecie());
    }

    public String getaaEspecie() {
        return aaespecie;
    }
}
