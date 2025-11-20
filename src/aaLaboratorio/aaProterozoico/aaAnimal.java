package aaLaboratorio.aaProterozoico;

public abstract class aaAnimal {
    private String especie;
    private String simbolo;

    public aaAnimal(String especie, String simbolo) {
        this.especie = especie;
        this.simbolo = simbolo;
    }

    public void comer(){
        System.out.println(getEspecie() + " está comiendo.");
    }

    protected String getIndentacion(int nivel) {
        return simbolo.repeat(nivel + 1);
    }

    public void imprimirArbol(int nivel) {
        // Spinner antes de imprimir
        char[] spin = {'-', '\\', '|', '/'};
        for (int i = 0; i < 8; i++) {
            System.out.print("\r" + spin[i % spin.length]);
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }

        // Imprimir con porcentaje 100%
        int guiones = 4 + (nivel * 12);
        System.out.println("\r|100%|" + "-".repeat(guiones) + " " + getEspecie());
    }

    public String getEspecie() {
        return especie;
    }
}
