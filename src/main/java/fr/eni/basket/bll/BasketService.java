package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;

import java.util.List;

public interface BasketService {

    //Find all equipes

    public List<Equipe> getAllEquipes();

//    public void addEquipe(Equipe equipe);
    public Equipe addEquipe(EquipeDTO equipeDTO);

    public void removeEquipeByNb(int nb);

    public Equipe getEquipe(String nomEquipe);
}
