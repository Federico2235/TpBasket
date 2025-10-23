package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository {

    private JdbcTemplate jdbcTemplate;

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
        List<Equipe> equipes = jdbcTemplate.query(sql, new EquipeRowMapper());
        return equipes;
    }

    @Override
    public Optional<Equipe> findEquipeByName(String nomEquipe) {
        String sql = "SELECT noEquipe, nom FROM Equipes WHERE nom = ?";
        Equipe equipe = jdbcTemplate.queryForObject(sql, new EquipeRowMapper(), nomEquipe);
        return Optional.ofNullable(equipe);


    }

    @Override
    public Equipe save(Equipe equipe) {
        String sql = "INSERT INTO Equipes (nom) VALUES (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"noEquipe"});
            ps.setString(1, equipe.getNomEquipe());
            return ps;
        }, keyHolder);

        // Obtener el id generado
        int generatedId = keyHolder.getKey().intValue();
        equipe.setNbEquipe(generatedId);

        return equipe;
    }

    @Override
    public void delete(int noEquipe) {
        String sql = "DELETE FROM Equipes WHERE noEquipe = ?";
        jdbcTemplate.update(sql, noEquipe);
    }
}
