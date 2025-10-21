package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class EquipeServiceTest {
    @Autowired
    private BasketServiceImpl equipeService;

    @Test
    public void getEquipes()
    {
        //AAA
        // Arrange


        List<Equipe> equipes = new ArrayList<>();
        Equipe equipe1 =new Equipe("1","U15F1");
        Equipe equipe2 =new Equipe("2","U15F2");
        Equipe equipe3 =new Equipe("3","U15F3");
        equipes.add(equipe1);
        equipes.add(equipe2);
        equipes.add(equipe3);
        equipeService.setEquipe(equipes);

        //Act
        List<Equipe> resultat = equipeService.getAllEquipes();

        //Asserts
        assertEquals(resultat .size(),3);

    }

    }

