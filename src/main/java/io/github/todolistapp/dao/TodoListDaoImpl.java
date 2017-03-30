package io.github.todolistapp.dao;

import java.sql.Date;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import io.github.todolistapp.entity.Todo;
import io.github.todolistapp.entity.TodoList;

@Repository
public class TodoListDaoImpl implements TodoListDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Get todolist by id
	public TodoList getTodolistById(int id) {
		String sql = "SELECT * FROM todolist WHERE id= ?";
		Map map = jdbcTemplate.queryForMap(sql, id);
		TodoList todolist = new TodoList();

		todolist.setId((Integer) map.get("id"));
		todolist.setTitle((String) map.get("title"));

		return todolist;
	}

	// Get all todolist
	public List<TodoList> getAllTodolist() {
		String sql = "SELECT * FROM todolist";
		List<TodoList> todolists = jdbcTemplate.query(sql, new RowMapper<TodoList>() {
			public TodoList mapRow(ResultSet rs, int rowNum) throws SQLException {
				TodoList todolist = new TodoList();
				todolist.setId(rs.getInt("id"));
				todolist.setTitle(rs.getString("title"));
				return todolist;
			}
		});
		return todolists;
	}

	public void addTodolist(TodoList todolist) {
		String sql = "INSERT INTO todolist (title) VALUES(?)";
		jdbcTemplate.update(sql, todolist.getTitle());

		String sql_getid = "SELECT setval('todolist_id_seq', (SELECT MAX(id) FROM todolist))";
		todolist.setId(jdbcTemplate.queryForObject(sql_getid, Integer.class));
	}
}
