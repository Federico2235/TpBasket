package fr.eni.basket.bo;

import java.util.List;
import java.util.Objects;

public class Equipe {

    private int nbEquipe;
    private String nomEquipe;


    public int getNbEquipe() {
        return nbEquipe;
    }

    public void setNbEquipe(int nbEquipe) {
        this.nbEquipe = nbEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }


    public Equipe() {}

    public Equipe(int nbEquipe, String nomEquipe) {
        this.nbEquipe = nbEquipe;
        this.nomEquipe = nomEquipe;
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
