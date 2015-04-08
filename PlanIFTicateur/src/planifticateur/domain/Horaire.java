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
import java.util.Collections;

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
    private Activite activiteSelected;
    private Activite activiteInMove;
    private String session;

    //float pctCoursDebutant8h30;
    boolean horairePlein;
    ListeConflit listeConflit;
    ListeModificationActivite listeModificationActivite;
    ListeActiviteAPlacer listeActiviteAPlacer;
    ListeActiviteDejaPlacee listeActiviteDejaPlacee;
    ListeGrilleCh listeGrilleCh;

    public Horaire(String filePath, String sessionChoisi){
        //Constructeur -- Ne fais que prendre le fichier et attribuer chaque élément contenu
        //dans ce fichier au bon endroit. Ensuite fait appel au controller pour créer les activités
        String[] tabString = filePath.split("\\\\");
        this.session = sessionChoisi;
        String nomFichier = tabString[tabString.length-1];
               nomFichier =nomFichier.substring(0, (nomFichier.length() - 4));
        fichierCOU = nomFichier + ".COU";   
        horairePlein = false;
        listeConflit = new ListeConflit();
        listeModificationActivite = new ListeModificationActivite();
        listeActiviteDejaPlacee = new ListeActiviteDejaPlacee();
        listeGrilleCh = new ListeGrilleCh();
        listeActiviteAPlacer = new ListeActiviteAPlacer();
        //pour fichier COU
        this.lireFichier(filePath);
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
        String path = filePath;
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
    
    private void lireFichier(String filePath){
        //Fonction pour transformer un fichier CSV en liste de string de son contenu
        //avec l'aide du séparateur ";"
        try{
            
            BufferedReader flux = new BufferedReader(new FileReader(filePath));
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

        for (Activite a: this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee()){
            int[] jourChoisiActivitePrecedente = {0};
            y = caseHeureHeight + (a.getJourChoisi()-1)*caseJourHeight;
            int x = caseJourWidth + (int)((a.getHeureDebutChoisi()-8)*2*saut);
            
            //Si une activité deja placée
            for (Activite act: this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee()){
                if (a.getJourChoisi() == act.getJourChoisi()
                    && a.getHeureDebutChoisi() < (act.getHeureDebutChoisi() + act.getDuree())
                    && a.getHeureDebutChoisi() > act.getHeureDebutChoisi()){
                        y += caseHeureHeight;
                }
            Point p = new Point(x, y);
            a.setPoint(p);
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
    
    public void moveActivite(Point p){
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected() == true){
                a.setPoint(p);
            }
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
        
        List<GrilleCheminement> listeComplete = listeGrilleCh.getListeGrilleCh();
        for(int i=0;i<listeComplete.size();i++)
            {
               if( listeComplete.get(i).activiteEstDansGrille(codeActivite) )
                       listeARetourner.add(listeComplete.get(i));
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
    
    public ListeActiviteDejaPlacee getListeActiviteDejaPlacee(){
        return listeActiviteDejaPlacee;
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
        for (int i = 0; i < this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee().size(); i++){
            if (this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee().get(i).getJourChoisi() == 0){
                this.listeActiviteAPlacer.add(this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee().get(i));
                this.listeActiviteDejaPlacee.remove(this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee().get(i));
            }
        }
    }
    
    public void setSession(String sessionChoisi){
        this.session = sessionChoisi;
    }
    
    public void setActiviteInMove(Activite a){
        this.activiteInMove = a;
    }
    
    public Activite getActiviteInMove(){
        return this.activiteInMove;
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
    
    public String getSession(){
        return this.session;
    }
    
    public boolean getModeValidation(){
        return this.modeValidationAuto;
    }
    
    public Activite getActiviteSelected(){
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected()){
                this.activiteSelected = a;
            }
        }
        return this.activiteSelected;
    }
    
    public boolean yaTilChevauchement(Activite a1, Activite a2){

        if(a1.getJourChoisi() != a2.getJourChoisi() ) return false;
            
        if( (a1.getHeureDebutChoisi() >=  a2.getHeureDebutChoisi() + a2.getDuree() )
              ||(a1.getHeureDebutChoisi()+ a1.getDuree() <=  a2.getHeureDebutChoisi() ) 
            )
        return false;
        
      return true;
            
    }

    //algorithme de recherche force brute pour l'instant.
     public boolean horaireEstValide(Vector<String> messagesDerreurs){
      
        Vector<GrilleCheminement> grillesChDUneActivite ;
        List<String> stringDUneGrille = new Vector<String> () ;
        Vector<Activite> activiteDejaPlacee = listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
        ListePairesDActivites listePaires = new ListePairesDActivites() ;
        ListePairesDActivites listeCoursLab = new ListePairesDActivites() ;
         
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

                    messagesDerreurs.add("L'heure de debut de "  + "\" "+activite.getCode()+" \" "
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

                    messagesDerreurs.add("L'heure de fin de " + "\" "+activite.getCode()+" \" "
                                          + " doit être <= "+ iPart +" h "+(long)fPart+ "\n"
                                          );

                }
                
                //un cours  ne peuvent se donner en meme tps que son lab
                for(Activite activite2 : activiteDejaPlacee)
                {
                    if(! yaTilChevauchement(activite, activite2))continue;
                    
                    if( activite.getCode().equals(activite2.getCode()) )
                     {
              
                         if( ( (activite.getType().toLowerCase().contains("classe")))
                              &&
                             ((activite2.getType().toLowerCase().contains("laboratoire")))
                            )
                         {
                             listeCoursLab.addPaire(activite, activite2);
                             reponse = false;
                         }
                         
                         else if((activite.getType().toLowerCase().contains("distance"))
                              &&
                             (activite2.getType().toLowerCase().contains("laboratoire"))
                            )
                         {
                             listeCoursLab.addPaire(activite, activite2);
                             reponse = false;
                         }
                         
                         else if((activite.getType().toLowerCase().contains("laboratoire"))
                              &&
                             (activite2.getType().toLowerCase().contains("distance"))
                            )
                         {
                              listeCoursLab.addPaire(activite, activite2);
                              reponse = false;
                         }
                         else if((activite.getType().toLowerCase().contains("laboratoire"))
                              &&
                             (activite2.getType().toLowerCase().contains("classe"))
                            )
                         {
                              listeCoursLab.addPaire(activite, activite2);
                              reponse = false;
                         }
     
              
                     }
                    
                }
                
                
                //respecte les grilles de cheminement ?
                //On verifie si un cours lié se donne en meme tps
                
                grillesChDUneActivite = getListeGrillesDeLactivite(activite.getCode());
               
                for(GrilleCheminement grille : grillesChDUneActivite )
                {
                    stringDUneGrille = grille.getListeDesCodesDactivites() ;
                   
                    for(int i=0 ; i< stringDUneGrille.size();i++)
                    {
                        if(! stringDUneGrille.get(i).equals(activite.getCode()))
                        {

                            Activite act = new Activite();
                               
                            //rempli act des infos de l'activite correspondant astringDUneGrille.elementAt(i)
                           if( listeActiviteDejaPlacee.activiteEstEllePlacee(stringDUneGrille.get(i),act) ){ 
                               {
                                   //pas le meme jour c'est correct
                                   if(act.getJourChoisi() != activite.getJourChoisi())continue ; 
                                   
                                       if (yaTilChevauchement(activite, act ))
                                       {
                                           //elimine les doublons pour les paires.
                                            listePaires.addPaire(activite, act);
                                            reponse = false;

                                       }
                               }
                           }
                        }
                    }
    
                }
               

        }
     
           Vector<PaireDActivites> paires = listePaires.getListe();
           for(PaireDActivites p : paires)
         {
                
            messagesDerreurs.add(p.a1.getCode()+" et "
                    +p.a2.getCode()+" ne peuvent avoir lieu en meme temps \n" 
                    );  
         }
           
         paires = listeCoursLab.getListe();
           for(PaireDActivites p : paires)
         {
                
            messagesDerreurs.add( "\" "+p.a1.getCode() + " \" ne peut avoir lieu en meme temps que son laboratoire\n" 
                    );  
            
         }
        return reponse;
    }

    public int verificationListOfActivite(Activite activite){
        for (Activite a: this.getListeActiviteAPlacer()){
            if (a.equals(activite)){
                return 0;
            }
        }
        return 1;
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
    
    public float calculerIndiceCovoiturage(){

        return 0.0f;
    }
    
     public float calculerIndiceCongestion(){

         float nb;
         Vector<Activite> liste = new Vector<Activite>();
         
         liste = listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
         nb=0;
         for( Activite activite : liste)
         {
             if(activite.getHeureDebutChoisi() == 8.5)nb++;
         }
        return nb*100.0f/liste.size();
    }
    

    public Vector<Float> getStatistiques(int jour){
          
       Vector<Float> stats = new Vector<Float>();
       Vector<Activite> listeDesActivites = getListeDesActivitesDUnJour(jour);
       
       stats.add(calculerNombreDeCours(listeDesActivites));
       stats.add(calculerNombreMaxDeCours(listeDesActivites));
       stats.add(calculerNombreMoyenDeCours(listeDesActivites));
       stats.add(calculerIndiceCovoiturage());
       stats.add(calculerIndiceCongestion());
        
        return stats;
    }
      
}