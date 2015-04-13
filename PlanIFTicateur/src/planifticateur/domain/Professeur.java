
package planifticateur.domain;


public class Professeur {
    private String identifiant; //on n'a pas cette information
    private String initiales;
    private String bureau;      //on n'a pas cette information
    
    public Professeur(String initiale){
        //Constructeur
        this.initiales = initiale;
    }
    
    public String getInitiales(){
        return this.initiales;
    }
    
    public void setInitiales(String initiales){
        this.initiales = initiales;
    }
}
