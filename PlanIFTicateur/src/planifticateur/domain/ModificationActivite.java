
package planifticateur.domain;


public class ModificationActivite {
    String date; //Changement type: Date -> String (aucune opération sur ça et ajouter un type Date nécessite dla job pour rien
    String version; //Changement type: Version -> String (utilité de créer classe Version ?)
    String description;
    
    public ModificationActivite(){
        //Constructeur
    }
}
