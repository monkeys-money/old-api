package br.com.monkeys_money.infradb.repository;

import br.com.monkeys_money.cross.DateConveter;
import br.com.monkeys_money.infradb.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.sql.SQLException;

@ApplicationScoped
public class UserRespository extends Repository<User> {

    @Override
    public User save(User user) {
        try {
            StringBuffer sql = new StringBuffer("");
            sql.append("INSERT INTO USER(user_id, username, email, password, date_creation)");
            sql.append("VALUES(");
            sql.append("user_user_id_SEQ.nextval,");
            sql.append("?,?,?,?");
            sql.append(")");

            ptmt = connection.prepareStatement(sql.toString());
            ptmt.setString(1, user.getEmail());
            ptmt.setString(2, user.getPassword());
            ptmt.setString(3, user.getUsername());

            ptmt.setDate(4, new java.sql.Date(DateConveter.convertToDateUtil(user.getDateCreation()).getTime()));

            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //close prepareStatement
                if (ptmt != null) ptmt.close();

                //close connection
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return findByEmail(user.getEmail());
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    public User findByEmail(final String email) {

        var user = new User();

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM user u WHERE u.email = ?");

            ptmt = connection.prepareStatement(sql.toString());
            ptmt.setString(1, email);

            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getLong("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setDateCreation(DateConveter.convertToLocalDateTime(resultSet.getDate("date_creation").getTime()));

                if(resultSet.getDate("date_update") != null){
                    user.setDateUpdate(DateConveter.convertToLocalDateTime(resultSet.getDate("date_update").getTime()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //close resultSet
                if(resultSet != null) resultSet.close();

                //close prepareStatement
                if (ptmt != null) ptmt.close();

                //close connection
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
