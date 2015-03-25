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
    }
    
    private boolean afficherConflit(){
        //Est-ce vraiment utile de retourner un bool pour un affichage ?
        //Peut aisément être dans le controller.
        return true;
    }
}
