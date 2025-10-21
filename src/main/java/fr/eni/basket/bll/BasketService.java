package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;

import java.util.List;

public interface BasketService {

    //Find all equipes

    public List<Equipe> getAllEquipes();

    public void addEquipe(Equipe equipe);

    public void removeEquipeByNb(int nb);
}
