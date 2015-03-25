
package planifticateur.domain;
import java.awt.*;
import java.util.Vector;
import java.io.File;

public class HoraireController {
    private Horaire horaire;
    private Dimension initialDimension;
    
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
    
    public void dessinerGrille(){
        
    }
    
    public void validerHoraire(){
        
    }
    
    public void planificationAuto(){
        
    }
    
    public void note(){
        
    }
 
    public String getStats(){
        return "stats... En attente du fonctionnement des listes";
        //return horaire.listeActiviteAPlacer.getListeActiviteAPlacer().elementAt(0).getNomActivite();
    }
    
    public String getHoraireNom(){
        int i = horaire.fichierCOU.length() - 4;    //longueur du nom du fichierCOU sans le .cou
        return horaire.fichierCOU.substring(0, i);
    }
    
    public String getActiviteNom(Activite a){
        return a.getNomActivite();
    }
    
    public Vector<Activite> getListeActiviteAPlacer(){
        return horaire.getListeActiviteAPlacer();
    }

    public Vector<Activite> getListeActiviteGrilleCh(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public Vector<Activite> getListeConflit(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public Vector<Activite> getListeActiviteDejaPlacee(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public Vector<Activite> getListeModificationActivite(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public Dimension getDimension(){
        return initialDimension;
    }
    //et ainsi de suite...
}