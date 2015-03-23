
package planifticateur.domain;
import java.util.*;

public class ListeModificationActivite {
    private List<ModificationActivite> modificationActiviteListe;
    
    public ListeModificationActivite(){
        //Constructeur
    }
    
    private void add(ModificationActivite modificationActivite){
        
    }
    
    private boolean isEmpty(){
        if (modificationActiviteListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return modificationActiviteListe;
    }
    
    private int getNumberOfModificationActivite(){
        return 0;
    }
}
