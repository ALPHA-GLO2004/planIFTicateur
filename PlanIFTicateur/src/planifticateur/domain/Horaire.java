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
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.lang.Object;
import java.nio.charset.Charset;

public class Horaire{
    //Ajout de ma part, ça me semblait essentiel
    private boolean saved = false;
    private String rechercherNom = "";
    private String fichierCOU;
    private String fichierCHE;
    private List<String> listeActivite = new ArrayList<String>();
    private List<String> listeGrille = new ArrayList<>();
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
    private boolean activiteHorsGrille =false;
    private int nbCoursHorsGrille=0;
    private int compteur=0;
    public Horaire(String filePath, String sessionChoisi){
        //Constructeur -- Ne fais que prendre le fichier et attribuer chaque élément contenu
        //dans ce fichier au bon endroit. Ensuite fait appel au controller pour créer les activités
        String[] tabString = filePath.split("\\\\");
        this.session = sessionChoisi;
        String nomFichier = tabString[tabString.length-1];
               nomFichier = nomFichier.substring(0, (nomFichier.length() - 4));
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
            fluxCHE.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    
    private void lireFichier(String filePath){
        //Fonction pour transformer un fichier CSV en liste de string de son contenu
        //avec l'aide du séparateur ";"
        try{
            //Lecture du fichier avec conversion pour garder les accents
            FileInputStream fluxIS = new FileInputStream(filePath);
            InputStreamReader fluxISR = new InputStreamReader(fluxIS, "858");
            BufferedReader flux = new BufferedReader(fluxISR);
            for (String line = flux.readLine(); line != null; line = flux.readLine()){
                listeActivite.add(line);
            }
            flux.close();
            fluxIS.close();
            fluxISR.close();
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
                    && a.getHeureDebutChoisi() >= act.getHeureDebutChoisi()
                    && act.getRangee() == a.getRangee()
                    && act.getCode() != a.getCode()){
                        y += caseHeureHeight;
                }
                if (a.getJourChoisi() == act.getJourChoisi()
                    && a.getHeureDebutChoisi() + a.getDuree() <= act.getHeureDebutChoisi() + act.getDuree()
                    && a.getHeureDebutChoisi() + a.getDuree() > act.getHeureDebutChoisi()
                    && act.getRangee() == a.getRangee()
                    && act.getCode() != a.getCode()){
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
            Point p = new Point(widthListe + 2*saut, y);
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
        messagesDerreurs.add("Erreur(s):\n");
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
                         else if(activite.getProfesseur().equals(activite2.getProfesseur()) )
                          {
                             if(!activite.getType().equals(activite2.getType()))
                             {
                                listeCoursMemeProf.addPaire(activite, activite2);
                                reponse = false;
                             }
                             else if(!activite.getSection().equals(activite2.getSection()))
                             {
                                listeCoursMemeProf.addPaire(activite, activite2);
                                reponse = false; 
                             }

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
    
    public void rechercherNom(String saisie){
        if (saisie.length() > 2){
            this.rechercherNom = saisie;
        }
        else{
            this.rechercherNom = "";
        }
    }
    
    public void viderRechercherNom(){
        rechercherNom = "";
    }
    
    public String getRechercherNom(){
        return this.rechercherNom;
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
    
    public void ajouterGrille(String grille, String path){
        try{            
            String toutesGrilles = new String("");
            
            BufferedReader loadCHE = new BufferedReader(new FileReader(path.substring(0, path.length() - 3) + "CHE"));
            for (String line = loadCHE.readLine(); line != null; line = loadCHE.readLine()){
                toutesGrilles += line;
                toutesGrilles += "\n";
            }
            loadCHE.close();
            toutesGrilles += grille;
            
            FileOutputStream file = new FileOutputStream(path.substring(0, path.length() - 3) + "CHE");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(file, "858"));
            System.out.println(toutesGrilles);
            bw.write(toutesGrilles);
            bw.close();
            
            //ajustement grilles avec fichier CHE
            BufferedReader fluxCHE = new BufferedReader(new FileReader(path.substring(0, path.length() - 3) + "CHE"));
            for (String line = fluxCHE.readLine(); line != null; line = fluxCHE.readLine()){
                listeGrille.add(line);
            }
            listeGrille.remove(0);
            for (String elementGrille: listeGrille){
                GrilleCheminement g = new GrilleCheminement(elementGrille,",");
                listeGrilleCh.add(g);
            }
            fluxCHE.close();
            
        }catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
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
                


                FileOutputStream file = new FileOutputStream(path);

                /*if (!file.exists()) {
                        file.createNewFile();
                }
                
                //FileWriter fw = new FileWriter(file.getAbsoluteFile());*/
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(file, "858"));
                bw.write(content);
                bw.close();
                
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
        
 //-----------trois methodes de planification automatiques : n decomentant on peut le tester ----------------------------------------//   
 /*       public void genererAutomatiquement(Dimension initialDimension){
        //Planification automatique 
        //on scan l horaire avec une strategie d'espacer les cours d'un jour et ou de quelques heures
//        deplacerToutDansListe();//toutes les activites passent a droites;      
//        chargerAvecNormes(initialDimension); 
         while(this.getListeActiviteAPlacer().size() > 0) {
             placerToutesLesActivite(obtenirTousLesPointHoraire(initialDimension),initialDimension);
         }
        }
 */
    
    public void genererAutomatiquement(Dimension initialDimension){
        //Planification automatique 
        //on scan l horaire avec une strategie d'espacer les cours d'un jour et ou de quelques heures
        deplacerToutDansListe();//toutes les activites passent a droites;      
        
 //        while(this.getListeActiviteAPlacer().size() > 0) {
            chargerAvecNormes(initialDimension); 
 //        }
  }
    
    
  /*  
    public void genererAutomatiquement(Dimension initialDimension){
        //Planification automatique 
        //on scan l horaire avec une strategie d'espacer les cours d'un jour et ou de quelques heures
        deplacerToutDansListe();//toutes les activites passent a droites;      
       while(this.getListeActiviteAPlacer().size() > 0) {
           placerToutesLesActivites(initialDimension);
       }
   }
 */   
    
    
    public void placerToutesLesActivites(Dimension initialDimension){
        List<String> listSession = new Vector<String>();
        
        listSession.add("H");
        listSession.add("A");
        listSession.add("E");
        String[] coordonnees={"0","0","0"};
        for(String version : listeGrilleCh.getListeGrilleChAllVersion()) //Pour chaque les version de la grille : H2015, A2015, E2015,H2014, A2014, E2014,  
        {
            for(GrilleCheminement g : listeGrilleCh.getListeGrilleChVersion(version)){//toutes les grilles d une meme version 
                
              for(String session : listSession){//pour chaque session de la grille 
                  
                if(g.session.substring(0,1).compareToIgnoreCase(session)==0){//pour la meme session
                    for(String s : g.getListeDesCodesDactivites()){//on parcourt la liste des cours de cet etudiant pour la session et connaitre le cours de debut et de fin pour cette journee 
                                                  //et on la cherche dans les activites du Lundi
					   //peut etre trier les activites a placer en fonction de l heure minimun 
                                           // trierListeAPlacerCroissanteHeureMinimun(this.getListeActiviteAPlacer());	
		       for(Activite a:this.getListeActiviteAPlacer()){//ou this.getListeComplete
                            
                             if(a.getCode().compareToIgnoreCase(s)==0){//activite est a placer alors il faut la placer ou reboucler 
                                 coordonnees = placerUneActiviteAHoraire(initialDimension,a,coordonnees);
                                 continue;
                             }     
                       }
                    }
                }
           }
        }
     }
   } 
            
        public boolean ActiviteEnConflit(List<Activite> LADP, Activite act){
		for(Activite a: LADP){
			if(yaTilChevauchement(a, act )){
				return true;
			}
		}
		return false;	
	}
	
	
	
    //placer activite qui ne doivent pas se chevaucher:
    
    //placer une activite par jour pour un meme grille de cheminement, meme version et meme session 
 
      // choisir un jour pour placer une activite. 
      // horaire doit etre plein, il faut eviter des trous 
      // connaitre la tailles des activites a placer pour avoir une idee si cela tient ou pas dans l hoaraire
      // pb : tu peux avoir des activites nombreuses mais avec une durre petite
      // algo choisir la meilleur place dans l horaire 
      // si horaire est plein alors message ou ne peux recevoir une nouvelle activite sans conflit
    
    public String[] placerUneActiviteAHoraire(Dimension dimension,Activite activite,String[] coordonnees){
        
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;             //les 32 cases heure with 
        int caseHeureHeight = caseJourHeight / 9;   //
        int saut = (width - caseJourWidth)/ 30;    //saut est (with - caseJourWith)  / 30 la  
        int jumpX;//voir le deplacement sur le l axe des x
        int jumpY;//voir le deplacement sur l'axe des y
        Point point =null;  //le point qui sera utilise 
        int pointX = 0;
        int pointY = 0;
        	
        //on enchaine 
        int i1= Integer.valueOf(coordonnees[0]);
        int j1= Integer.valueOf(coordonnees[1]);
        int k1= Integer.valueOf(coordonnees[2]);
        
        for (int j = j1; j <= 7; j++){//Pour chaque range d un jour  8 on est sur un meme jour 
            for (int k = k1; k <= 29; k++){// pour toutes les heures de la meme rangee  
		 for (int i = i1; i <= 4; i++){//pour chaque jour 
                             jumpX = caseJourWidth + k*saut;  //on a choisi un jumpX c'est le coin de l horaire 
                             
                             jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight; // pas trop de controle sur le y
                             //traitement du point qui est pris 
                             point = new Point(jumpX,jumpY);
                             
                             //le heure debut = 8+ (k)*0.5f  
                             float heureDebutChoisi = 8+ (k)*0.5f;
                             
                             if((heureDebutChoisi >= activite.getHeureDebutMin()) 
                                     &&(heureDebutChoisi <= activite.getHeureDebutMax()) //on a une chance
                                     && (heureDebutChoisi <= activite.getHeureFinMax())
                                )
                                {
                                activite.setPoint(point);
                                activite.setJourChoisi(i+1);
                                activite.setHeureDebutChoisi(heureDebutChoisi);
                                activite.setRangee(j+1);

                                 //on verifie si l activite peut causer un conflit 
                                if(!ActiviteEnConflit(listeActiviteDejaPlacee.getListeActiviteDejaPlacee(), activite))
                                {
                                    listeActiviteDejaPlacee.getListeActiviteDejaPlacee().add(activite);//on place activite
                                    //listeActiviteComplete.add(activite);
                                    listeActiviteAPlacer.remove(activite);//on la supprime 

                                    //validation de l horaire 
                                    Vector<String> msg = new Vector<String>();
                                    if(!horaireEstValide(msg)){
                                            //on desasigne
                                            activite.setPoint(new Point(0,0));//ou bien null new Point(0,0)!!!!!!!!!!!!!
                                            activite.setJourChoisi(0);
                                            activite.setHeureDebutChoisi(0);
                                            activite.setRangee(0);
                                            listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(activite);//on place activite
                                            listeActiviteAPlacer.add(activite);//on la supprime 										
                                    }else{
                                        coordonnees[0] = String.valueOf(i);
                                        coordonnees[1] = String.valueOf(j);
                                        coordonnees[2] = String.valueOf(k);
                                        return coordonnees;
                                    }
                                }else{
                                    //on desasigne
                                    activite.setPoint(new Point(0,0));//ou bien null new Point(0,0)!!!!!!!!!!!!!
                                    activite.setJourChoisi(0);
                                    activite.setHeureDebutChoisi(0);
                                    activite.setRangee(0);
                                    //listeActiviteComplete.remove(activite);
                                    listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(activite);//on place activite
                                    listeActiviteAPlacer.add(activite);//on la supprime 
                                }
                            } 
                        }
                    }                           
            }
          
     return new String[5];
    }
    
    
    public float[] ajouterUneActivite(float[] tableauCoordonne,Point point, int jour,int rangee, float heureDebutChoisi ,Dimension dimension){
        List<String> listSession = new Vector<String>();
        float[] cordonneesAct={0f,0f,0f,0f,0f,0f,0f,0f};//
        listSession.add("H");
        listSession.add("A");
        listSession.add("E");
        
        int i1=(int)tableauCoordonne[0];//on recupere les coordonnes des grilles chem et la liste
        int j1=(int)tableauCoordonne[1];
        int k1=(int)tableauCoordonne[2];
        int l1=(int)tableauCoordonne[3];
        int m1=(int)tableauCoordonne[4];
  
//addActivite: { 
        for( int i=i1; i < listeGrilleCh.getListeGrilleChAllVersion().size();i++) //Pour chaque les version de la grille : H2015, A2015, E2015,H2014, A2014, E2014,  
        {
            compteur = i;
            if (compteur == listeGrilleCh.getListeGrilleChAllVersion().size()-1){
                activiteHorsGrille=true;
                nbCoursHorsGrille=listeActiviteAPlacer.getListeActiviteAPlacer().size();
            }
            String version = listeGrilleCh.getListeGrilleChAllVersion().get(i);
            for(int j=j1;j<listeGrilleCh.getListeGrilleChVersion(version).size();j++){//toutes les grilles d une meme version 
                GrilleCheminement g = listeGrilleCh.getListeGrilleChVersion(version).get(j);
                for(int k=k1;k<listSession.size();k++){//pour chaque session de la grille 
                  String session =  listSession.get(k);
                if(g.session.substring(0,1).compareToIgnoreCase(session)==0){//pour la meme session
                    for(int l=l1;l<g.getListeDesCodesDactivites().size();l++){//on parcourt la liste des cours de cet etudiant pour la session et connaitre le cours de debut et de fin pour cette journee 
                        String s=   g.getListeDesCodesDactivites().get(l);                            //et on la cherche dans les activites du Lundi
					   //peut etre trier les activites a placer en fonction de l heure minimun 
                         if ()                     
  //                                          trierListeAPlacerCroissanteHeureMinimun(this.getListeActiviteAPlacer());	
                        for(int m=m1; m<this.getListeActiviteAPlacer().size();m++){//ou this.getListeComplete
                            Activite a = this.getListeActiviteAPlacer().get(m);
                            
                             if(a.getCode().compareToIgnoreCase(s)==0){//activite est a placer alors il faut la placer ou reboucler 
                                 //on assigne 
                                 if((heureDebutChoisi >= a.getHeureDebutMin())//on a une chance
                                         &&(heureDebutChoisi >= a.getHeureDebutMax())
                                         && (heureDebutChoisi <= a.getHeureDebutMax())
                                    )
                                 {//heure miniumun depasse
									
                                    a.setPoint(point);
                                    a.setJourChoisi(jour);
                                    a.setHeureDebutChoisi(heureDebutChoisi);
                                    a.setRangee(rangee);

 //                                   //on verifie si l activite est deja place 
  //                           if(!ActiviteEnConflit(listeActiviteDejaPlacee.getListeActiviteDejaPlacee(), a))//-------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 //                               {//la LDP ne contient pas cette activite deja 
                                    listeActiviteDejaPlacee.getListeActiviteDejaPlacee().add(a);//on place activite
                                    listeActiviteAPlacer.remove(a);//on la supprime 
                                    //listeActiviteComplete.add(a);
                                    //validation de l horaire 
                                    Vector<String> msg = new Vector<String>();
                                    if(horaireEstValide(msg)){//alors 
                                                                                  //on sauve les positions pour la prochaine activite a placer 
                                            tableauCoordonne[0]=i;//version suivante 
                                            tableauCoordonne[1]=j;//grille suivant 
                                            tableauCoordonne[2]=k;//session suivante 
                                            tableauCoordonne[3]=l;//on passe au code d activite suivant de la grille
                                            tableauCoordonne[4]=m+1;//on passe a l activite suivante
 //                                           break addActivite;
                                            
                                             //il faut sauter la duree de l'activite sur cette ligne pour placer la prochaine apres cette ligne 
                                            //ce saut est est a faire a la ligne jour*
                                            tableauCoordonne[5]=jour-1;
                                            tableauCoordonne[6]=rangee-1;
                                            tableauCoordonne[7]=((heureDebutChoisi + a.getDuree())-8)*2;//6cases sont sautes, ce saut est a prevoir sur cette range

                                    } else {//l activite n est pas valide
                                            //on sauve les coodonnees de l activite a placer
                                            //il faut aller trouver un nouveau point
                                            tableauCoordonne[0]=i;
                                            tableauCoordonne[1]=j;
                                            tableauCoordonne[2]=k;
                                            tableauCoordonne[3]=l;
                                            tableauCoordonne[4]=m; //on reste sur la meme activite
                                            tableauCoordonne[5]=jour-1;	//
                                            tableauCoordonne[6]=rangee-1;
                                            tableauCoordonne[7]=1.0f;//pas de saut a cette adresse 
                                            //on desasigne
                                            a.setPoint(new Point(0,0));//ou bien null new Point(0,0)!!!!!!!!!!!!!
                                            a.setJourChoisi(0);
                                            a.setHeureDebutChoisi(0);
                                            a.setRangee(0);
                                            listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(a);//on place activite
                                            listeActiviteAPlacer.add(a);//on la supprime 
                                            //listeActiviteComplete.remove(a);
                                    //il faut sortir des boucles 
 //                                           break addActivite;										
                                    }
//}
   /*
           else{  //activite est en conflit alors on cherche une nouveau point a lui assigner 
                                            tableauCoordonne[0]=i;
                                            tableauCoordonne[1]=j;
                                            tableauCoordonne[2]=k;
                                            tableauCoordonne[3]=l;
                                            tableauCoordonne[4]=m; //on reste sur la meme activite
                                            tableauCoordonne[5]=jour-1;	//
                                            tableauCoordonne[6]=rangee-1;
                                            tableauCoordonne[7]=1.0f;//pas de saut a cette adresse 
                                            //on desasigne
                                            a.setPoint(new Point(0,0));//ou bien null new Point(0,0)!!!!!!!!!!!!!
                                            a.setJourChoisi(0);
                                            a.setHeureDebutChoisi(0);
                                            a.setRangee(0);
                                            listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(a);//on place activite
                                            listeActiviteAPlacer.add(a);//o
                                           
                                    //il faut sortir des boucles 
 //                                           break addActivite;										
    } */
}//l heure de l activite n est pas dans la bonne zone de validite de l horaire 
                                    //alors on 
								 
                             } //supposons que toues les activites appartiennent a une grille 
							 
                        }
                    }
                     
                }              
            }
          }
        }
//	}
        return cordonneesAct;
    }     

	
/*	
	public List<Activite> trierListeAPlacerCroissanteHeureMinimun(List<Activite> LAP){
		List<Activite> listeTrie = LAP;
		boolean permut;
		Activite tampon = null;
		do {
		    // hypothÃ¨se : la liste est triÃ©e
			permut = false;
			for(int i=0; i< listeTrie.size()-1;i++){
			// 2 Ã©lÃ©ments successifs sont dans le bon ordre ou non
			//
				if (LAP.get(i).getHeureDebutMin() > LAP.get(i+1).getHeureDebutMin()) {
				// s'ils ne le sont pas, on Ã©change leurs positions
						tampon = LAP.get(i);
						LAP.remove(i) ;
                                                LAP.add(i,LAP.get(i+1)); 
						LAP.remove(i+1);
                                                LAP.add(i+1,tampon);
						permut = true;
				  }
		    }
		 } while (permut);
		 
		return LAP;
	}
*/	
        
     
    
public float[] donnerJourHeure(Point point, Dimension initialDimension){
        float[] jourHeure= new float[2];
        int width = initialDimension.width *3/4;
        int caseJourWidth = width / 16;
        int saut = (width - caseJourWidth)/30;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseHeureHeight = caseJourHeight / 9;
        
        for (int i = 8; i <= 22; i++){
            if (point.y >= caseHeureHeight && point.y < caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jourHeure[0] = 1.0f;
                    jourHeure[1] = i;
                    return jourHeure;
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                     jourHeure[0] = 1.0f;
                    jourHeure[1] = i + 0.5f;
                    return jourHeure;
                }
            }
            if (point.y >= caseJourHeight + caseHeureHeight && point.y < 2*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jourHeure[0] = 2.0f;
                    jourHeure[1] = i;
                    return jourHeure;
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jourHeure[0] = 2.0f;
                    jourHeure[1] = i+0.5f;
                    return jourHeure;
                }
            }
            if (point.y >= 2*caseJourHeight + caseHeureHeight && point.y < 3*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jourHeure[0] = 3.0f;
                    jourHeure[1] = i;
                    return jourHeure;
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jourHeure[0] = 3.0f;
                    jourHeure[1] = i+0.5f;
                    return jourHeure;
                }
            }
            if (point.y >= 3*caseJourHeight + caseHeureHeight && point.y < 4*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jourHeure[0] = 4.0f;
                    jourHeure[1] = i;
                    return jourHeure;
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jourHeure[0] = 4.0f;
                    jourHeure[1] = i+0.5f;
                    return jourHeure;
                }
            }
            if (point.y >= 4*caseJourHeight + caseHeureHeight && point.y < 5*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jourHeure[0] = 5.0f;
                    jourHeure[1] = i;
                    return jourHeure;
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                     jourHeure[0] = 5.0f;
                    jourHeure[1] = i+0.5f;
                    return jourHeure;
                }
            }            
            caseJourWidth += 2*saut;         
        }
      return null;  
   }
       
   public boolean placerToutesLesActivite(Point[] tableauPoint, Dimension initialDimension){
        List<String> listSession = new Vector<String>();
        listSession.add("H");
        listSession.add("A");
        listSession.add("E");   
        float heureDebutChoisi =0.0f;
        int jour =0;
        for( String version : listeGrilleCh.getListeGrilleChAllVersion()) //Pour chaque les version de la grille : H2015, A2015, E2015,H2014, A2014, E2014,  
        {
            for(GrilleCheminement g : listeGrilleCh.getListeGrilleChVersion(version)){//toutes les grilles d une meme version 
                
                for(String session : listSession){//pour chaque session de la grille 
                   
                  if(g.session.substring(0,1).compareToIgnoreCase(session)==0){//pour la meme session
                    for(String s:g.getListeDesCodesDactivites()){//on parcourt la liste des cours de cet etudiant pour la session et connaitre le cours de debut et de fin pour cette journee 	
                       
                        for(Activite a  : this.getListeActiviteAPlacer()){//ou this.getListeComplete
                            
 //                            if(a.getCode().compareToIgnoreCase(s)==0){//activite est a placer alors il faut la placer ou reboucler 
                               boolean assignation=false;  
             assigne:      do{   
                                int indice = 0;
                                for(Point point: tableauPoint){
                                   if(point != null){
                                    jour=(int)(donnerJourHeure(point,initialDimension)[0]);
                                    heureDebutChoisi = donnerJourHeure(point,initialDimension)[1];
                                   
                                            if((heureDebutChoisi >= a.getHeureDebutMin())//on a une chance
                                                    &&(heureDebutChoisi >= a.getHeureDebutMax())
                                                    && (heureDebutChoisi <= a.getHeureDebutMax())
                                              )
                                              {//heure miniumun depasse
                                               a.setPoint(point);
                                               a.setJourChoisi(jour);
                                               a.setHeureDebutChoisi(heureDebutChoisi);
           //                                    a.setRangee(rangee);
                                               listeActiviteDejaPlacee.getListeActiviteDejaPlacee().add(a);//on place activite
                                               //listeActiviteComplete.add(a);
                                               listeActiviteAPlacer.remove(a);//on la supprime 
                                               
                                               //validation de l horaire 
                                               Vector<String> msg = new Vector<String>();
                                               if(horaireEstValide(msg)){//on garde un bon point
                                                   assignation =true;
                                                  //on met a null les point de la duree
                                                  int k=indice;
                                                  int duree=(int)(a.getDuree());
                                                  tableauPoint[k]=null; 
                                                  for(int d=0 ; d< 2*duree;d++){
                                                      k++;
                                                      
                                                      tableauPoint[k]=null; //pas d assignation de ces points 
                                                  }
                                                break assigne;  
            //                                    tableauCoordonne[7]=((heureDebutChoisi + a.getDuree())-8)*2;//6cases sont sautes, ce saut est a prevoir sur cette range
                                               } else {//l activite n est pas valide
                                                       //on desasigne
                                                       a.setPoint(new Point(0,0));
                                                       a.setJourChoisi(0);
                                                       a.setHeureDebutChoisi(0);
                                       //              a.setRangee(0);
                                                       listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(a);//on place activite
                                                       //listeActiviteComplete.remove(a);
                                                       listeActiviteAPlacer.add(a);//on la supprime 
                                                       assignation=false;
                                                }
                                        }else{  //activite est en conflit alors on cherche une nouveau point a lui assigner 
                                            
                                            a.setPoint(new Point(0,0));//ou bien null new Point(0,0)!!!!!!!!!!!!!
                                            a.setJourChoisi(0);
                                            a.setHeureDebutChoisi(0);
                                            a.setRangee(0);
                                            listeActiviteDejaPlacee.getListeActiviteDejaPlacee().remove(a);//on place activite
                                            //listeActiviteComplete.remove(a);
                                            listeActiviteAPlacer.add(a);//o
                                            assignation=false;
                                       } 
                                }
                               indice ++;
                             } //supposons que toues les activites appartiennent a une grille 
							 
                            
                          }while(!assignation);
//                        }
                     
                      }              
                    }
                  }
               }

        
              }
        }
        return true;
    }        
     
    
            
     public Point[] obtenirTousLesPointHoraire(Dimension dimension){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;             //les 32 cases heure with 
        int caseHeureHeight = caseJourHeight / 9;   //
        int saut = (width - caseJourWidth)/ 30;    //saut est (with - caseJourWith)  / 30 la  
        int jumpX;//voir le deplacement sur le l axe des x
        int jumpY;//voir le deplacement sur l'axe des y
        
        
        Point[] allPoint=new Point[40*30];
        int indice=0;
       
          for (int j = 0; j <= 7; j++){//Pour chaque range d un jour  8   
            for (int i = 0; i <= 4; i++){//pour chaque jour
             for (int k = 0; k <= 29; k++){// pour toutes les heures de la meme rangee  
                jumpX = caseJourWidth + k*saut;  //on a choisi un jumpX c'est le coin de l horaire 

                jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight; // pas trop de controle sur le y
                //traitement du point qui est pris 
                Point point = new Point(jumpX,jumpY);
                allPoint[indice]=point;
                indice ++;                                                   		
           }
        }
    }
    return allPoint;
}   
        
        
        
    //placer activite qui ne doivent pas se chevaucher:
    
    //placer une activite par jour pour un meme grille de cheminement, meme version et meme session 
 
      // choisir un jour pour placer une activite. 
      // horaire doit etre plein, il faut eviter des trous 
      // connaitre la tailles des activites a placer pour avoir une idee si cela tient ou pas dans l hoaraire
      // pb : tu peux avoir des activites nombreuses mais avec une durre petite
      // algo choisir la meilleur place dans l horaire 
      // si horaire est plein alors message ou ne peux recevoir une nouvelle activite sans conflit
    
    public boolean chargerAvecNormes(Dimension dimension){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;             //les 32 cases heure with 
        int caseHeureHeight = caseJourHeight / 9;   //
        int saut = (width - caseJourWidth)/ 30;    //saut est (with - caseJourWith)  / 30 la  
        int jumpX;//voir le deplacement sur le l axe des x
        int jumpY;//voir le deplacement sur l'axe des y
        Point point =null;  //le point qui sera utilise 
        int pointX = 0;
        int pointY = 0;
        String[][] jouRangee = {{"0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0"},
                                {"0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0"},
                                {"0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0"},
                                {"0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0"},
                                {"0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0","0;0;0"}};
        
        float[] cordonneesAct={0f,0f,0f,0f,0f,0f,0f,0f};//rien dans  indice zero, les 40 premiers representent representent le saut sur chaque ligne 
        
        //tant que c est pas place qui 
	//prevoir si horaire est plein ou ne peut plus recevoir un element 	sans conflit 
	//si la liste d'activite a placer est vide alors on sort 
	
 //quitter:{
//	if (listeActiviteAPlacer.getListeActiviteAPlacer().size() != 0 ){
			
				
                        
                          for (int i = 0; i <= 4; i++){//pour chaque jour 
                            
                             
                            for (int j = 0; j <= 7; j++){//Pour chaque range d un jour  8   
                              for (int k = 0; k <= 29; k++){// pour toutes les heures de la meme rangee  
                                  
                             jumpX = caseJourWidth + k*saut;  //on a choisi un jumpX c'est le coin de l horaire 
                             
                             jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight; // pas trop de controle sur le y
                             //traitement du point qui est pris 
                             point = new Point(jumpX,jumpY);
                             
                             //placer le point et valider 
                             //si pas ok alors il faut la remettre a droite  
                             //le heure debut = 8+ (k)*0.5f   
                             
                             // si 
                             // 
                             
                             String[] split = jouRangee[i][j].split(";");
                             int i1 = Integer.valueOf(split[0]);
                             int j1 = Integer.valueOf(split[1]);
                             float k1 = Float.valueOf(split[2]);
							 
//			   if(i1 == listeGrilleCh.getListeGrilleChAllVersion().size() -1 ) { return true;}  //ici on a fait le tour de toutes les cases et c est //impossible de placer une activite
							 
 //                          if((i==i1 )&&(j==j1) &&(k>=k1)){//sur cette duree on ne calcule pas
                             cordonneesAct =  ajouterUneActivite(cordonneesAct,point,i+1,j+1,8+(k)*0.5f, dimension); 
                             int i2= (int)cordonneesAct[5];
                             int j2= (int)cordonneesAct[6];
                             float k2= cordonneesAct[7];
                             //on range les valeurs 
                             jouRangee[i2][j2]=String.valueOf(i2)+";"+String.valueOf(j2)+";" + String.valueOf(k1+k2);   //                       
 //                           } //dans le else il ne passe rien on avance sur les autres cases
							
                          }
 //                 int activiteHeight = dimension.height /45;     //9*5=45 tranche de height
               }
           }
//	  } 
 //       else{
//			break quitter;
		//	return true;
//	  }
//    }  
     return true;
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
        float maxCoursParJours = 0.0f;
        List<GrilleCheminement> listeGrilleCheminementCharger = listeGrilleCh.getListeGrilleCh();
        for (GrilleCheminement grilleCheminement : listeGrilleCheminementCharger){
            float nbCoursParJours =0.0f;
            if (grilleCheminement.getSessionFirstLetter() == this.session.charAt(0)){
                
            
                for (Activite activite : listeDesActivites) {
                
                     if (grilleCheminement.activiteEstDansGrille(activite.getCode())){
                    
                          nbCoursParJours= nbCoursParJours + 1.0f;
                     }
                     maxCoursParJours = Math.max(maxCoursParJours, nbCoursParJours);
                 }
            }
          }
        return maxCoursParJours;
    }
    
    public float calculerNombreMoyenDeCours(Vector<Activite> listeDesActivites){
        float nombreMoyenDeCours=0.0f;
       
        for (GrilleCheminement grilleCheminement : listeGrilleCh.getListeGrilleCh()){
             float nbCoursParJours =0.0f;
            for (Activite activite : listeDesActivites) {
                
                if (grilleCheminement.activiteEstDansGrille(activite.getCode())){
                    
                    nbCoursParJours += 1.0f;
                }
            }  
            nombreMoyenDeCours += nbCoursParJours;
          }
        return nombreMoyenDeCours/listeGrilleCh.getListeGrilleCh().size();
    }
    
    
    public float calculerIndiceCovoiturage(){
        float indiceCovoiturage = 0.0f;
        for(int i=1;i<=5;i++){
           indiceCovoiturage +=   calculerIndiceCovoiturageUnJour(i);
        }
        return indiceCovoiturage/5;//on divise pour avoir la moyenne et ce ne doit jamais depasser 100
    }
    
    public float calculerIndiceCovoiturageUnJour(int jour){
        //connaitre le premier cours et le dernier cours de chaque grille de cheminement
        //avoir la liste des cours d'une session de la grille
        //si pour un meme jour, 2 activite d'une meme session commencent et fnissent le meme jour 
        //alors l'indice de covoiturage est de   
        Vector<Activite> listeActivitePourUnJourSemaine = getListeDesActivitesDUnJour(jour);//activite pour un jour exemple du Lundi
        //on prend la liste de cheminement de la session choisi
        
        float indiceCovoiturage=0;//
        
        for( String version : listeGrilleCh.getListeGrilleChAllVersion()) //Pour chaque les version de la grille : H2015, A2015, E2015,H2014, A2014, E2014,  
        {
            List<Activite> listAllActiviteDebutEtActiviteFin = new Vector<Activite>();
            for(GrilleCheminement g:listeGrilleCh.getListeGrilleChVersion(version)){//toutes les grilles d une meme version 
                if(g.session.substring(0,1).compareToIgnoreCase(session)==0){//pour la meme session
                    Activite activiteDebut=null; //on cherche a connaitre ses deux activites de debut et de fin pour ce jour 
                    Activite activiteFin=null;  //
                    for(String s:g.getListeDesCodesDactivites()){//on parcourt la liste des cours de cet etudiant pour la session et connaitre le cours de debut et de fin pour cette journee 
                                                        //et on la cherche dans les activites du Lundi
                        for(Activite a : listeActivitePourUnJourSemaine){//on cherche 
                             if(a.getCode().compareToIgnoreCase(s)==0){//activite est deja place alors 
                                if(activiteDebut==null){//la premiere activite 
                                 activiteDebut=a;
                                // activiteFin=a;
                                }else{//on a des activites deja 
                                        if(activiteDebut.getHeureDebutChoisi()> a.getHeureDebutChoisi()){//une activite qui commence plus tot
                                         //on echange 
                                            activiteDebut = a;//c est la premiere activite de l etudiant
                                        }
                                }
                       
                                if(activiteFin==null){//la premiere activite 
                                    activiteFin=a;
                                   }else{//on a des activites deja 
                                            if(activiteFin.getHeureDebutChoisi() < a.getHeureDebutChoisi()){
                                                 activiteFin = a;//on echange 
                                             }
                                   }   
                              } 
                        }
                    }
                  listAllActiviteDebutEtActiviteFin.add(activiteDebut);//en position paire 
                  listAllActiviteDebutEtActiviteFin.add(activiteFin);//en position impaire     
                }
                
            }
            indiceCovoiturage = indiceCovoiturage + getIndiceCovParVersion(listAllActiviteDebutEtActiviteFin);
        }
 //       return (indiceCovoiturage);
        return ((indiceCovoiturage*100.0f)/listeGrilleCh.getListeGrilleCh().size());//la liste chemin = petites listes par version
    }     
        
     public float getIndiceCovParVersion(List<Activite> listAllActiviteDebutEtActiviteFin){
        float indiceCovoiturage = 0.0f;
        for( int i=0;i<listAllActiviteDebutEtActiviteFin.size();i+=2 )//on prends 2 activites a la fois 
        {
            if(listAllActiviteDebutEtActiviteFin.get(i)==null
                    && listAllActiviteDebutEtActiviteFin.get(i+1)==null){
                    continue;
            }
            //si les activite debut et fin ne sont pas null
            if(listAllActiviteDebutEtActiviteFin.get(i)!=null //l etudiant a au moins deux cours dans la meme journee
                    && listAllActiviteDebutEtActiviteFin.get(i+1)!=null){//si c est une seule sctivite alors elle sera activite debut et fin 
                
                 for(int j=i+2;j<listAllActiviteDebutEtActiviteFin.size();j+=2)
                 { 
                        if(listAllActiviteDebutEtActiviteFin.get(j)==null 
                            && listAllActiviteDebutEtActiviteFin.get(j+1)==null){
                                continue;
                        }
                        
                         if(listAllActiviteDebutEtActiviteFin.get(j)!=null 
                            && listAllActiviteDebutEtActiviteFin.get(j+1)!=null){
                             
                             if((listAllActiviteDebutEtActiviteFin.get(i).getHeureDebutChoisi()//2 activites debut  deux grilles commencent en meme temps
                                     == listAllActiviteDebutEtActiviteFin.get(j).getHeureDebutChoisi())
                                     && ((listAllActiviteDebutEtActiviteFin.get(i+1).getHeureDebutChoisi()+ //2 activites fin  deux grilles  finissent en meme temps
                                     listAllActiviteDebutEtActiviteFin.get(i+1).getDuree())//2 cours peuvent finir en meme temps sans commencer en temps : 15h-17h et 14h-17h
                                     == (listAllActiviteDebutEtActiviteFin.get(j+1).getHeureDebutChoisi()+
                                     listAllActiviteDebutEtActiviteFin.get(j+1).getDuree()))
                                     ){
                                 indiceCovoiturage += 1;//deux etudiants peuvent voyager ensemble
                             }
  //                       }
                     }
                 }
            } 
        }
        
 //     if(listeGrilleCheminementPourSession == null || listeGrilleCheminementPourSession.size() == 0){
 //         indiceCovoiturage = 0;
 //     }else{
 //         indiceCovoiturage = ((indiceCovoiturage*100)/listeGrilleCheminementPourSession.size());
 //     }
      return indiceCovoiturage;
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
