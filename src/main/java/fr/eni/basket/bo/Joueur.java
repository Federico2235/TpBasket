package fr.eni.basket.bo;

public class Joueur {
    private int noJoueur;
    private String prenom;
    private String nom;
    private String email;
    private Equipe equipe;


    public int getNoJoueur() {
        return noJoueur;
    }

    public void setNoJoueur(int noJoueur) {
        this.noJoueur = noJoueur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Joueur(int noJoueur, String prenom, String nom, String email, Equipe equipe) {
        this.noJoueur = noJoueur;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.equipe = equipe;
    }
}
