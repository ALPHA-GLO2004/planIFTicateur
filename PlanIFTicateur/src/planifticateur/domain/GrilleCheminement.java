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
    
    public GrilleCheminement(String grille){
        //Constructeur
        String[] infoGrille = grille.split(";");
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
}
