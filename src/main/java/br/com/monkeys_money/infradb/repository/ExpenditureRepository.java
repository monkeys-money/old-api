package br.com.monkeys_money.infradb.repository;

import br.com.monkeys_money.cross.DateConveter;
import br.com.monkeys_money.infradb.model.Expenditure;
import br.com.monkeys_money.infradb.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureRepository extends Repository<Expenditure>{
    @Override
    public Expenditure save(Expenditure expenditure) {
        try {
            StringBuffer sql = new StringBuffer("");
            sql.append("INSERT INTO expenditure (expenditure_id,");
            sql.append("user_id,");
            sql.append("expenditure,");
            sql.append("description,");
            sql.append("value,");
            sql.append("date_expenditure,");
            sql.append("date_creation,");

            sql.append("VALUES (expenditure_expenditure_id_SEQ.nextval,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?)");

            ptmt = connection.prepareStatement(sql.toString());
            ptmt.setLong(1,expenditure.getUser().getId());
            ptmt.setString(2, expenditure.getExpenditure());
            ptmt.setString(3, expenditure.getDescription());
            ptmt.setDouble(4, expenditure.getValue());
            ptmt.setDate(5, new java.sql.Date(DateConveter.convertToDateUtil(expenditure.getDateExpenditure()).getTime()));
            ptmt.setDate(4, new java.sql.Date(DateConveter.convertToDateUtil(expenditure.getDateCreation()).getTime()));

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

        return expenditure;
    }

    @Override
    public Expenditure update(Expenditure expenditure) {
        return null;
    }

    @Override
    public Expenditure findById(Long id) {
        return null;
    }

    public List<Expenditure> findMany(){
        //
        List<Expenditure> expenditures = new ArrayList<>();

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM expenditure");

            ptmt = connection.prepareStatement(sql.toString());

            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                var expenditure = new Expenditure();

                expenditure.setId(resultSet.getLong("expenditure_id"));
                expenditure.setExpenditure(resultSet.getString("expenditure"));
                expenditure.setDescription(resultSet.getString("description"));
                expenditure.setDateExpenditure(DateConveter.convertToLocalDateTime(resultSet.getDate("date_expenditure").getTime()));
                expenditure.setDateCreation(DateConveter.convertToLocalDateTime(resultSet.getDate("date_creation").getTime()));

                if(resultSet.getDate("date_update") != null){
                    expenditure.setDateUpdate(DateConveter.convertToLocalDateTime(resultSet.getDate("date_update").getTime()));
                }

                // creates a user
                var user = new User();
                user.setId(resultSet.getLong("user_id"));

                //add user to expenditure
                expenditure.setUser(user);

                // add expenditure in list of expenditures
                expenditures.add(expenditure);
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

        return expenditures;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
