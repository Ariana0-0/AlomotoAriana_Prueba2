package aaLaboratorio.aaProterozoico.aaFanerozoico;

public class aaFrog extends aaAmphibians {
    private String aanombre;

    public aaFrog(String aaespecie, String aasimbolo){
        super(aaespecie, aasimbolo);
        this.aanombre = aaespecie;
    }
    public void aapresentar(){
        System.out.println("Soy una rana y me llamo " + getaaNombre());
    }
    public String getaaNombre() {
        return aanombre;
    }
@Override 
    public void aacomer(){
        System.out.println(getaaEspecie() + " está comiendo insectos.");
    }
}   
