package fr.eni.basket.dto;

import jakarta.validation.constraints.NotBlank;

public record JoueurDTO(@NotBlank String nom, String prenom, String email, int noEquipe) {
}
