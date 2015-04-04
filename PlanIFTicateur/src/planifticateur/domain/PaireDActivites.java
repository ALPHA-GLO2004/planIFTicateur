/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planifticateur.domain;

/**
 *
 * @author Proprietaire
 */
public class PaireDActivites {
    
    public Activite a1;
    public Activite a2;
    
    public PaireDActivites(){}
    
    public PaireDActivites(Activite act1 , Activite act2)
    {
        a1 = act1;
        a2 = act2;
    }
    
       public boolean equalsByCodes(Activite act1 , Activite act2)
    {
        if( (a1.getCode().equals(act1.getCode())) && (a2.getCode().equals(act2.getCode())) ) return true;
        if( (a1.getCode().equals(act2.getCode())) && (a2.getCode().equals(act1.getCode())) ) return true;
        
        return false;
    } 
    
      public boolean equalsByCodes(PaireDActivites paireAComparer)
    {
        if( (a1.getCode().equals(paireAComparer.a1.getCode())) && (a2.getCode().equals(paireAComparer.a2.getCode())) ) return true;
        if( (a1.getCode().equals(paireAComparer.a2.getCode())) && (a2.getCode().equals(paireAComparer.a1.getCode())) ) return true;
        
        return false;
    } 
              
}
