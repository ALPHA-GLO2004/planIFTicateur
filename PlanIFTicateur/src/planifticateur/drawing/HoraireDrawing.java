
package planifticateur.drawing;
import planifticateur.domain.HoraireController;
import java.awt.*;

public class HoraireDrawing {
    private final HoraireController horaireController;
    Dimension initialDimension;
    int radius;
    
    public HoraireDrawing(HoraireController horaireController, Dimension initialDimension){
        this.horaireController = horaireController;
        this.initialDimension = initialDimension;
    }
    
    public void draw(Graphics g){
        drawHoraire(g);
    //    drawActivite(g);
    }
    
    private void drawActivite(Graphics g){
        
    }
    
    private void drawHoraire(Graphics g){
        //Code test --- en attendant
        int width = 1086;
        int x = 72;
        Font font = new Font("Arial", Font.BOLD, 12);
        
        Graphics2D g2 = (Graphics2D) g;
        //lignes horizontales
        g2.drawLine(2, 2, width, 2);
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(2, 25, width, 25);
        g2.drawLine(2, 156, width, 156);
        g2.drawLine(2, 179, width, 179);
        g2.drawLine(2, 310, width, 310);
        g2.drawLine(2, 333, width, 333);
        g2.drawLine(2, 464, width, 464);
        g2.drawLine(2, 487, width, 487);
        g2.drawLine(2, 618, width, 618);
        g2.drawLine(2, 641, width, 641);
        g2.drawLine(2, 772, width, 772);
        //lignes verticales
        g2.drawLine(2, 2, 2, 772);
        g2.drawLine(72, 2, 72, 772);
        g2.drawLine(1086, 2, 1086, 772);
        //loop pour les petites lignes de l'entête de chaque journée
        while (x <= 1086){
            g2.drawLine(x, 2, x, 25);
            g2.drawLine(x, 156, x, 179);
            g2.drawLine(x, 310, x, 333);
            g2.drawLine(x, 464, x, 487);
            g2.drawLine(x, 618, x, 641);
            x += 35;
        }
        x = 79; //On prépare le x pour les heures
        g2.setFont(font); //police de caractère
        g2.drawString("Lundi", 20, 85);
        g2.drawString("Mardi", 20, 239);
        g2.drawString("Mercredi", 13, 393);
        g2.drawString("Jeudi", 20, 547);
        g2.drawString("Vendredi", 13, 701);
        //loop pour indiquer les heures dans l'entête de chaque journée
        for (int i = 8; i <= 22; i++){
            g2.drawString(i + "h", x, 18);
            x += 70;
        }
    }
}
