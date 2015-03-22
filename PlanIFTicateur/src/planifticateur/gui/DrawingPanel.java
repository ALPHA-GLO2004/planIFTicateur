
package planifticateur.gui;
import planifticateur.drawing.HoraireDrawing;
import planifticateur.domain.HoraireController;
import java.awt.*;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class DrawingPanel extends JPanel
  {
    MainWindow mainWindow;
    Dimension initialDimension;
    
    public DrawingPanel(){
        //Constructeur
    }
    
    public DrawingPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        //...
    }
    
    private void operation(){
        
    }
    
    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent(g); 
        HoraireDrawing horaireDrawing = new HoraireDrawing(mainWindow.horaireController, initialDimension);
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