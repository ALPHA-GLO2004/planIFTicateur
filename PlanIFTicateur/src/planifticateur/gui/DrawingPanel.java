
package planifticateur.gui;
import planifticateur.drawing.HoraireDrawing;
import planifticateur.domain.HoraireController;
import java.awt.*;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class DrawingPanel extends JPanel implements Serializable
  {
    MainWindow mainWindow;
    Dimension initialDimension;
    
    public DrawingPanel(){
        //Constructeur
    }
    
    public DrawingPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    //    setBorder(new javax.swing.border.StrokeBorder());
        int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int height = (int)(width*0.932);
        setPreferredSize(new Dimension(width, 774));
        setVisible(true);
        initialDimension = new Dimension(width, height);
    }
    
    private void operation(){
        
    }
    
    @Override
    protected void paintComponent( Graphics g )
    {
        if (mainWindow != null){
            super.paintComponent(g);
            HoraireDrawing mainHoraire = new HoraireDrawing(mainWindow.horaireController, initialDimension);
            mainHoraire.draw(g);
        }
    }
    
    private MainWindow getMainWindow(){
        return mainWindow;
    }
    
    private void setMainWindow(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }
    
    private Dimension getInitialDimension(){
        return initialDimension;
    }
    
    private void setInitialDimension(Dimension initialDimension){
        this.initialDimension = initialDimension;
    }
  }