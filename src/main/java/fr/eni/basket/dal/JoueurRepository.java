package fr.eni.basket.dal;

import fr.eni.basket.bo.Joueur;
import fr.eni.basket.dto.JoueurDTO;

import java.util.List;

public interface JoueurRepository {

    List<Joueur> getJoueurs();

    Joueur addJoueur(JoueurDTO joueur);

    void deleteJoueur(int noJoueur);

    Joueur changeEquipeJoueur(int noJouer, int noEquipe);
}
