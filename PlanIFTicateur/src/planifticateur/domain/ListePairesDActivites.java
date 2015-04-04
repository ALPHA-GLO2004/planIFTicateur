/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planifticateur.domain;

import java.util.Vector;

/**
 *
 * @author Proprietaire
 */
public class ListePairesDActivites {
    
    private Vector<PaireDActivites> liste ;
    
    public ListePairesDActivites(){
    liste = new Vector<>() ;
    
    }
    
    public void addPaire(Activite act1 , Activite act2)
    {
       PaireDActivites paire= new PaireDActivites(act1,act2);
       
       for(PaireDActivites it : liste)
       {
           if( it.equalsByCodes(paire) ) return ;
           
       }
        
        liste.add(paire);
    }
    
    public Vector<PaireDActivites> getListe()
    {
        return  liste;
    }
    
    
}
