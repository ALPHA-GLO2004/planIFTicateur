
package planifticateur.domain;
import java.util.Vector;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Horaire {
    //Ajout de ma part, ça me semblait essentiel
    String fichierCOU;
    String fichierCHE;
    Vector<String> listeActivite;
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

    public Horaire(File f){
        //Constructeur -- Ne fais que prendre le fichier et attribuer chaque élément contenu
        //dans ce fichier au bon endroit. Ensuite fait appel au controller pour créer les activités
        String nomFichier = f.getName().substring(0, (f.getName().length() - 4));
        fichierCOU = nomFichier + ".COU";   
        fichierCHE = nomFichier + ".CHE";
        horairePlein = false;
        listeConflit = new ListeConflit();
        listeModificationActivite = new ListeModificationActivite();
        listeActiviteDejaPlacee = new ListeActiviteDejaPlacee();
        listeActiviteGrilleCh = new ListeActiviteGrilleCh();
        this.conversionFichier(f);
        //Pour chaque ligne lue, on l'ajoute dans une liste pour éventuellement créer les activités
        for (String elementActivite: listeActivite){
            Activite a = new Activite(elementActivite);
            listeActiviteAPlacer.add(a);
        }
    }
    
    private void conversionFichier(File f){
        //Fonction pour transformer un fichier CSV en liste de string de son contenu
        //avec l'aide du séparateur ";"
        try{
            BufferedReader flux = new BufferedReader(new FileReader(f));
            while (flux.readLine() != null){
                listeActivite.add(flux.readLine());
            }
        }catch (Throwable ex){
            ex.printStackTrace();
        }
    }
    
    private void validerHoraire(){
        //manque du stock ici
        if (listeConflit.isEmpty()){
            valide = true;
        }
        else{
            valide = false;
        }
    }
    
    public void addActivite(){
        
    }
   
    public Vector<Activite> getListeActiviteAPlacer(){
        return listeActiviteAPlacer.getListeActiviteAPlacer();
    }
   
    public Vector<GrilleCheminement> getListeActiviteGrilleCh(){
        return listeActiviteGrilleCh.getListeActiviteGrilleCh();
    }
    
    public Vector<Conflit> getListeConflit(){
        return listeConflit.getListeConflit();
    }
    
    public Vector<Activite> getListeActiviteDejaPlacee(){
        return listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
    }
    
    public Vector<ModificationActivite> getListeModificationActivite(){
        return listeModificationActivite.getListeModificationActivite();
    }
    
    private void genererAutomatiquement(){
        //En attente d'un bon algorithme
    }
}