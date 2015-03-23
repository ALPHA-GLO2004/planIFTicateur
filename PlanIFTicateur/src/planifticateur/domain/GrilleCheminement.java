
package planifticateur.domain;
import java.util.*;

public class GrilleCheminement {
    String programme;
    String version;
    String session;
    List<String> grilleCh;
    
    public GrilleCheminement(String grille){
        //Constructeur
        String[] infoGrille = grille.split(";");
        try{
            programme = infoGrille[0];
            version = infoGrille[1];
            session = infoGrille[2];
            for (int i = 3; i < infoGrille.length; i++){
                grilleCh.add(infoGrille[i]);
            }
        }catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private boolean enConflit(Activite activite){
        for (String grille: grilleCh){
            if (activite.getCode() == grille){
                return false;
            }
        }
        return true;
    }
}
