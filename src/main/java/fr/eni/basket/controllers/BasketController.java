package fr.eni.basket.controllers;

import fr.eni.basket.bll.BasketService;
import fr.eni.basket.bo.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class BasketController {


    BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/equipes")
public List<Equipe> showBasketTeams()
{
return basketService.getAllEquipes();

}

@PostMapping("equipes/add")
    public void addEquipe(@RequestBody Equipe equipe) {
        basketService.addEquipe(equipe);

}




}
