
package planifticateur.drawing;
import planifticateur.domain.HoraireController;
import planifticateur.domain.Activite;
import java.awt.*;
import java.util.Vector;
import java.util.List;

public class HoraireDrawing {
    private final HoraireController horaireController;
    Dimension initialDimension;
    int hauteur = 20;
    
    public HoraireDrawing(HoraireController horaireController, Dimension initialDimension){
        this.horaireController = horaireController;
        this.initialDimension = initialDimension;
    }
    
    public void draw(Graphics g){
        drawHoraire(g);
        drawActivite(g);
    }
    
    //pas sûr de ça --- juste un test
    public void drawActivite(Graphics g){
        /*//rectangle test
        Font font = new Font("Arial", Font.BOLD, 12);
        g.setColor(Color.ORANGE);
        g.fillRect(5, 5, 70, hauteur);
        g.setColor(Color.BLACK);
        g.drawString("cours test", 13, hauteur);*/
        
        if (horaireController.getHoraire() == true){
            List<Activite> activites = horaireController.getListeActiviteComplete();
            for (Activite a: activites){
                if (a.isSelected()){
                g.setColor(a.getCouleur());
                g.fillRect(a.getPoint().x, a.getPoint().y, (int)a.getDuree() * 35, hauteur);
                }
            }
        }
    }
    
    public void drawHoraire(Graphics g){
        //Code test --- en attendant
        int width = initialDimension.width *3/4;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        Font font = new Font("Arial", Font.BOLD, 12);
        
        Graphics2D g2 = (Graphics2D) g;
        //frame principal
        //lignes horizontales --- noires
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        
        g2.drawLine(caseJourWidth, caseHeureHeight, width, caseHeureHeight);
        for (int i = 1; i <= 5; i++){
            g2.drawLine(0, caseJourHeight*i, width, caseJourHeight*i);
            g2.drawLine(caseJourWidth, caseJourHeight*i+caseHeureHeight, width, caseJourHeight*i+caseHeureHeight);
        }
        
        //ligne verticale --- noire
        g2.drawLine(caseJourWidth, 0, caseJourWidth, height);
        
        //loop pour les petites lignes de l'entête de chaque journée
        int x = caseJourWidth;
        int saut = (width - caseJourWidth)/ 30;
        
        while (x <= width){
            g2.drawLine(x, 0, x, caseHeureHeight);
            g2.drawLine(x, caseJourHeight, x, caseJourHeight+caseHeureHeight);
            g2.drawLine(x, caseJourHeight*2, x, 2*caseJourHeight+caseHeureHeight);
            g2.drawLine(x, caseJourHeight*3, x, 3*caseJourHeight+caseHeureHeight);
            g2.drawLine(x, caseJourHeight*4, x, 4*caseJourHeight+caseHeureHeight);
            x += saut;
        }
        
        g2.setFont(font); //police de caractère
        //loop pour afficher les string de jour
        g2.drawString("Lundi", caseJourWidth /4, caseJourHeight /2);
        g2.drawString("Mardi", caseJourWidth /4, (2*caseJourHeight)-caseJourHeight /2);
        g2.drawString("Mercredi", caseJourWidth /4, 3*caseJourHeight -caseJourHeight /2);
        g2.drawString("Jeudi", caseJourWidth /4, 4*caseJourHeight -caseJourHeight /2);
        g2.drawString("Vendredi", caseJourWidth /4, 5*caseJourHeight -caseJourHeight /2);
        
        x = caseJourWidth;
        //loop pour indiquer les heures dans l'entête de chaque journée
        for (int i = 8; i <= 22; i++){
            g2.drawString(i + "h", x + (saut / 3), caseHeureHeight*2/3);
            g2.drawString(i + "h", x + (saut / 3), caseJourHeight + caseHeureHeight*2/3);
            g2.drawString(i + "h", x + (saut / 3), 2*caseJourHeight + caseHeureHeight*2/3);
            g2.drawString(i + "h", x + (saut / 3), 3*caseJourHeight + caseHeureHeight*2/3);
            g2.drawString(i + "h", x + (saut / 3), 4*caseJourHeight + caseHeureHeight*2/3);
            x += saut * 2;
        }
        
        //lignes horizontales pointillées --- grises
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);
        g2.setStroke(dashed);
        g2.setColor(Color.GRAY);
        int y = 2*caseHeureHeight;
        
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 7; j++){
                g2.drawLine(caseJourWidth, y, width, y);
                y += caseHeureHeight;
            }
            y += 2*caseHeureHeight;
        }
        
        x = caseJourWidth + saut;
        y = caseJourHeight;
        //loop pour les lignes pointillées verticales
        while (x < width){
            g2.drawLine(x, caseHeureHeight, x, y);
            y += caseJourHeight;
            g2.drawLine(x, y - caseJourHeight + caseHeureHeight, x, y);
            y += caseJourHeight;
            g2.drawLine(x, y - caseJourHeight + caseHeureHeight, x, y);
            y += caseJourHeight;
            g2.drawLine(x, y - caseJourHeight + caseHeureHeight, x, y);
            y += caseJourHeight;
            g2.drawLine(x, y - caseJourHeight + caseHeureHeight, x, y);
            y = caseJourHeight;
            x += saut;
        }
    }
}
