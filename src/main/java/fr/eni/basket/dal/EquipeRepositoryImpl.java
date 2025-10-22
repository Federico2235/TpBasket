package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository {

   private JdbcTemplate jdbcTemplate ;

    public EquipeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class EquipeRowMapper implements RowMapper<Equipe> {

        @Override
        public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipe equipe = new Equipe();
            equipe.setNbEquipe(rs.getInt("noEquipe"));
            equipe.setNomEquipe(rs.getString("nom"));
            return equipe;
        }
    }


    @Override
    public List<Equipe> findAllEquipes() {
        String sql = "SELECT noEquipe, nom FROM Equipes";
        List<Equipe> equipes= jdbcTemplate.query(sql,new EquipeRowMapper());
        return equipes;
    }

    @Override
    public Optional<Equipe> findEquipeByName(String nomEquipe) {
        String sql = "SELECT noEquipe, nom FROM Equipes WHERE nom = ?";
        Equipe equipe= jdbcTemplate.queryForObject(sql, new EquipeRowMapper(),nomEquipe);
        return Optional.ofNullable(equipe);


    }
}
