
package planifticateur.domain;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.CellRendererPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.image.*;


/**
see http://stackoverflow.com/questions/14551646/convert-a-jpanel-to-an-image-in-a-jscrollpane
*   http://stackoverflow.com/questions/4386446/problem-using-imageio-write-jpg-file
*/

public class ExporterToImage {
    
    //seulement jpeg actuellement
    public enum IMAGE_FORMAT {
        JPEG;
    }
    
    private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
    private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);

        
    public static BufferedImage componentToImage(Component component, boolean visible) {

        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        component.paintAll(g2d);
        return img;
       }
    
    
    private void saveJPeg(BufferedImage image, String path) {
        PixelGrabber pg = new PixelGrabber(image, 0, 0, -1, -1, true);
        try {
            pg.grabPixels();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        int width = pg.getWidth(), height = pg.getHeight();

        DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
        WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
        BufferedImage bi = new BufferedImage(RGB_OPAQUE, raster, false, null);

        try {
            ImageIO.write(bi, "jpg", new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void  exporterImage(Component component,IMAGE_FORMAT format, String path, boolean visible) {

            BufferedImage image = componentToImage(component, visible);
            saveJPeg(image, path);
       }
    
    
}
