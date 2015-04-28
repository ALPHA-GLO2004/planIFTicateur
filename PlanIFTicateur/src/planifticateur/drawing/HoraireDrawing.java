
package planifticateur.drawing;
import planifticateur.domain.HoraireController;
import planifticateur.domain.GrilleCheminement;
import planifticateur.domain.Activite;
import planifticateur.domain.MouseAdapter;
import planifticateur.gui.DrawingPanel;
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.ImageIcon;

public class HoraireDrawing {
    private final HoraireController horaireController;
    Dimension initialDimension;
    
    public HoraireDrawing(HoraireController horaireController, Dimension initialDimension){
        this.horaireController = horaireController;
        this.initialDimension = initialDimension;
    }
    
    public void draw(Graphics g){
        //Dépend du mode validation auto
        if (horaireController.getHoraire() == true){
            drawHoraire(g);
            drawActivite(g);
        }
        else{
            drawHoraire(g);
        }
    }
    
    public void drawActivite(Graphics g){
        int width = initialDimension.width *3/4;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        int saut = (width - caseJourWidth)/ 30;
        
        Graphics2D g2 = (Graphics2D) g;
        if (horaireController.getHoraire() == true){
                for (Activite a: horaireController.getListeActiviteComplete()){
                    if (a.isSelected() == true){
                        g2.setColor(Color.YELLOW);
                    }
                    else{
                        g2.setColor(a.getCouleur());
                    }
                    g2.fillRect(a.getPoint().x, a.getPoint().y, (int)(a.getDuree() * ((width - (caseJourWidth))/15)), caseHeureHeight);
                    if (!horaireController.getRechercherNom().equals("")){
                        if (a.getNomActivite().contains(horaireController.getRechercherNom())){
                            g2.setColor(Color.GREEN);
                            g2.setStroke(new BasicStroke(5));
                        }
                        else{
                            g2.setColor(Color.BLACK);
                            g2.setStroke(new BasicStroke(1));
                        }
                    }
                    else{
                        g2.setColor(Color.BLACK);
                        g2.setStroke(new BasicStroke(1));
                    }
                        g2.drawRect(a.getPoint().x, a.getPoint().y, (int)(a.getDuree() * ((width - (caseJourWidth))/15)), caseHeureHeight);
                        Font font = new Font("Arial", Font.BOLD, 12);
                        if (a.getEtiquette().equals(a.getNomActivite())){
                            if (a.getEtiquette().length() > 18){
                                g2.drawString(a.getEtiquette().substring(0, 18) + "...", a.getPoint().x + 5, a.getPoint().y + 16);
                            }
                            else{
                                g2.drawString(a.getEtiquette(), a.getPoint().x + 5, a.getPoint().y + 16);
                            }
                        }
                        else{
                            g2.drawString(a.getEtiquette(), a.getPoint().x - 20 + (int)(a.getDuree() * ((width - (caseJourWidth))/15))/2, a.getPoint().y + 16);
                        }
                }
        }     
    }
    
    public void drawHoraire(Graphics g){
        int width = initialDimension.width *3/4;
        int height = initialDimension.height;
        int caseJourHeight = height / 5;
        int caseJourWidth = width / 16;
        int caseHeureHeight = caseJourHeight / 9;
        Font font = new Font("Arial", Font.BOLD, 12);
        
        Graphics2D g2 = (Graphics2D) g;
        
        if (horaireController.getHoraire() == true){
             if (horaireController.getModeValidationAuto()){
                //On set la couleur avec un alpha pour ombrager les zones invalides
                g2.setColor(new Color(80, 80, 80));
                //On remplit chaque case selon sa validité --- En construction :)
                g2.fillRect(0, 0, width, height);
             }
            //frame principal
            //lignes horizontales --- noires
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1));
            
            
            for (int i = 0; i < 5; i++){
                g2.drawLine(0, caseJourHeight*i, width, caseJourHeight*i);
                g2.drawLine(caseJourWidth, caseJourHeight*i+caseHeureHeight, width, caseJourHeight*i+caseHeureHeight);
            }
            g2.drawLine(0, height, width, height);

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

