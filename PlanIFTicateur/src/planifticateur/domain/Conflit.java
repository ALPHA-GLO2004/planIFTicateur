/*
*   nom:    Classe Conflit
*   but:    Crée un objet Conflit contenant les attributs relatifs à un conflit
*   pre:    Doit avoir obligatoirement: 2 activités en conflit et une description (pas sûr le nom y sert à quoi).
*   post:   Création d'un conflit avec attributs nécessaires à l'identification d'un conflit
************************************************************************************************/
package planifticateur.domain;


public class Conflit {
    Activite[] activiteEnConflit;
    String nom;
    String description;
    
    public Conflit(Activite act1, Activite act2){
        //Constructeur --- à développer
        activiteEnConflit = new Activite[2];//tableau de 2 activites 
        activiteEnConflit[0]=act1;
        activiteEnConflit[1]=act2;
        nom = act1.getCode()+"-"+act2.getCode();
        description = "Conflit d'horaire entre les deux activites : "+ act1.getCode() + " et " + act2.getCode() + "\n";
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getDescription(){
        return description;
    }
    public Activite[] getActiviteEnConflit(){
        return activiteEnConflit;
    }
    private boolean afficherConflit(){
        //Est-ce vraiment utile de retourner un bool pour un affichage ?
        //Peut aisément être dans le controller.
        return true;
    }
}
