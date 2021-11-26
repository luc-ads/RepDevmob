package com.devmob.apijava.gateway.repository;

import com.devmob.apijava.entities.User;
import com.devmob.apijava.gateway.database.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    DataSource devmobDataSource = new DataSource();
    JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());

    public List<User> userQuery(String userEmail, String userPassword) {
        List<User> userQuery = configDB.query("SELECT * FROM tb_users WHERE user_email = ? AND user_password = ?;",
                new BeanPropertyRowMapper<>(User.class), userEmail, userPassword);
        return userQuery;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt("id_user"));
        user.setUserEmail(rs.getString("user_email"));
        user.setUserPassword(rs.getString("user_password"));
        return user;
    }

}
