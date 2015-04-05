
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
    
    public MouseAdapter(Dimension d){
        this.dimension = d;
    }
    
    //Méthode pour snaper les activités à la grille horaire
    public Point verificationDrop(Point p, List<Activite> laC, List<Activite> laDP, List<GrilleCheminement> laGC, boolean modeValidationAuto){
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
                    jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight;
                    if (p.y >= jumpY && p.y < jumpY + caseHeureHeight){
                        pointActiviteY = jumpY;
                    }
                }
            }
            
            if ((p.x >= 0 && p.x < caseJourWidth)){
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
                }
            }
            
            for (Activite a: laDP){
                if (pointActiviteX + (int)(dureeActiviteSelected *2*saut) > a.getPoint().x 
                    && pointActiviteX + (int)(dureeActiviteSelected *2*saut) <= (a.getPoint().x + (int)(a.getDuree()*2*saut))
                    && p.y > a.getPoint().y
                    && p.y < (a.getPoint().y + activiteHeight)){
                    pointActiviteX = 0;
                    pointActiviteY = 0;
                }
                if (pointActiviteX > a.getPoint().x && pointActiviteX < (a.getPoint().x + (int)(a.getDuree() *2*saut))
                    && p.y > a.getPoint().y && p.y < (a.getPoint().y + activiteHeight)){
                    pointActiviteX = 0;
                    pointActiviteY = 0;
                }
            }
            if (p.x >= width){
                pointActiviteX = 0;
                pointActiviteY = 0;
            }

            for (Activite b: laDP){
                for (GrilleCheminement grille: laGC){
                    if (grille.activiteEstDansGrille(codeSelected)){
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
            
            if (modeValidationAuto){
                if ((pointActiviteX + (int)(dureeActiviteSelected * ((width - (caseJourWidth))/15))) > (int)(caseJourWidth + (heureFinMax - 8)*2*saut)
                    || pointActiviteX < (int)(caseJourWidth + (heureDebutMin - 8)*2*saut)){
                    pointActiviteX = 0;
                    pointActiviteY = 0;
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
    
    public void verificationPositionHoraire(Point p){
        if (p.x <= dimension.width*3/4){
            this.position = "horaire";
        }
        else{
            this.position = "liste";
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
