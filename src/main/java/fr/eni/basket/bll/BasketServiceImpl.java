package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
import fr.eni.basket.dto.EquipeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    List<Joueur> joueurs = new ArrayList<>();
    public static int indexNbJouer = 1;


    List<Equipe> equipes = new ArrayList<>();
 public static int indexNbEquipe=1;
public BasketServiceImpl() {

    Equipe equipe1 =new Equipe(indexNbEquipe++,"U15F1");
    Equipe equipe2 =new Equipe(indexNbEquipe++,"U15F2");
    Equipe equipe3 =new Equipe(indexNbEquipe++,"U15F3");
    equipes.add(equipe1);
    equipes.add(equipe2);
    equipes.add(equipe3);


    Joueur joueur1 =new Joueur(indexNbJouer++,"Federico","AN","fede@an.fr",equipe2);
    Joueur joueur2 = new Joueur(indexNbJouer++,"Seb","Laloe","seb@lalo.fr",equipe3);
    joueurs.add(joueur1);
    joueurs.add(joueur2);

}



    @Override
    public List<Equipe> getAllEquipes() {
return equipes;


    }

    @Override
    public List<Joueur> getJouers() {
        return joueurs;
    }



//    @Override
//    public void addEquipe(Equipe equipe) {
//    equipes.add(equipe);
//System.out.println("no paso por donde quiero");
//    }

    @Override
    public Equipe addEquipe(EquipeDTO equipeDto) {
        Equipe newEquipe =new Equipe();
        BeanUtils.copyProperties(equipeDto,newEquipe);
        newEquipe.setNbEquipe(indexNbEquipe++);
        equipes.add(newEquipe);
return newEquipe;
    }


    @Override
    public void removeEquipeByNb(int nb) {
equipes.removeIf(equipe -> equipe.getNbEquipe()==nb);

    }

    @Override
    public Equipe getEquipe(String nomEquipe) {
    Equipe equipe= equipes.stream().filter(equipes-> equipes.getNomEquipe().equals(nomEquipe)).findFirst().orElse(null);
        return equipe;
    }


    public void setEquipe(List<Equipe> equipes) {
    this.equipes = new ArrayList<>(equipes);
    }

    public void setJouers(List<Joueur> joueurs) {
    this.joueurs = new ArrayList<>(joueurs);
    }

}
