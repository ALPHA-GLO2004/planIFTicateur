/*
*   nom:    Classe GrilleCheminement
*   but:    Crée un objet GrilleCheminement contenant les attributs relatifs à une grille de cheminement
*   pre:    Doit avoir obligatoirement: programme, version, session et une liste d'activités reliées.
*   post:   Création d'une grille avec attributs nécessaires à la validation d'un horaire.
************************************************************************************************/

package planifticateur.domain;
import java.util.*;

public class GrilleCheminement {
    String programme;
    String version;
    String session;
    Vector<String> grilleActivites = new Vector<String>();

    public GrilleCheminement(String grille,String separateur){
        //Constructeur
        String[] infoGrille = grille.split(separateur);
        try{
            programme = infoGrille[0];
            version = infoGrille[1];
            session = infoGrille[2];
            for (int i = 3; i < infoGrille.length; i++){
                grilleActivites.add(infoGrille[i]);
            }
        }catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private boolean enConflit(Activite activite){
        //À implémenter
        return false;
    }
    
     public boolean activiteEstDansGrille(String nomActivite){
       
         return grilleActivites.contains(nomActivite);
    }
     
    public Vector<String> getListeDesNoms(){
       
         return grilleActivites;
    }
}
