
package planifticateur.domain;
import java.awt.*;
import java.lang.*;

public class Activite {
    //J'ai tout mis en string étant donné que ce n'est pas tant pertinent d'avoir un paquet de type différent pour le moment.
    private String code;
    private String section; // Ajout de ma part
    private String type; //Changement type: Type -> char (aucune utilité à faire une classe Type...)
    private String description; //Ajout de ma part...
    private Color couleur;
    private Professeur professeur;
    private float heureDebutMin;
    private float heureDebutMax;
    private float heureFinMax; //Changement type: String -> float (erreur de frappe?)
    private float heureDebutChoisi;
    private int jourChoisi;
    private float duree;
    private Point point;
//    Rectangle rectangle; //Utilité du rectangle ?
    
    public Activite(String[] infoActivite){ //to be modified :/
        /*
        Constructeur --- Une activité est créée avec, comme paramètre une liste 
        de string correspondant à chaque colonne d'une ligne dans un fichier COU.
        Cette liste est créée hors de cette classe. // Possiblement à modifier (doit être validée)
        */
        try
        {
            code = infoActivite[0];
            section = infoActivite[1];
            description = infoActivite[2];
            professeur = new Professeur(infoActivite[3]);
            type = infoActivite[4];
            duree = Float.valueOf(infoActivite[5]); //transformation de string à float
            heureDebutMin = Float.valueOf(infoActivite[6]); //transformation de string à float
            heureDebutMax = Float.valueOf(infoActivite[7]); //transformation de string à float
            heureFinMax = Float.valueOf(infoActivite[8]); //transformation de string à float
            if (infoActivite[9] != ""){
                jourChoisi = Integer.valueOf(infoActivite[9]); //Transformation de string à Int
            }
            if (infoActivite[10] != ""){
                heureDebutChoisi = Float.valueOf(infoActivite[10]); //transformation de string à float
            }
            //attribution de la couleur selon le type
            if (type == "classe"){
                couleur = Color.ORANGE;
            }
            if (type == "distance"){
                couleur = Color.GREEN;
            }
            if (type == "labo"){
                couleur = Color.YELLOW;
            }
            if (type == "horsDepartement"){
                couleur = Color.BLUE;
            }            
        }
        catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private boolean appartientAActivite(Point point){
        return true;
    }
    
    private void afficherValidite(){
        //fonction affichage dans domain ?
    }
    
    public Color getCouleur(){
        return couleur;
    }
    
    public Point getPoint(){
        return point;
    }
}
