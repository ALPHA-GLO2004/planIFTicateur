
package planifticateur.domain;
import java.awt.*;

public class Activite {
    int code;
    char type; //Changement type: Type -> char (aucune utilité à faire une classe Type...)
    String couleur; //Changement type: Couleur -> String (utilité?)
    Professeur professeur;
    float heureDeDebutMin;
    float heureDeDebutMax;
    float heureDeFinMax; //Changement type: String -> float (erreur de frappe?)
    float heureDeDebutChoisi;
    int jourChoisi;
    float duree;
    Point point;
//    Rectangle rectangle; //Utilité du rectangle ?
    
    public Activite(){
        //Constructeur
    }
    
    private boolean appartientAActivite(Point point){
        return true;
    }
    
    private void afficherValidite(){
        
    }
}
