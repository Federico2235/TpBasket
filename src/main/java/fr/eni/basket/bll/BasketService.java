package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
import fr.eni.basket.dto.EquipeDTO;

import java.util.List;
import java.util.Optional;

public interface BasketService {

    //Find all equipes

    public List<Equipe> getAllEquipes();

//    public void addEquipe(Equipe equipe);
    public Equipe addEquipe(EquipeDTO equipeDTO);

    public void removeEquipeByNb(int nb);

    public Optional<Equipe> getEquipe(String nomEquipe);

    public List<Joueur> getJouers();

    public Joueur addJoueur(Joueur joueur);

    public void removeJoueur(int noJoueur);
}
