package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
import fr.eni.basket.dal.EquipeRepository;
import fr.eni.basket.dal.JoueurRepository;
import fr.eni.basket.dto.EquipeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    List<Joueur> joueurs = new ArrayList<>();
    public static int indexNbJouer = 1;
    EquipeRepository equipeRepository;
    JoueurRepository joueurRepository;
//
    List<Equipe> equipes = new ArrayList<>();
 public static int indexNbEquipe=1;
public BasketServiceImpl(EquipeRepository equipeRepository, JoueurRepository joueurRepository) {

//    Equipe equipe1 =new Equipe(indexNbEquipe++,"U15F1");
//    Equipe equipe2 =new Equipe(indexNbEquipe++,"U15F2");
//    Equipe equipe3 =new Equipe(indexNbEquipe++,"U15F3");
//    equipes.add(equipe1);
//    equipes.add(equipe2);
//    equipes.add(equipe3);
//
//
//    Joueur joueur1 =new Joueur(indexNbJouer++,"Federico","AN","fede@an.fr",equipe2);
//    Joueur joueur2 = new Joueur(indexNbJouer++,"Seb","Laloe","seb@lalo.fr",equipe3);
//    joueurs.add(joueur1);
//    joueurs.add(joueur2);
    this.equipeRepository = equipeRepository;
    this.joueurRepository = joueurRepository;
}



    @Override
    public List<Equipe> getAllEquipes() {
return equipeRepository.findAllEquipes();


    }

    @Override
    public List<Joueur> getJouers() {
        return joueurRepository.getJoueurs();
    }



//    @Override
//    public void addEquipe(Equipe equipe) {
//    equipes.add(equipe);
//System.out.println("no paso por donde quiero");
//    }

    @Override
    public Equipe addEquipe(EquipeDTO equipeDto) {
//        Equipe newEquipe =new Equipe();
//        BeanUtils.copyProperties(equipeDto,newEquipe);
//        newEquipe.setNbEquipe(indexNbEquipe++);
//        equipes.add(newEquipe);
//return newEquipe;
        Equipe equipe = new Equipe();
        BeanUtils.copyProperties(equipeDto,equipe);
        equipeRepository.save(equipe);

        return equipe;

    }


    @Override
    public void removeEquipeByNb(int nb) {
//equipes.removeIf(equipe -> equipe.getNbEquipe()==nb);
equipeRepository.delete(nb);
    }

    @Override
    public Optional<Equipe> getEquipe(String nomEquipe) {
//    Equipe equipe= equipes.stream().filter(equipes-> equipes.getNomEquipe().equals(nomEquipe)).findFirst().orElse(null);
        Optional<Equipe> equipe=equipeRepository.findEquipeByName(nomEquipe);

        return equipe;
    }


    public void setEquipe(List<Equipe> equipes) {
    this.equipes = new ArrayList<>(equipes);
    }

    public void setJouers(List<Joueur> joueurs) {
    this.joueurs = new ArrayList<>(joueurs);
    }

}
