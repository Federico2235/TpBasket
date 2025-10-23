package fr.eni.basket.dal;

import fr.eni.basket.bo.Joueur;

import java.util.List;

public interface JoueurRepository {

    List<Joueur> getJoueurs();
    Joueur addJoueur(Joueur joueur);
    void deleteJoueur(int noJoueur);

}
