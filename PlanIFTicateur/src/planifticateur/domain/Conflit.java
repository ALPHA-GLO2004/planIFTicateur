
package planifticateur.domain;


public class Conflit {
    Activite[] activiteEnConflit;
    String nom;
    String description;
    
    public void conflit(Activite act1, Activite act2){
        
    }
    
    private boolean afficherConflit(){ //Est-ce vraiment utile de retourner un bool pour un affichage ?
        return true;
    }
}
