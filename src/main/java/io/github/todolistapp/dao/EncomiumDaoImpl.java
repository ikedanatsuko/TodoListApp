package io.github.todolistapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.todolistapp.entity.Encomium;
import io.github.todolistapp.entity.Todo;

@Repository
public class EncomiumDaoImpl implements EncomiumDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Encomium getEncomiumById(int id) {
		String sql = "SELECT * FROM encomium WHERE id= ?";
		Map map = jdbcTemplate.queryForMap(sql, id);
		Encomium encomium = new Encomium();
		
		encomium.setId((Integer)map.get("id"));
		encomium.setMessage((String)map.get("message"));
		
		return encomium;
	}

	public List<Encomium> getAllEncomium() {
		String sql = "SELECT * FROM encomium";
		List<Encomium> encomiums = jdbcTemplate.query(sql,
				new RowMapper<Encomium>() {
			public Encomium mapRow(ResultSet rs, int rowNum) throws SQLException {
				Encomium encomium = new Encomium();
				encomium.setId(rs.getInt("id"));
				encomium.setMessage(rs.getString("message"));
				return encomium;
			}
		});
		return encomiums;
	}
	
	public String getRandomMessage() {
		String sql = "SELECT message FROM encomium ORDER by random() LIMIT 1";
		String result = jdbcTemplate.queryForObject(sql, String.class);
		
		return result;
	}

	public void addEncomium(Encomium encomium) {
		String sql = "INSERT INTO encomium (message) VALUES(?)";
		jdbcTemplate.update(sql, encomium.getMessage());
		
		String sqlGetid = "SELECT setval('encomium_id_seq', (SELECT MAX(id) FROM encomium))";
		encomium.setId(jdbcTemplate.queryForObject(sqlGetid, Integer.class));
	}
}
