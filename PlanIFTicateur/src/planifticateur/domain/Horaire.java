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
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.awt.*;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Horaire{
    //Ajout de ma part, ça me semblait essentiel
    private boolean saved = false;
    private String fichierCOU;
    private String fichierCHE;
    private List<String> listeActivite = new ArrayList<String>();
    private List<String> listeGrille = new ArrayList<String>();
    private Vector<Activite> listeActiviteComplete = new Vector<Activite>();
    private Vector cloneListe;
    private String note = "";
    private boolean modeValidationAuto = false;
    private boolean valide;
    private int indexEtiquette;
    private Activite activiteSelected;
    private Activite activiteInMove;
    private String session;
    private String separateur;
    //float pctCoursDebutant8h30;
    private boolean horairePlein;
    private ListeConflit listeConflit;
    private ListeModificationActivite listeModificationActivite;
    private ListeActiviteAPlacer listeActiviteAPlacer;
    private ListeActiviteDejaPlacee listeActiviteDejaPlacee;
    private ListeGrilleCh listeGrilleCh;
    
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
        separateur = analyseur.substring(12, 13);
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
            y = caseHeureHeight + (a.getJourChoisi()-1)*caseJourHeight + a.getRangee()*caseHeureHeight;
            int x = caseJourWidth + (int)((a.getHeureDebutChoisi()-8)*2*saut);
            
            //Activité déjà placée avant attribution d'une rangée
            for (Activite act: this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee()){
                if (a.getJourChoisi() == act.getJourChoisi()
                    && a.getHeureDebutChoisi() < (act.getHeureDebutChoisi() + act.getDuree())
                    && a.getHeureDebutChoisi() > act.getHeureDebutChoisi()
                    && a.getRangee() == 0){
                        y += caseHeureHeight;
                }
            }
            Point p = new Point(x, y);
            a.setPoint(p);
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
            a.setRangee(0);
            y += 3*caseHeureHeight/2;
        }
    }
    
    public void addActivite(String attributs){
        Activite nouvelActivite = new Activite(attributs, ",");
        this.listeActiviteComplete.add(nouvelActivite);
        this.listeActiviteAPlacer.add(nouvelActivite);
    }
    
    public int getEtiquette(){
        return this.indexEtiquette;
    }
    
    public void setEtiquetteActivite(int index){
        this.indexEtiquette = index;
        for (Activite a: this.getListeActiviteComplete()){
            String[] choixEtiquette = {a.getCode(), a.getNomActivite(), a.getType(), a.getProfesseur()};
            a.setEtiquette(choixEtiquette[index]);
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
                //System.out.println(a.getPoint());
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
               if( (listeComplete.get(i).getSessionFirstLetter() == session.charAt(0) ) 
                       &&
                   (listeComplete.get(i).activiteEstDansGrille(codeActivite) ) 
                  )
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
        String periode = "";
        if (this.session.equals("A")){
            periode = "Automne";
        }
        if (this.session.equals("E")){
            periode = "Été";
        }
        if (this.session.equals("H")){
            periode = "Hiver";
        }
        return periode;
    }
    
    public boolean getModeValidation(){
        return this.modeValidationAuto;
    }
    
    public void deplacerToutDansListe(){
        Vector<Activite> tempListe = new Vector<Activite>();
        
        for (Activite a: this.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee()){
            a.setJourChoisi(0);
            tempListe.addElement(a);
        }

        for (Activite a: tempListe){
            this.listeActiviteAPlacer.add(a);
            this.getListeActiviteDejaPlacee().remove(a);
        }
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
        ListePairesDActivites listeCoursMemeProf = new ListePairesDActivites() ;
        messagesDerreurs.add("Erreur:\n");
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

                    messagesDerreurs.add("\t---L'heure de debut de "  + "\" "+activite.getCode()+" \" "
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

                    messagesDerreurs.add("\t---L'heure de fin de " + "\" "+activite.getCode()+" \" "
                                          + " doit être <= "+ iPart +" h "+(long)fPart+ "\n"
                                          );

                }
                
                
                for(Activite activite2 : activiteDejaPlacee)
                {


                    if(! yaTilChevauchement(activite, activite2))continue;
                    
                   //un cours  ne peuvent se donner en meme tps que son lab
                     if( activite.getCode().equals(activite2.getCode()) )
                     {
                         if( ( (activite.getType().toLowerCase().contains("classe")))
                              &&
                             ((activite2.getType().toLowerCase().contains("labo")))
                            )
                         {
                             listeCoursLab.addPaire(activite, activite2);
                             reponse = false;
                         }
                         
                         else if((activite.getType().toLowerCase().contains("distance"))
                              &&
                             (activite2.getType().toLowerCase().contains("labo"))
                            )
                         {
                             listeCoursLab.addPaire(activite, activite2);
                             reponse = false;
                         }
                         
                         else if((activite.getType().toLowerCase().contains("labo"))
                              &&
                             (activite2.getType().toLowerCase().contains("distance"))
                            )
                         {
                              listeCoursLab.addPaire(activite, activite2);
                              reponse = false;
                         }
                         else if((activite.getType().toLowerCase().contains("labo"))
                              &&
                             (activite2.getType().toLowerCase().contains("classe"))
                            )
                         {
                              listeCoursLab.addPaire(activite, activite2);
                              reponse = false;
                         }
                         
                        //un prof ne peut donner deux cours differents en meme tps 
                         else if(activite.getProfesseur().equals(activite2.getProfesseur()) 
                             &&
                             (!activite.getType().equals(activite2.getType()) )
                             )
                          {
                              listeCoursMemeProf.addPaire(activite, activite2);
                              reponse = false;

                          }
              
                     }
                      
                     //un prof ne peut donner deux cours different en meme tps ( cas general )
                     else if(activite.getProfesseur().equals(activite2.getProfesseur()))
                    {
                        listeCoursMemeProf.addPaire(activite, activite2);
                        reponse = false;
                      
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
                
            messagesDerreurs.add( "\t---\" " + p.a1.getCode()+ " \"" +" et "
                    + "\" " +p.a2.getCode()+ " \"" + " ne peuvent avoir lieu en meme temps \n" 
                    );  
         }
           
         paires = listeCoursLab.getListe();
           for(PaireDActivites p : paires)
         {
                
            messagesDerreurs.add( "\t---\" "+p.a1.getCode() + " \" ne peut avoir lieu en meme temps que son laboratoire\n" 
                    );  
            
         }
        
          paires = listeCoursMemeProf.getListe();
           for(PaireDActivites p : paires)
         {
                
            messagesDerreurs.add( "\t---\" "+p.a1.getProfesseur() + " \" " + "ne peut donner " 
                                 + "\" " +p.a1.getCode() + " \" "  + "et " 
                                 +  "\" " +p.a2.getCode() + " \" "  + "en meme temps \n"
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
    
    public boolean getSaved(){
        return this.saved;
    }
    
    public void setSaved(){
        this.saved = true;
    }
    
    public void setUnsaved(){
        this.saved = false;
    }
    
    public void enregistrerCHE(String pathACopier, String pathAColler){
        InputStream is = null;
        OutputStream os = null;
        try{
            is = new FileInputStream(pathACopier);
            os = new FileOutputStream(pathAColler);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        }
        catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void enregistrerHoraire(String path){

        Vector<Activite> liste = new Vector<Activite>();
         
        try {

                String content = new String ("CodeActivite,Section,Titre,PROF,Type,Duree,DebutMin,FinMax,Jour,Heure \n");
                
                
                //activites deja placée
                liste = listeActiviteDejaPlacee.getListeActiviteDejaPlacee();
                
                for(Activite activite : liste)
                {
                    content += activite.getCode()+this.separateur;
                    content += activite.getSection()+this.separateur;
                    content += activite.getNomActivite()+this.separateur;
                    content += activite.getProfesseur()+this.separateur;
                    content += activite.getType()+this.separateur;
                    content += activite.getDuree()+this.separateur;
                    content += activite.getHeureDebutMin()+this.separateur;
                    content += activite.getHeureFinMax()+this.separateur;
                    content += activite.getJourChoisi()+this.separateur;
                    content += activite.getHeureDebutChoisi()+this.separateur;
                    content += activite.getRangee()+this.separateur + "\n";
    
                }
                
                //activites non placées
                liste = listeActiviteAPlacer.getListeActiviteAPlacer();
                
                for(Activite activite : liste)
                {
                    content+= activite.getCode()+this.separateur;
                    content+= activite.getSection()+this.separateur;
                    content+= activite.getNomActivite()+this.separateur;
                    content+= activite.getProfesseur()+this.separateur;
                    content+= activite.getType()+this.separateur;
                    content+= activite.getDuree()+this.separateur;
                    content+= activite.getHeureDebutMin()+this.separateur;
                    content+= activite.getHeureFinMax()+this.separateur + "\n" ;

                }
                


                File file = new File(path);

                if (!file.exists()) {
                        file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();


        } catch (IOException e) {
                e.printStackTrace();
        }
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
    

    public Vector<Float> getStatistiques(int jour,boolean calculerCongestionEtCovoiturage){
          
       Vector<Float> stats = new Vector<Float>();
       Vector<Activite> listeDesActivites = getListeDesActivitesDUnJour(jour);
       
       stats.add(calculerNombreDeCours(listeDesActivites));
       stats.add(calculerNombreMaxDeCours(listeDesActivites));
       stats.add(calculerNombreMoyenDeCours(listeDesActivites));
       
       if(calculerCongestionEtCovoiturage)
       {
        stats.add(calculerIndiceCovoiturage());
        stats.add(calculerIndiceCongestion());
       }
        
        return stats;
    }
      
}