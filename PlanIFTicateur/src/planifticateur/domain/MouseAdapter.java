
package planifticateur.domain;
import java.awt.*;
import java.util.List;

public class MouseAdapter {
    private Dimension dimension;
    private String position;
    private float dureeActiviteSelected;
    private float heureFinMax;
    private float heureDebutMin;
    private String codeSelected;
    private String typeSelected;
    public String session ;
    
    public MouseAdapter(Dimension d){
        this.dimension = d;

    }
    //Méthode pour déterminer le chiffre correspondant à la rangée où est placée une activité
    public int verificationRangee(Point p){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseHeureHeight = caseJourHeight / 9;
        int rangee = 0;
        int jumpY;
        
        for (int i = 0; i <= 4; i++){
            for (int j = 1; j <= 8; j++){
                jumpY = i*caseJourHeight + j*caseHeureHeight;
                if (p.x <= width){
                    if (p.y > jumpY && p.y <= jumpY + caseHeureHeight){
                        rangee = j;
                    }
                }
            }
        }
        return rangee;
    }
    
    //Méthode pour snaper les activités à la grille horaire
    public Point verificationDrop(Point p, List<Activite> laC, List<Activite> laDP, List<GrilleCheminement> laGC, boolean modeValidationAuto,String session){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        int jumpX;
        int jumpY;
        int pointActiviteX = 0;
        int pointActiviteY = 0;
            for (int i = 0; i <= 4; i++){
                for (int j = 0; j <= 7; j++){
                    for (int k = 0; k <= 29; k++){
                        if (p.x > caseJourWidth && p.x < dimension.width && p.y > caseHeureHeight && p.y <= height){
                            jumpX = caseJourWidth + k*saut;
                        
                            if (p.x >= jumpX && p.x < (jumpX + saut)){
                                if (p.y >= 0 && p.y < caseHeureHeight){
                                    jumpX = 0;
                                }
                                if (p.y >= caseJourHeight && p.y < caseJourHeight+caseHeureHeight){
                                    jumpX = 0;
                                }
                                if (p.y >= 2*caseJourHeight && p.y < 2*caseJourHeight+caseHeureHeight){
                                    jumpX = 0;
                                }
                                if (p.y >= 3*caseJourHeight && p.y < 3*caseJourHeight+caseHeureHeight){
                                    jumpX = 0;
                                }
                                if (p.y >= 4*caseJourHeight && p.y < 4*caseJourHeight+caseHeureHeight){
                                    jumpX = 0;
                                }
                                else{
                                    pointActiviteX = jumpX;
                                }
                            }
                        }
                        else{
                            pointActiviteX = 0;
                            pointActiviteY = 0;
                        }
                    }
                    
                    jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight;
                    if (p.y >= jumpY && p.y < jumpY + caseHeureHeight){
                        pointActiviteY = jumpY;
                    }
                }
            }
            
            if (p.x >= width){
                pointActiviteX = 0;
                pointActiviteY = 0;
            }
            
            int activiteHeight = dimension.height /45;
            
            for (Activite a: laC){
                if (a.isSelected()){
                    dureeActiviteSelected = a.getDuree();
                    heureFinMax = a.getHeureFinMax();
                    heureDebutMin = a.getHeureDebutMin();
                    codeSelected = a.getCode();
                    typeSelected = a.getType();
                }
            }
            
            for (Activite a: laDP){
                if (pointActiviteY == a.getPoint().y 
                    && pointActiviteX + (int)(dureeActiviteSelected*2*saut) > a.getPoint().x
                    && pointActiviteX < (a.getPoint().x + (int)(a.getDuree()*2*saut))){
                        pointActiviteX = 0;
                        pointActiviteY = 0;
                    }
                if (pointActiviteY == a.getPoint().y 
                    && pointActiviteX < (a.getPoint().x + (int)(a.getDuree() *2*saut))
                    && pointActiviteX + (int)(dureeActiviteSelected*2*saut) > a.getPoint().x){
                        pointActiviteX = 0;
                        pointActiviteY = 0;
                    }
            }

            if (modeValidationAuto){
                if ((pointActiviteX + (int)(dureeActiviteSelected * ((width - (caseJourWidth))/15))) > (int)(caseJourWidth + (heureFinMax - 8)*2*saut)
                    || pointActiviteX < (int)(caseJourWidth + (heureDebutMin - 8)*2*saut)){
                    pointActiviteX = 0;
                    pointActiviteY = 0;
                }
                
                for (Activite b: laDP){
                    if ((typeSelected.toLowerCase().contains("labo") && b.getType().toLowerCase().contains("classe")) || (typeSelected.toLowerCase().contains("classe") && b.getType().toLowerCase().contains("labo"))){
                        if (pointActiviteX < (int)((b.getHeureDebutChoisi()-8 + b.getDuree())*2*saut) + caseJourWidth
                                        && pointActiviteX + (int)(dureeActiviteSelected *2*saut) > b.getPoint().x
                                        && p.y >= (int)((b.getJourChoisi()-1)*caseJourHeight) + caseHeureHeight
                                        && p.y < (int)(b.getJourChoisi()*caseJourHeight)){
                            pointActiviteX = 0;
                            pointActiviteY = 0;
                        }
                    }
                    for (GrilleCheminement grille: laGC){
                        

                        if ( grille.activiteEstDansGrille(codeSelected) 
                                && 
                            grille.getSessionFirstLetter()== session.charAt(0) //new yann
                            )
                        {
                            
                            if (grille.activiteEstDansGrille(b.getCode())){
                                
                                    if (pointActiviteX < (int)((b.getHeureDebutChoisi()-8 + b.getDuree())*2*saut) + caseJourWidth
                                        && pointActiviteX + (int)(dureeActiviteSelected *2*saut) > b.getPoint().x
                                        && p.y >= (int)((b.getJourChoisi()-1)*caseJourHeight) + caseHeureHeight
                                        && p.y < (int)(b.getJourChoisi()*caseJourHeight)){
                                        pointActiviteX = 0;
                                        pointActiviteY = 0;
                                    }
                            }
                        }
                    }
                }
            }
        return new Point(pointActiviteX, pointActiviteY);
    }
        
