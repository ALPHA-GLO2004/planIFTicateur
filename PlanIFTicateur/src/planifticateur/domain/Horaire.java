
package planifticateur.domain;
import java.util.List;

public class Horaire {
    //Ajout de ma part, ça me semblait essentiel
    String fichierCOU;
    String fichierCHE;
    //
    boolean valide;
    int nbMaxCoursEtudiantMemeJour;
    int nbMoyenCoursEtudiantMemeJour;
    float pctCoursDebutant8h30;
    int indiceCovoiturage;
    int nbCoursLundi;
    int nbCoursMardi;
    int nbCoursMercredi;
    int nbCoursJeudi;
    int nbCoursVendredi;
    int nbCoursSamedi;
    int nbCoursDimanche;
    int nbMaxCoursHoraire;
    boolean horairePlein;
    ListeConflit listeConflit;
    ListeModificationActivite listeModificationActivite;
    ListeActiviteAPlacer listeActiviteAPlacer;
    ListeActiviteDejaPlacee listeActiviteDejaPlacee;
    ListeActiviteGrilleCh listeActiviteGrilleCh;

    public Horaire(String nomFichier){
        fichierCOU = nomFichier + ".COU";   
        fichierCHE = nomFichier + ".CHE";
        horairePlein = false;
    }
    
    private void validerHoraire(){
        if (listeConflit.isEmpty()){
            valide = true;
        }
        else{
            valide = false;
        }
    }
    
    public void addActivite(){
        
    }
    
    public List<Activite> getListeActiviteAPlacer(){
        return listeActiviteAPlacer.getListeActiviteAPlacer();
    }
    
    public List<GrilleCheminement> getListeActiviteGrilleCh(){
        return listeActiviteGrilleCh.getListeActiviteGrilleCh();
    }
    
    public List<Conflit> getListeConflit(){
        return listeConflit.getListeConflit();
    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return listeModificationActivite.getListeModificationActivite();
    }
    
    private void genererAutomatiquement(){
        //En attente d'un bon algorithme
    }
}