            //Dessin du cadre pour la liste des activités à placer
            int spaceHeightRight = caseHeureHeight /3;
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1));
            //horizontales
            g2.drawLine(width+saut, spaceHeightRight, width+3*saut, spaceHeightRight);
            g2.drawString("Activités à placer (" + horaireController.getListeActiviteAPlacer().size() + ")", width+14*saut/4, spaceHeightRight*2);
            g2.drawLine(width+8*saut, spaceHeightRight, initialDimension.width-3*saut/2, spaceHeightRight);
            //verticales
            g2.drawLine(width+saut, spaceHeightRight, width+saut, horaireController.setDessinHeight());
            g2.drawLine(initialDimension.width-3*saut/2, spaceHeightRight, initialDimension.width-3*saut/2, horaireController.setDessinHeight());
            
            //mode validationAuto on
            if (horaireController.getModeValidationAuto()){
                //On dessine les plages valides
                for (Activite a: horaireController.getListeActiviteComplete()){
                    if (horaireController.activiteIsSelected(a)){
                        float pointDebutMin = a.getHeureDebutMin() - 8; //Point minimum dans grille vs nb de case
                        float pointDebutMax = (a.getHeureFinMax() - 8) - pointDebutMin; //Point maximum dans grille vs nb de case
                        int heureSautDebut = (int)(pointDebutMin*(saut*2)); //Transformation d'une heure en point (saut)
                        int heureSautFin = (int)(pointDebutMax*(saut*2)); //Transformation d'une heure en point (saut)
                        g2.setColor(new Color(255, 255, 255));
                        
                        for (int i = 0; i <= 4; i++){
                            g2.fillRect(caseJourWidth+heureSautDebut , caseHeureHeight+(i*caseJourHeight), heureSautFin, caseJourHeight-caseHeureHeight);
                        }
                        
                        g2.setColor(new Color(80, 80, 80));
                        for (Activite b: horaireController.getListeActiviteDejaPlacee()){
                            if ((a.getType().toLowerCase().contains("labo") && b.getType().toLowerCase().contains("classe")) || (a.getType().toLowerCase().contains("classe") && b.getType().toLowerCase().contains("labo"))){
                                g2.fillRect((int)((b.getHeureDebutChoisi() - 8) * saut * 2 + caseJourWidth), (b.getJourChoisi()-1) * caseJourHeight + caseHeureHeight, (int)(b.getDuree()*saut*2), caseJourHeight - caseHeureHeight);
                            }
                            for (GrilleCheminement grille: horaireController.getListeActiviteGrilleCh()){
                                if (grille.activiteEstDansGrille(a.getCode())){
                                    
                                   if( grille.getSessionFirstLetter()!= horaireController.getSession().charAt(0))continue;//new yann
                                   
                                        if (grille.activiteEstDansGrille(b.getCode())){
                                            g2.fillRect((int)((b.getHeureDebutChoisi() - 8) * saut * 2 + caseJourWidth), (b.getJourChoisi()-1) * caseJourHeight + caseHeureHeight, (int)(b.getDuree()*saut*2), caseJourHeight - caseHeureHeight);
                                        }
                                }
                            }
                        }  
                    }
                }
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
                y = i*caseJourHeight + 2*caseHeureHeight;
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
        else{
            try{
                BufferedImage logo = ImageIO.read(getClass().getResource("/planifticateur/resources/" + "logo2.jpg"));
                g2.drawImage(logo, 0, 0, this.initialDimension.width, this.initialDimension.height, null);
            
            }catch (Throwable ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public String afficherJourHeure(Point point){
        String jour = "";
        int width = this.initialDimension.width *3/4;
        int caseJourWidth = width / 16;
        int saut = (width - caseJourWidth)/30;
        int height = this.initialDimension.height;
        int caseJourHeight = height / 5;
        int caseHeureHeight = caseJourHeight / 9;
        
        for (int i = 8; i <= 22; i++){
            if (point.y >= caseHeureHeight && point.y < caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jour = "lundi " + i + " h";
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jour = "lundi " + i + " h" + " 30";
                }
            }
            if (point.y >= caseJourHeight + caseHeureHeight && point.y < 2*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jour = "mardi " + i + " h";
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jour = "mardi " + i + " h" + " 30";
                }
            }
            if (point.y >= 2*caseJourHeight + caseHeureHeight && point.y < 3*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jour = "mercredi " + i + " h";
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jour = "mercredi " + i + " h" + " 30";
                }
            }
            if (point.y >= 3*caseJourHeight + caseHeureHeight && point.y < 4*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jour = "jeudi " + i + " h";
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jour = "jeudi " + i + " h" + " 30";
                }
            }
            if (point.y >= 4*caseJourHeight + caseHeureHeight && point.y < 5*caseJourHeight){
                if (point.x >= caseJourWidth && point.x < caseJourWidth + saut){
                    jour = "vendredi " + i + " h";
                }
                if (point.x >= caseJourWidth + saut && point.x < caseJourWidth + 2*saut){
                    jour = "vendredi " + i + " h" + " 30";
                }
            }            
            caseJourWidth += 2*saut;
        }
        if (jour != ""){
            return "\nPlage horaire: " + jour + "\n-------------------------------------------\n";
        }
        else{
            return "";
        }
    }
    
    public void setInitialDimension(Dimension initialDimension){
        this.initialDimension = initialDimension;
    }
}
