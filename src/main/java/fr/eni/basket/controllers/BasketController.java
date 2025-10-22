package fr.eni.basket.controllers;

import fr.eni.basket.bll.BasketService;
import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

@PostMapping("/equipes")
    public ResponseEntity<Equipe> addEquipe(@Valid @RequestBody EquipeDTO equipeDTO , BindingResult result ) {
    Equipe equipe = null;

    if (result.hasErrors()) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

        equipe= basketService.addEquipe(equipeDTO);
return ResponseEntity.status(HttpStatus.CREATED).body(equipe);
}



//
//@DeleteMapping("/equipes")
//public ResponseEntity<Void> deleteEquipe(@Valid @RequestParam('nbEquipe') int nbEquipe ) {
//    basketService.removeEquipeByNb(nbEquipe);
//    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nbEquipe);
//
//
//}
//

    @GetMapping("/equipes/{nomEquipe}")
    public Equipe getEquipeByName(@PathVariable("nomEquipe") String nomEquipe) {
        return basketService.getEquipe(nomEquipe);

    }


    @DeleteMapping("/equipes/{nbEquipe}")
    public ResponseEntity<Integer> deleteEquipe(@PathVariable int nbEquipe){
        basketService.removeEquipeByNb(nbEquipe);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nbEquipe);

    }
}