    public void verificationSelection(Point p, List<Activite> activiteList){ 
        int width = dimension.width *3/4;
        int caseJourWidth = width / 16;
        int activiteHeight = dimension.height /45;
        
        for (Activite a: activiteList){
            if (p.x > a.getPoint().x && p.x < (a.getPoint().x + (int)(a.getDuree() * ((width - (caseJourWidth))/15)))
                    && p.y > a.getPoint().y && p.y < (a.getPoint().y + activiteHeight)){
                a.switchSelection();
            }
        }
    }
    
    public String mouseOverToolTipText(Point p, List<Activite> activiteList){
        int width = dimension.width *3/4;
        int caseJourWidth = width / 16;
        int activiteHeight = dimension.height /45;
        String toolTipText = "\t\t---Info activités---";
        
        for (int i = 0; i < activiteList.size(); i++){
            if (p.x > activiteList.get(i).getPoint().x && p.x < (activiteList.get(i).getPoint().x + (int)(activiteList.get(i).getDuree() * ((width - (caseJourWidth))/15)))
                    && p.y > activiteList.get(i).getPoint().y && p.y < (activiteList.get(i).getPoint().y + activiteHeight)){
                toolTipText =  "\t\t---Info activités---"
                               + "\nCode:\t" + activiteList.get(i).getCode()
                               + "\n" + "Section:\t" + activiteList.get(i).getSection()
                               + "\n" + "Description:\t" + activiteList.get(i).getNomActivite()
                               + "\n" + "Professeur:\t" + activiteList.get(i).getProfesseur()
                               + "\n" + "Type:\t" + activiteList.get(i).getType()
                               + "\n" + "Duree:\t" + activiteList.get(i).conversionHeure(activiteList.get(i).getDuree());
                
                if (activiteList.get(i).getJourChoisi() != 0){
                    toolTipText += "\n\n----------L'activité est placée!----------"
                                   + "\n" + "Jour choisi:\t" + activiteList.get(i).conversionJour(activiteList.get(i).getJourChoisi())
                                   + "\n" + "Débute à:\t" + activiteList.get(i).conversionHeure(activiteList.get(i).getHeureDebutChoisi());
                }
            }
        }
        return toolTipText;
    }            
    
    public void verificationPositionHoraire(Point p){
        if (p.x <= dimension.width*3/4){
            this.position = "horaire";
        }
        else{
            this.position = "liste";
        }
    }
    
    public Point deltaMaker(Point p, Activite a){
        Point delta = new Point(p.x - a.getPoint().x, p.y - a.getPoint().y);
        return delta;
    }
    
    public boolean activiteResteSurPlace(Point p, Activite a){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        
        if (p.x >= a.getPoint().x && p.x <= (a.getPoint().x + a.getDuree()*saut*2)
            && p.y >= a.getPoint().y && p.y <= a.getPoint().y + caseHeureHeight){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void jourHeureToActivite(Activite a){
        int width = dimension.width *3/4;
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        int jumpX;
        int jumpY;
        
        Point p = a.getPoint();
        
        //set du jourChoisi et heureChoisi selon point activité
        for (int i = 0; i <= 4; i++){
            int hauteur = caseHeureHeight+(i*caseJourHeight);
            if (a.getPoint().y >= hauteur 
                    && a.getPoint().y < caseJourHeight*(i+1)
                    && a.getPoint().x < dimension.width*3/4)
            {
                a.setJourChoisi(i+1);
            }
            for (int k = 0; k <= 29; k++){
                jumpX = caseJourWidth + k*saut;
                if (p.x >= jumpX && p.x < (jumpX + saut)){
                    a.setHeureDebutChoisi(8f + k*0.5f);
                }
            }
        }
        if (a.getPoint().x == 0 && a.getPoint().y ==0){
            a.setJourChoisi(0);
            a.setHeureDebutChoisi(0f);
        }
    }
    
    public String getPositionCursor(){
        return this.position;
    }
}
