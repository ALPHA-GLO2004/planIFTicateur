
package planifticateur.domain;
import java.awt.*;
import java.util.Vector;
import java.util.List;
import java.io.File;
import planifticateur.gui.MainWindow;

public class HoraireController {
    private Horaire horaire;
    private Dimension initialDimension;
    private MainWindow mainWindow;
    
    public HoraireController(Horaire horaire){
        this.horaire = horaire;
    }
    
    public HoraireController(){
    }
    
    public void chargerHoraire(File f){
        //peut-être serait plus logique en tant que constructeur
        this.horaire = new Horaire(f);
    }
    
    public void saveHoraire(){
        
    }
    
    public void saveAsHoraire(){
        
    }
    
    public void addActivite(){
        
    }
    
    public void dessiner(){
        
    }
    
    public void validerHoraire(){
        
    }
    
    public void planificationAuto(){
        
    }
    
    public void moveActivite(Point p){
        for (Activite a: horaire.getListeActiviteDejaPlacee()){
            if (a.selectActivite(p) == true){
                //En construction...
            }
        }
    }
    
    public void modifierPointActivite(Point p){
        //code pour modifier le point d'une activité ssi le déplacement est valide
        //(vers fonction qui va faire ça)
    }
    
    public String afficherJourHeure(Point point){
        String jour = "";
        int X = 72;
        int Y = 27;
        for (int i = 8; i <= 22; i++){
            if (point.y >= Y && point.y < Y + 160){
                if (point.x >= X && point.x < X + 70){
                    jour = "lundi " + i + "h";
                }
            }
            if (point.y >= Y + 160 + 25 && point.y < Y + 25 + (2*160)){
                if (point.x >= X && point.x < X + 70){
                    jour = "mardi " + i + "h";
                }
            }
            if (point.y >= Y + (2*160) + (2*25) && point.y < Y + (2*25) + (3*160)){
                if (point.x >= X && point.x < X + 70){
                    jour = "mercredi " + i + "h";
                }
            }
            if (point.y >= Y + (3*160) + (3*25) && point.y < Y + (3*25) + (4*160)){
                if (point.x >= X && point.x < X + 70){
                    jour = "jeudi " + i + "h";
                }
            }
            if (point.y >= Y + (4*160) + (4*25) && point.y < Y + (4*25) + (5*160)){
                if (point.x >= X && point.x < X + 70){
                    jour = "vendredi " + i + "h";
                }
            }            
            X += 70;
        }
        return "Position de la souris: " + jour;
    }
    
    public void note(String n){
        horaire.ajouterNote(n);
    }
 
    public String getStats(){
        return "stats... En attente du fonctionnement de l'horaire";
        //return horaire.listeActiviteAPlacer.getListeActiviteAPlacer().elementAt(0).getNomActivite();
    }
    
    public String getHoraireNom(){
        int i = horaire.fichierCOU.length() - 4;    //longueur du nom du fichierCOU sans le .cou
        return horaire.fichierCOU.substring(0, i);
    }
    
    public String getActiviteNom(Activite a){
        return a.getNomActivite();
    }
    
    public boolean getHoraire(){
        if (horaire != null){
            return true;
        }
        else{
            return false;
        }
    }
    public List<Activite> getListeActiviteAPlacer(){
        return horaire.getListeActiviteAPlacer();
    }

    public List<GrilleCheminement> getListeActiviteGrilleCh(){
        return horaire.getListeActiviteGrilleCh();
    }
    
    public List<Conflit> getListeConflit(){
        return horaire.getListeConflit();
    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return horaire.getListeActiviteDejaPlacee();
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return horaire.getListeModificationActivite();
    }
    
    public void msgErreur(){
        
    }
    public Dimension getDimension(){
        return initialDimension;
    }
    
    public boolean getValiditeDeLHoraire(){
        return horaire.horaireEstValide();
    }
    //et ainsi de suite...
}