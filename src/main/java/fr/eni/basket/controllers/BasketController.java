package fr.eni.basket.controllers;

import fr.eni.basket.bll.BasketService;
import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

@PostMapping("equipes")
    public ResponseEntity<Equipe> addEquipe(@Valid @RequestBody EquipeDTO equipeDTO , BindingResult result ) {
    Equipe equipe = null;

    if (result.hasErrors()) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

        equipe= basketService.addEquipe(equipeDTO);
return ResponseEntity.status(HttpStatus.CREATED).body(equipe);
}




}
