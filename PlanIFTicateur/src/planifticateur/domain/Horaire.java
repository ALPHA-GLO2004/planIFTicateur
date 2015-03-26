/*
*   nom:    Classe Horaire
*   but:    Crée un objet Horaire contenant les attributs relatifs à un horaire
*   info:   -stats (lignes 24 à 35) --- voué à l'affichage des stats, changeront dynamiquement
*           aux cours du placement des cours.
*           +attributs privées mais accessible via les get à la fin.
*   pre:    Doit avoir obligatoirement: fichierCOU, fichierCHE, listeActivite (qui se séparera dans les différentes listes).
*   post:   Création d'un horaire avec attributs nécessaires à l'affichage de ce dernier.
************************************************************************************************/

package planifticateur.domain;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Horaire {
    //Ajout de ma part, ça me semblait essentiel
    String fichierCOU;
    String fichierCHE;
    private List<String> listeActivite = new ArrayList<String>();
    private List<String> listeGrille = new ArrayList<String>();
    private String note = "";
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
    ListeGrilleCh listeGrilleCh;

    public Horaire(File f){
        //Constructeur -- Ne fais que prendre le fichier et attribuer chaque élément contenu
        //dans ce fichier au bon endroit. Ensuite fait appel au controller pour créer les activités
        String nomFichier = f.getName().substring(0, (f.getName().length() - 4));
        fichierCOU = nomFichier + ".COU";   
        horairePlein = false;
        listeConflit = new ListeConflit();
        listeModificationActivite = new ListeModificationActivite();
        listeActiviteDejaPlacee = new ListeActiviteDejaPlacee();
        listeGrilleCh = new ListeGrilleCh();
        listeActiviteAPlacer = new ListeActiviteAPlacer();
        //pour fichier COU
        this.lireFichier(f);
        //Analyse auto du délimiteur ?
        String analyseur = listeActivite.get(0);
        String separateur = analyseur.substring(11, 12);
        //
        listeActivite.remove(0); //On retire la premiere ligne
        
        //Pour chaque ligne lue, on l'ajoute dans une liste pour éventuellement créer les activités
        //a valider!!!!!!
        //on verifie si l'activite possede un attribut jour et heure et on l'ajoute a la liste approprie.
        for (String elementActivite: listeActivite){
            Activite a = new Activite(elementActivite);
           // listeActiviteAPlacer.add(a);
            if (a.getJourChoisi() != 0 && a.getHeureDebutChoisi() != 0.0f) {
                listeActiviteDejaPlacee.add(a);
            }
            if (a.getJourChoisi() == 0 && a.getHeureDebutChoisi() == 0.0f) {
                listeActiviteAPlacer.add(a);
            }
        }
        //pour fichier CHE
        String path = f.getPath();
        try{
            BufferedReader fluxCHE = new BufferedReader(new FileReader(path.substring(0, path.length() - 3) + "CHE"));
            for (String line = fluxCHE.readLine(); line != null; line = fluxCHE.readLine()){
                listeGrille.add(line);
            }
            listeGrille.remove(0);
            for (String elementGrille: listeGrille){
                GrilleCheminement g = new GrilleCheminement(elementGrille);
                listeGrilleCh.add(g);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    
    private void lireFichier(File f){
        //Fonction pour transformer un fichier CSV en liste de string de son contenu
        //avec l'aide du séparateur ";"
        try{
            BufferedReader flux = new BufferedReader(new FileReader(f));
            for (String line = flux.readLine(); line != null; line = flux.readLine()){
                listeActivite.add(line);
            }
            flux.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
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
   
    public List<Activite> getListeActiviteAPlacer(){
        return listeActiviteAPlacer.getListeActiviteAPlacer();
    }
   
    public List<GrilleCheminement> getListeActiviteGrilleCh(){
        return listeGrilleCh.getListeGrilleCh();
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
    
    public void ajouterNote(String n){
        note += n;
    }
    
    public void genererAutomatiquement(){
        //En attente d'un bon algorithme
    }
}