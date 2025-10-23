package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
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
            Joueur joueur= new Joueur();
            joueur.setNoJoueur(rs.getInt("noJoueur"));
            joueur.setPrenom(rs.getString("prenom"));
            joueur.setNom(rs.getString("nom"));
            joueur.setEmail(rs.getString("email"));
            joueur.setNoEquipe(rs.getInt("noEquipe"));
            return joueur;
        }
    }

    @Override
    public List<Joueur> getJoueurs() {
        String sql = "SELECT * FROM Joueurs";
List<Joueur> joueurs = jdbcTemplate.query(sql, new JoueurRowMapper());

        return joueurs;
    }

    @Override
    public Joueur addJoueur(Joueur joueur) {
        String sql="INSERT INTO Joueurs (prenom, nom, email, noEquipe) VALUES (?,?,?,?) ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"noEquipe"});
            ps.setString(1, joueur.getPrenom());
            ps.setString(2, joueur.getNom());
            ps.setString(3, joueur.getEmail());
            ps.setInt(4, joueur.getNoEquipe());
            return ps;
        },keyHolder);
        int generatedId = keyHolder.getKey().intValue();
        joueur.setNoJoueur(generatedId);

        return joueur;
        }

    }

