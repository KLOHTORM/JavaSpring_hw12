package repository;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.properties.SqlCommands;
import java.util.List;

@Repository
@AllArgsConstructor

public class UserRepository {
    private final JdbcTemplate jdbc;
    private final SqlCommands sqlCommand;

    public List<User> findAll() {
        String sql = sqlCommand.getFindAll();
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = sqlCommand.getInsertUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = sqlCommand.getDeleteById();
        jdbc.update(sql, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public User findById(int id) {
        String sql = sqlCommand.getFindById();
        try {
            return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User update(User user) {
        String sql = sqlCommand.getUpdateUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
