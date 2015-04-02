
package planifticateur.domain;
import java.awt.*;
import java.util.List;

public class MouseAdapter {
    private Dimension dimension;
    
    public MouseAdapter(Dimension d){
        this.dimension = d;
    }
    
    //Méthode pour snaper les activités à la grille horaire
    public Point verificationDrop(Point p){
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
                        pointActiviteX = jumpX;
                    }
                    //else{
                    //    pointActiviteX = 0;
                    //}
                }
                jumpY = i*caseJourHeight + caseHeureHeight + j*caseHeureHeight;
                if (p.y >= jumpY && p.y < jumpY + caseHeureHeight){
                    pointActiviteY = jumpY;
                }
                //else{
                //    pointActiviteY = 0;
                //}
            }
        }
        if ((p.x >= 0 && p.x < caseJourWidth)){
            pointActiviteX = 0;
            pointActiviteY = 0;
        }
        if (p.x > width*3/4){
            
        }
        return new Point(pointActiviteX, pointActiviteY);
    }
    
    public void verificationSelection(Point p, List<Activite> activiteList){      
        int activiteWidth = (dimension.width - dimension.width /16) /15;
        int activiteHeight = dimension.height /45;
        
        for (Activite a: activiteList){
            if (p.x > a.getPoint().x && p.x < (a.getPoint().x + (a.getDuree()*activiteWidth))
                    && p.y > a.getPoint().y && p.y < (a.getPoint().y + activiteHeight)){
                a.switchSelection();
            }
        }
    }
    
    public void jourHeureToActivite(Activite a){
        int height = dimension.height;
        int caseJourHeight = height / 5;
        int caseHeureHeight = caseJourHeight / 9;
        
        for (int i = 0; i <= 4; i++){
            int hauteur = caseHeureHeight+(i*caseJourHeight);
            if (a.getPoint().y >= hauteur 
                    && a.getPoint().y < caseJourHeight*(i+1)
                    && a.getPoint().x < dimension.width*3/4)
            {
                a.setJourChoisi(i+1);
            }
        }
    }
}
