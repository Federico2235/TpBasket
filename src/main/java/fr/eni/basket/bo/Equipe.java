package fr.eni.basket.bo;

import java.util.List;
import java.util.Objects;

public class Equipe {

    private String nbEquipe;
    private String nomEquipe;
    private List<Jouer> jouers;

    public Equipe(String nbEquipe, String nomEquipe) {
        this.nbEquipe = nbEquipe;
        this.nomEquipe = nomEquipe;
    }

    public String getNbEquipe() {
        return nbEquipe;
    }

    public void setNbEquipe(String nbEquipe) {
        this.nbEquipe = nbEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public List<Jouer> getJouers() {
        return jouers;
    }

    public void setJouers(List<Jouer> jouers) {
        this.jouers = jouers;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Equipe equipe)) return false;
        return Objects.equals(nbEquipe, equipe.nbEquipe);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nomEquipe);
    }

    @Override
    public String toString() {

        return "Equipe{"+"noEquipe=" + nbEquipe + ","+"nomEquipe=" + nomEquipe +"}";
    }
}
