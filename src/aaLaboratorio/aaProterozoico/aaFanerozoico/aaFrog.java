package aaLaboratorio.aaProterozoico.aaFanerozoico;

public class aaFrog extends aaAmphibians {
    public aaFrog(String especie, String simbolo){
        super(especie, simbolo);
    }

@Override 
    public void comer(){
        System.out.println(getEspecie() + " está comiendo insectos.");
    }
}   
