/* Classe Drawing Panel
 * 
 * 
*/
package planifticateur.gui;
import planifticateur.drawing.HoraireDrawing;
import planifticateur.domain.HoraireController;
import java.awt.*;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class DrawingActivitePanel extends JPanel implements Serializable
  {
    private MainWindow mainWindow;      //fenêtre principal du programme (parent 1er)
    private Dimension initialDimension; //Dimension du panel
    
    public DrawingActivitePanel(){
        //Constructeur
    }
    
    public DrawingActivitePanel(MainWindow mainWindow){
        //Constructeur avec frame principal en paramètre
        this.mainWindow = mainWindow;
    //    setBorder(new javax.swing.border.StrokeBorder());
        int width = (int) (mainWindow.getWidth());
        int height = (int)(mainWindow.getHeight());
        setPreferredSize(new Dimension(width - 300, height - 50));
        setVisible(true);
        initialDimension = new Dimension(width - 300, height - 50);
    }
    
    public void operation(){
        //aucune idée de quoi on parle ici
    }
    
    @Override
    protected void paintComponent( Graphics g )
    {
        //méthode pour l'affichage des éléments visuels
        if (mainWindow != null){
            super.paintComponent(g);
            
        }
    }
    
    public MainWindow getMainWindow(){
        return mainWindow;
    }
    
    public void setMainWindow(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }
    
    public Dimension getInitialDimension(){
        return initialDimension;
    }
    
    public void setInitialDimension(Dimension initialDimension){
        this.initialDimension = initialDimension;
    }
  }