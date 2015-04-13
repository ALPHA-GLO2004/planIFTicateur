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
import java.util.List;

public class Activite implements Comparable<Activite>{
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
    private float heureDebutChoisi = 0;
    private int jourChoisi = 0;
    private float duree;
    private Point point; //remplace rectangle
    private boolean selectStatus = false;
    
    public int compareTo(Activite a){
        //Méthode pour classer la liste d'activité à placer selon le code de l'activité
        int i = getCode().substring(0, 3).compareTo(a.getCode().substring(0, 3));
        
        if (i == 0){
            int codeA = Integer.parseInt(getCode().substring(4, 8));
            int codeB = Integer.parseInt(a.getCode().substring(4, 8));
            return codeA > codeB ? 1 : codeA < codeB ? -1 : 0;
        }
        else{
            return i;
        }
    }
    
    public Activite(){};
    
    public Activite(String activite, String separateur){
        //Constructeur
        //À partir d'une string et du bon separateur CSD, chaque attribut essentiel de l'activité est capté par
        //chaque donnée entre un séparateur précis dans cette string.
        //Bloc try car possibles erreurs de lectures mais catch ne fait qu'afficher les erreurs
        //pour le moment.
        
        
        String[] infoActivite = activite.split(separateur); //On coupe la chaîne pour obtenir les infos séparés
        try
        {
            point = new Point(0,0);
            code = infoActivite[0];
            section = infoActivite[1];
            description = infoActivite[2];
            professeur = new Professeur(infoActivite[3]);
            type = infoActivite[4];
            duree = Float.parseFloat(infoActivite[5]); //transformation de string à float
            heureDebutMin = Float.parseFloat(infoActivite[6]); //transformation de string à float
            heureFinMax = Float.parseFloat(infoActivite[7]); //transformation de string à float
            if (infoActivite.length >= 9){
                if (!infoActivite[8].equals("0") || !infoActivite[8].equals(null)){
                    jourChoisi = Integer.parseInt(infoActivite[8]); //Transformation de string à Int
                }
                else{
                    jourChoisi = 0;
                }
            }
            if (infoActivite.length == 10){
                if (!infoActivite[9].equals("0") || !infoActivite[9].equals(null)){
                    heureDebutChoisi = Float.parseFloat(infoActivite[9]); //transformation de string à float
                }
                else{
                    heureDebutChoisi = 0;
                }
            }
            //attribution de la couleur selon le type
            if ( type.toLowerCase().contains("classe") ){//insensible a la casse
                couleur = new Color(49, 140, 231);
            }else if ( type.toLowerCase().contains("distance")  ){//alternatif et une seule comparaison
                couleur = new Color(165, 209, 82);
            } else if ( type.toLowerCase().contains("labo") ){
                couleur = new Color(223, 109, 20);
            } else if ( type.toLowerCase().contains("horsD") ){
                couleur = new Color(253, 108, 158);
            } else {//sentinelle de le cas de couleur rouge 
                //sinon le programme plante avec une nouvelle activite en appelant : getCouleur() sera null
                //on peut savoir que un nouveau type d'activite est ajoute au fichier
                couleur = Color.RED;//en attendant le factory qui nous permet d'ajouter un nouveau cours sans connaitre son nom. 
            }
            heureDebutMax = heureFinMax - duree;
        }
        catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //À déplacer dans mouseAdapter
    public boolean selectActivite(Point mousePoint){
        if ((mousePoint.x >= ((this.getPoint().x) - (this.getDuree()/2*35))) && (mousePoint.x <= ((this.getPoint().x) + (this.getDuree()/2*35))) &&
            (mousePoint.y >= (this.getPoint().y - 10)) && (mousePoint.y <= (this.getPoint().y + 10))){
                return true;
            }
        else{
            return false;
        }
    }
    
    public void afficherValidite(){
        //fonction affichage dans domain ?
        // Dans ce cas-ci, je crois que l'on pourrait changer la couleur de
        // l'activite si elle est en conflit... couleur = Color.RED par exemple.
    }
    
    public String conversionJour(int jour){
        if (jour == 1){
            return "lundi";
        }
        if (jour == 2){
            return "mardi";
        }
        if (jour == 3){
            return "mercredi";
        }
        if (jour == 4){
            return "jeudi";
        }
        if (jour == 5){
            return "verdredi";
        }
        else{
            return "";
        }
    }
    
    public String conversionHeure(float heure){
        String heureChaine = Float.toString(heure);
        String heureConverti = "";
        
        if (heureChaine.length() == 3){
            heureConverti = heureChaine.substring(0, 1) + "h";
            if (heureChaine.substring(2).equals("5")){
                heureConverti += "30";
            }
        }
        if (heureChaine.length() == 4){
            heureConverti = heureChaine.substring(0, 2) + "h";
            if (heureChaine.substring(3).equals("5")){
                heureConverti += "30";
            }
        }
        return heureConverti;
    }
    
    public void setValuesFrom(Activite src)
    {
        code =  src.code;
        section=  src.section; 
        type=  src.type;
        description=  src.description; 
        couleur=  src.couleur;
        professeur=  src.professeur;
        heureDebutMin=  src.heureDebutMin;
        heureDebutMax=  src.heureDebutMax;
        heureFinMax=  src.heureFinMax; 
        heureDebutChoisi=  src.heureDebutChoisi;
        jourChoisi=  src.jourChoisi;
        duree=  src.duree;
        point=  src.point; 
        selectStatus=  src.selectStatus;
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
    
    public void setPoint(Point p){
        this.point = p;
    }
    
    public int getJourChoisi(){
        return jourChoisi;
    }
    
    public String getSection(){
        return section;
    }
    
    public float getHeureDebutChoisi(){
        return heureDebutChoisi;
    }
    
    public float getDuree(){
        return duree;
    }
    
    public String getType(){
        return type;
    }
    
    public float getHeureDebutMin(){
        return heureDebutMin;
    }
    public float getHeureDebutMax(){
        return heureDebutMax;
    }
    public float getHeureFinMax(){
        return heureFinMax;
    }
    
    public String getProfesseur(){
        return professeur.getInitiales();
    }
    
    public String getCode(){
        return code;
    }
    
    public void setJourChoisi(int jour){
        this.jourChoisi = jour;
    }
    
    public void setHeureDebutChoisi(float heure){
        this.heureDebutChoisi = heure;
    }
    
    public void switchSelection(){
        this.selectStatus = !this.selectStatus;
    }
    
    public boolean isSelected(){
        return selectStatus;
    }
}
