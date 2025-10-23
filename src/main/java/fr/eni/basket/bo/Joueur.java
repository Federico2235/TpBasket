package fr.eni.basket.bo;

public class Joueur {
    private int noJoueur;
    private String prenom;
    private String nom;
    private String email;
    private int noEquipe;


    public int getNoJoueur() {
        return noJoueur;
    }

    public void setNoJoueur(int noJoueur) {
        this.noJoueur = noJoueur;
    }

    public String getPrenom() {
        return prenom;
    }

    public Joueur() {
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

    public int getNoEquipe() {
        return noEquipe;
    }

    public void setNoEquipe(int noEquipe) {
        this.noEquipe = noEquipe;
    }

    public Joueur(int noJoueur, String prenom, String nom, String email, int noEquipe) {
        this.noJoueur = noJoueur;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.noEquipe = noEquipe;
    }
}
