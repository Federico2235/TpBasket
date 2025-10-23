package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
import fr.eni.basket.dto.JoueurDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JoueurRepositoryImpl implements JoueurRepository {

    private JdbcTemplate jdbcTemplate;

    public JoueurRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    class JoueurRowMapper implements RowMapper<Joueur> {

        @Override
        public Joueur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Joueur joueur = new Joueur();
            joueur.setNoJoueur(rs.getInt("noJoueur"));
            joueur.setPrenom(rs.getString("prenom"));
            joueur.setNom(rs.getString("nom"));
            joueur.setEmail(rs.getString("email"));
            Equipe equipe = new Equipe();
            equipe.setNbEquipe(rs.getInt("noEquipe"));
            equipe.setNomEquipe(rs.getString("nomEquipe"));

            joueur.setEquipe(equipe);
            return joueur;
        }
    }


    //faire une jointure
    @Override
    public List<Joueur> getJoueurs() {
        String sql = "SELECT j.noJoueur, j.prenom, j.nom, j.email, e.noEquipe AS noEquipe, e.nom AS nomEquipe " +
                "FROM Joueurs j " +
                "JOIN Equipes e ON j.noEquipe = e.noEquipe";


        List<Joueur> joueurs = jdbcTemplate.query(sql, new JoueurRowMapper());

        return joueurs;
    }

    @Override
    public Joueur addJoueur(JoueurDTO joueur) {
        String sql = "INSERT INTO Joueurs (prenom, nom, email, noEquipe) VALUES (?,?,?,?) ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"noEquipe"});
            ps.setString(1, joueur.prenom());
            ps.setString(2, joueur.nom());
            ps.setString(3, joueur.email());
            ps.setInt(4, joueur.noEquipe());
            return ps;
        }, keyHolder);
        int generatedId = keyHolder.getKey().intValue();
        Joueur newJoueur = new Joueur();
        BeanUtils.copyProperties(joueur, newJoueur);  // Copie automatiquement les propriétés du DTO vers l'objet Joueur (attributs ayant le même nom)²
        //        newJoueur.setNom(joueur.nom()
        newJoueur.setNoJoueur(generatedId);

        return newJoueur;
    }

    @Override
    public void deleteJoueur(int noJoueur) {
        String sql = "DELETE FROM Joueurs WHERE noJoueur = ?";
        jdbcTemplate.update(sql, noJoueur);


    }

    @Override
    public Joueur changeEquipeJoueur(int noJoueur, int noEquipe) {
        String sql = "UPDATE Joueurs SET noEquipe = ? WHERE noJoueur = ?";
        jdbcTemplate.update(sql, noEquipe, noJoueur);
        String sqlSelect = "SELECT j.noJoueur, j.prenom, j.nom, j.email, e.noEquipe AS noEquipe, e.nom AS nomEquipe " +
                "FROM Joueurs j " +
                "JOIN Equipes e ON j.noEquipe = e.noEquipe " +
                "WHERE j.noJoueur = ?";
        return jdbcTemplate.queryForObject(sqlSelect, new JoueurRowMapper(), noJoueur);

    }

}

