
package planifticateur.domain;


public class Conflit {
    Activite[] activiteEnConflit;
    String nom;
    String description;
    
    public Conflit(Activite act1, Activite act2){
        //Constructeur
    }
    
    private boolean afficherConflit(){ //Est-ce vraiment utile de retourner un bool pour un affichage ?
        return true;
    }
}
