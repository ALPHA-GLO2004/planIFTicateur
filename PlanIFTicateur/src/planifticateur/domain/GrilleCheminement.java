
package planifticateur.domain;


public class GrilleCheminement {
    char[] programme;
    String version;
    char[] session;
    ListeActiviteGrilleCh listeActiviteGrilleCh;
    
    public GrilleCheminement(){
        //Constructeur
    }
    
    private boolean enConflit(Activite activite1, Activite activite2){
        return true;
    }
}
