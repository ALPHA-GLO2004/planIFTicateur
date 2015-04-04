
package planifticateur.domain;
import java.util.Vector;


public class ListeActiviteDejaPlacee {
    private Vector<Activite> activiteDejaPlaceeListe;
    
    public ListeActiviteDejaPlacee(){
        //Doit modifier le contructeur
 /*       //Constructeur --- Le constructeur parcourt la liste d'activité en paramètre
        //et vérifie si l'activité est placée selon son jour et heureDeDébut choisi.
        //ensuite, il crée sa liste avec les activités correspondantes.
        
        for (Activite activite: listeActivite){
            if (activite.getJourChoisi() != 0 && activite.getHeureDebutChoisi() != 0.0){
                activiteDejaPlaceeListe.add(activite);
            }
        }*/
                //test Phil
        //for (Activite activite: activiteDejaPlaceeListe) {
          //  if (activite.getJourChoisi() != 0 && activite.getHeureDebutChoisi() != 0.0f) {
          //      activiteDejaPlaceeListe.add(activite);
          //  }
        //On peux simplement creer une nouvelle liste, et lors de la generation des activites, on verifie si l'activite est placer, 
        //et en fonction de cela, elle est envoyer dans une des deux liste.
        activiteDejaPlaceeListe = new Vector<Activite>();
    }
    
    //Ajoute une activité à la liste déjà placées
    public void add(Activite activite){
        activiteDejaPlaceeListe.addElement(activite);
    }
    
    //Retire une activté de la liste déjà placées
    public void remove(Activite activite){
        activiteDejaPlaceeListe.removeElement(activite);
    }
    //Retourne vrai si la liste d'activités déjà placées est vide, faux sinon
    public boolean isEmpty(){
        if (activiteDejaPlaceeListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste des activités à placer
    public Vector<Activite> getListeActiviteDejaPlacee(){
        return activiteDejaPlaceeListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités déjà placées
    public int getNumberOfActivite(){
        return activiteDejaPlaceeListe.size();
    }
    
    public boolean activiteEstEllePlacee(String codeActivite,Activite act){
        
        for(int i=0;i<activiteDejaPlaceeListe.size();i++)
        {
            if( activiteDejaPlaceeListe.elementAt(i).getCode().equals(codeActivite))
            {
                act.setValuesFrom(activiteDejaPlaceeListe.elementAt(i)) ;
                return true;
            }
        }
        
        return false;
      }
    }
