package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    List<Equipe> equipes = new ArrayList<>();

public BasketServiceImpl() {
    Equipe equipe1 =new Equipe("1","U15F1");
    Equipe equipe2 =new Equipe("2","U15F2");
    Equipe equipe3 =new Equipe("3","U15F3");
    equipes.add(equipe1);
    equipes.add(equipe2);
    equipes.add(equipe3);
}



    @Override
    public List<Equipe> getAllEquipes() {
return equipes;


    }

    @Override
    public void addEquipe(Equipe equipe) {
    equipes.add(equipe);

    }

    @Override
    public void removeEquipeByNb(int nb) {


    }

    public void setEquipe(List<Equipe> equipes) {
    this.equipes = new ArrayList<>(equipes);
    }
}
