package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.bo.Joueur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
