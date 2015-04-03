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
import java.awt.*;

public class Horaire {
    //Ajout de ma part, ça me semblait essentiel
    String fichierCOU;
    String fichierCHE;
    private List<String> listeActivite = new ArrayList<String>();
    private List<String> listeGrille = new ArrayList<String>();
    private Vector<Activite> listeActiviteComplete = new Vector<Activite>();
    private String note = "";
    private boolean modeValidationAuto = false;
    boolean valide;

    //float pctCoursDebutant8h30;
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
        String separateur = analyseur.substring(12, 13);
        //
        listeActivite.remove(0); //On retire la premiere ligne
        
        //Pour chaque ligne lue, on l'ajoute dans une liste pour éventuellement créer les activités
        //a valider!!!!!!
        //on verifie si l'activite possede un attribut jour et heure et on l'ajoute a la liste approprie.
        for (String elementActivite: listeActivite){
            Activite a = new Activite(elementActivite, separateur);
            listeActiviteComplete.addElement(a);
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
                GrilleCheminement g = new GrilleCheminement(elementGrille,separateur);
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
    
    public void initPointActiviteDejaPlacee(Dimension initialDimension){
        int width = initialDimension.width *3/4;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        int y = caseHeureHeight;
        
        for (Activite a: this.getListeActiviteDejaPlacee()){
            int jourChoisiActivitePrecedente = a.getJourChoisi();
            y = caseHeureHeight + (a.getJourChoisi()-1)*caseJourHeight;
            int x = caseJourWidth + (int)((a.getHeureDebutChoisi()-8)*2*saut);
            Point p = new Point(x, y);
            a.setPoint(p);
            //Si une activité deja placée
            if (a.getJourChoisi() == jourChoisiActivitePrecedente){
                y += caseHeureHeight;
            }
        }
    }
    
    public void initPointActivite(Dimension initialDimension){
        int widthListe = initialDimension.width - initialDimension.width*1/4;
        int width = initialDimension.width *3/4;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        int y = caseHeureHeight;
        
        for (Activite a: this.getListeActiviteAPlacer()){
            Point p = new Point(widthListe + 3*saut/2, y);
            a.setPoint(p);
            y += 3*caseHeureHeight/2;
        }
    }
        
    private void validerHoraire(){
        if (listeConflit.isEmpty()){
            valide = true;
        }
        else{
            valide = false;
        }
    }
    
    public String getNomFichier(){
        int i = fichierCOU.length() - 4;
        return fichierCOU.substring(0, i);
    }
    
    //retourne les grilles de cheminement ou il ya l'activité
    private Vector<GrilleCheminement> getListeGrillesDeLactivite(String codeActivite){

        Vector<GrilleCheminement> listeARetourner ;
        listeARetourner = new Vector<GrilleCheminement>();
        
        Vector<GrilleCheminement> listeComplete = listeGrilleCh.getListeGrilleCh();
        for(int i=0;i<listeComplete.size();i++)
            {
               if( listeComplete.elementAt(i).activiteEstDansGrille(codeActivite) )
                       listeARetourner.add(listeComplete.elementAt(i));
            }
        
        return listeARetourner ;
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
    
    public List<Activite> getListeActiviteComplete(){
        return listeActiviteComplete;
    }
    
    public void setListeActiviteDejaPlacee(){
        for (int i = 0; i < this.getListeActiviteAPlacer().size(); i++){
            if (this.getListeActiviteAPlacer().get(i).getJourChoisi() > 0){
                this.listeActiviteDejaPlacee.add(this.getListeActiviteAPlacer().get(i));
                this.listeActiviteAPlacer.remove(this.getListeActiviteAPlacer().get(i));
            }
        }
    }
    
    public void setListeActiviteAPlacer(){
        for (int i = 0; i < this.getListeActiviteDejaPlacee().size(); i++){
            if (this.getListeActiviteDejaPlacee().get(i).getJourChoisi() == 0){
                this.listeActiviteAPlacer.add(this.getListeActiviteDejaPlacee().get(i));
                this.listeActiviteDejaPlacee.remove(this.getListeActiviteDejaPlacee().get(i));
            }
        }
    }
    
    public void ajouterNote(String n){
        note += n;
    }
    
    public void switchModeValidation(){
        this.modeValidationAuto = !this.modeValidationAuto;
    }
    
    public void setModeValidationOff(){
        this.modeValidationAuto = false;
    }
    
    public boolean getModeValidation(){
        return this.modeValidationAuto;
    }
    
    //algorithme de recherche force brute pour l'instant.
     public boolean horaireEstValide(Vector<String> messagesDerreurs){
      
        Vector<GrilleCheminement> grillesChDUneActivite ;
        Vector<String> stringDUneGrille ;
        Vector<Activite> activiteDejaPlacee = listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
        float heure;
        boolean reponse ;
        long iPart;
        double fPart;
        reponse =true;
        
        for(Activite activite : activiteDejaPlacee)
        {
            heure = activite.getHeureDebutChoisi();
             
            //plage horaire valide ?

                if(heure < activite.getHeureDebutMin()){
                    reponse = false;
                    iPart= (long)activite.getHeureDebutMin();
                    fPart = 60.0*(activite.getHeureDebutMin() - iPart);

                    messagesDerreurs.add("L'heure de debut de "  + "\" "+activite.getCode()+" : "
                                         + activite.getNomActivite()+" \""
                                         +" doit être >= "+ iPart +" h "+(long)fPart+ "\n"
                                        );
                }
               /* if(heure > activite.getHeureDebutMax()){
                    reponse = false; 
                }*/

                if( heure + activite.getDuree()  > activite.getHeureFinMax() ){
                    reponse = false;
                    iPart= (long)activite.getHeureFinMax();
                    fPart = 60.0*(activite.getHeureFinMax() - iPart);

                    messagesDerreurs.add("L'heure de fin de " + "\" "+activite.getCode()+" : "
                                          + activite.getNomActivite()+" \""
                                          + " doit être <= "+ iPart +" h "+(long)fPart+ "\n"
                                          );

                }
                
                //respecte les grilles de cheminement ?
                //On verifie si un cours lié se donne en meme tps
                grillesChDUneActivite = getListeGrillesDeLactivite(activite.getCode());
               
                for(GrilleCheminement grille : grillesChDUneActivite )
                {
                    stringDUneGrille = grille.getListeDesCodesDactivites() ;
                   
                    for(int i=0 ; i< stringDUneGrille.size();i++)
                    {
                        if(! stringDUneGrille.elementAt(i).equals(activite.getCode()))
                        {
                            /*
                           if( listeActiviteDejaPlacee.activiteEstEllePlacee(stringDUneGrille.elementAt(i)) ) 
                               reponse = false;
                            messagesDerreurs.add(activite.getCode()+" et "
                                                 +stringDUneGrille.elementAt(i)+"ne doivent pas etre placés en meme temps \n" 
                                                );*/
                        }
                    }
    
                }
               
               
        }
        return reponse;
    }

    public void genererAutomatiquement(){
        //En attente d'un bon algorithme
    }
    
    
//========================================================================== 
//  Statistiques
//========================================================================== 
   
    public Vector<Activite> getListeDesActivitesDUnJour(int jour){
        
     Vector<Activite> activiteDejaPlacee = listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
     Vector<Activite> listeARetourner ;
     
     listeARetourner = new Vector<Activite>();
        
      for(Activite activite : activiteDejaPlacee)
       {
            if(activite.getJourChoisi() == jour )listeARetourner.add(activite);
       }
     
     return listeARetourner;
    
    }
        
    public float calculerNombreDeCours(Vector<Activite> listeDesActivites){
        
        //le nombre de cours en classe ou le nombre d'activités ?
        return listeDesActivites.size();
        
    }
    
    public float calculerNombreMaxDeCours(Vector<Activite> listeDesActivites){

        return 0.0f;
    }
    
    public float calculerNombreMoyenDeCours(Vector<Activite> listeDesActivites){

        return 0.0f;
    }
    
    public float calculerIndiceCovoiturage(Vector<Activite> listeDesActivites){

        return 0.0f;
    }
    
     public float calculerIndiceCongestion(Vector<Activite> listeDesActivites){

        return 0.0f;
    }
    

    public Vector<Float> getStatistiques(int jour){
          
       Vector<Float> stats = new Vector<Float>();
       Vector<Activite> listeDesActivites = getListeDesActivitesDUnJour(jour);
       
       stats.add(calculerNombreDeCours(listeDesActivites));
       stats.add(calculerNombreMaxDeCours(listeDesActivites));
       stats.add(calculerNombreMoyenDeCours(listeDesActivites));
       stats.add(calculerIndiceCovoiturage(listeDesActivites));
       stats.add(calculerIndiceCongestion(listeDesActivites));
        
        return stats;
    }
      
}