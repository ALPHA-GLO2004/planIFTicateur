
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
    
    private void draw(Graphics g){
        drawHoraire(g);
        drawActivite(g);
    }
    
    private void drawActivite(Graphics g){
        
    }
    
    private void drawHoraire(Graphics g){
        //Code test --- en attendant
        int width = (int) initialDimension.getWidth();
        int height = (int) initialDimension.getHeight();
        g.setColor(new Color(111,111,111));
        g.fillRect(width, (int)(height), width, height);
    }
}
