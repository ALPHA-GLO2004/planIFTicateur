/*
*   nom:    Classe Activité
*   but:    Crée un objet Activite contenant les attributs relatifs à une activité
*   info:   -couleur:           se choisit automatiquement à la création d'une activité;
*           -professeur:        n'est pas obligatoire, feature bonus;
*           -heureDebutChoisi:  se choisit automatiquement lors du drop sur l'horaire;
*           -jourChoisi:        idem.
*           +attributs privés mais accessible via les méthodes get à la fin
*   pre:    Doit avoir obligatoirement: code, section, type, description, heureDebutMin,
*           heureDebutMax, heureFinMax, duree.
*   post:   Création d'une activité avec attributs nécessaires à l'intégration dasn un horaire.
************************************************************************************************/
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
    private Point point; //remplace rectangle
//    Rectangle rectangle; //Utilité du rectangle ?
    
    public Activite(String activite){ //to be modified :/
        //Constructeur
        //À partir d'une string, chaque attribut essentiel de l'activité est capté par
        //chaque donnée entre un séparateur précis dans cette string.
        //Bloc try car possibles erreurs de lectures mais catch ne fait qu'afficher les erreurs
        //pour le moment.
        
        String[] infoActivite = activite.split(";"); //On coupe la chaîne pour obtenir les infos séparés
        try
        {
            code = infoActivite[0];
            section = infoActivite[1];
            description = infoActivite[2];
            professeur = new Professeur(infoActivite[3]);
            type = infoActivite[4];
            duree = Float.parseFloat(infoActivite[5]); //transformation de string à float
            heureDebutMin = Float.parseFloat(infoActivite[6]); //transformation de string à float
            heureDebutMax = Float.parseFloat(infoActivite[7]); //transformation de string à float
            heureFinMax = Float.parseFloat(infoActivite[8]); //transformation de string à float
            if (infoActivite[9] != ""){
                jourChoisi = Integer.parseInt(infoActivite[9]); //Transformation de string à Int
            }
            if (infoActivite[10] != ""){
                heureDebutChoisi = Float.parseFloat(infoActivite[10]); //transformation de string à float
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
    
    public boolean appartientAActivite(Point point){
        //C'était dans le diagramme...
        return true;
    }
    
    public void afficherValidite(){
        //fonction affichage dans domain ?
        // Dans ce cas-ci, je crois que l'on pourrait changer la couleur de
        // l'activite si elle est en conflit... couleur = Color.RED par exemple.
    }
    
    public Color getCouleur(){
        return couleur;
    }
    
    public String getNomActivite(){
        return description;
    }
    
    public Point getPoint(){
        return point;
    }
    
    public int getJourChoisi(){
        return jourChoisi;
    }
    
    public float getHeureDebutChoisi(){
        return heureDebutChoisi;
    }
    
    public float getDuree(){
        return duree;
    }
    
    public String getCode(){
        return code;
    }
    
}
