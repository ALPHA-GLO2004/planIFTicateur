
package planifticateur.drawing;
import planifticateur.domain.HoraireController;
import planifticateur.domain.Activite;
import java.awt.*;
import java.util.Vector;
import sun.swing.SwingUtilities2;

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
        //triangle test
        Font font = new Font("Arial", Font.BOLD, 12);
        g.setColor(Color.ORANGE);
        g.fillRect(5, 5, 70, hauteur);
        g.setColor(Color.BLACK);
        g.drawString("cours test", 13, hauteur);
        
    /*    Vector<Activite> activites = horaireController.getListeActiviteAPlacer();
        for (Activite activite: activites){
            Point activitePoint = activite.getPoint();
            Color couleur = activite.getCouleur();
            g.setColor(couleur);
            g.fillRect((int)activitePoint.getX(), (int)activitePoint.getY(), (int)activite.getDuree() * 35, hauteur);
        }*/
    }
    
    public void drawHoraire(Graphics g){
        //Code test --- en attendant
        int width = 1086;
        int height = 927;
        int s = 2;
        int x = 72;
        int y1 = 2; //utile pour barres verticales pour séparation heures et jour
        
        Font font = new Font("Arial", Font.BOLD, 12);
        
        Graphics2D g2 = (Graphics2D) g;
        //frame principal
        //lignes horizontales --- noires
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        
        for (int i = 1; i <= 5; i++){
            g2.drawLine(2, s, width, s);
            g2.drawLine(72, s+25, width, s+25);
            s += 185;
        }
        g2.drawLine(2, s, width, s);
        
        //lignes verticales --- noires
        g2.drawLine(2, 2, 2, 927);
        g2.drawLine(72, 2, 72, 927);
        g2.drawLine(1086, 2, 1086, 927);
        
        //loop pour les petites lignes de l'entête de chaque journée
        
        while (x <= width){
            g2.drawLine(x, y1, x, y1+25);
            g2.drawLine(x, y1+185, x, y1+210);
            g2.drawLine(x, y1+370, x, y1+395);
            g2.drawLine(x, y1+555, x, y1+580);
            g2.drawLine(x, y1+740, x, y1+765);
            x += 35;
        }
        y1 = 100; //On reset le y1 pour les journées
        g2.setFont(font); //police de caractère
        //loop pour afficher les string de jour
        g2.drawString("Lundi", 20, y1);
        g2.drawString("Mardi", 20, y1+185);
        g2.drawString("Mercredi", 13, y1+370);
        g2.drawString("Jeudi", 20, y1+555);
        g2.drawString("Vendredi", 13, y1+740);
        
        x = 79; //On prépare le x pour les heures
        y1 = 18; //On reset le y1 pour les heures
        //loop pour indiquer les heures dans l'entête de chaque journée
        for (int i = 8; i <= 22; i++){
            g2.drawString(i + "h", x, y1);
            g2.drawString(i + "h", x, y1+185);
            g2.drawString(i + "h", x, y1+370);
            g2.drawString(i + "h", x, y1+555);
            g2.drawString(i + "h", x, y1+740);
            x += 70;
        }
        
        //lignes horizontales pointillées --- grises
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);
        g2.setStroke(dashed);
        g2.setColor(Color.GRAY);
        s = 47;
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 7; j++){
                g2.drawLine(72, s, width, s);
                s += 20;
            }
            s += 45;
        }
        
        x = 107; //reset x pour lignes vert.
        y1 = 27; //reset y1 pour lignes vert.
        //loop pour les lignes pointillées verticales
        while (x < width){
            g2.drawLine(x, y1, x, y1+160);
            y1 += 185;
            g2.drawLine(x, y1, x, y1+160);
            y1 += 185;
            g2.drawLine(x, y1, x, y1+160);
            y1 += 185;
            g2.drawLine(x, y1, x, y1+160);
            y1 += 185;
            g2.drawLine(x, y1, x, y1+160);
            y1 = 27;
            x += 35;
        }
    }
}
