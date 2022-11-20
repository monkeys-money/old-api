package br.com.monkeys_money.infradb.repository;

import br.com.monkeys_money.cross.DateConveter;
import br.com.monkeys_money.infradb.model.Investment;
import br.com.monkeys_money.infradb.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestmentRepository extends Repository<Investment>{
    @Override
    public Investment save(Investment investment) {
        try {
            StringBuffer sql = new StringBuffer("");
            sql.append("INSERT INTO investment (investment_id,");
            sql.append("user_id,");
            sql.append("investment,");
            sql.append("description,");
            sql.append("value,");
            sql.append("date_investment,");
            sql.append("date_creation,");

            sql.append("VALUES (investment_investment_id_SEQ.nextval,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?)");

            ptmt = connection.prepareStatement(sql.toString());
            ptmt.setLong(1,investment.getUser().getId());
            ptmt.setString(2, investment.getInvestment());
            ptmt.setString(3, investment.getDescription());
            ptmt.setDouble(4, investment.getValue());
            ptmt.setDate(5, new java.sql.Date(DateConveter.convertToDateUtil(investment.getDateInvestment()).getTime()));
            ptmt.setDate(4, new java.sql.Date(DateConveter.convertToDateUtil(investment.getDateCreation()).getTime()));

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

        return investment;
    }

    @Override
    public Investment update(Investment investment) {
        return null;
    }

    @Override
    public Investment findById(Long id) {
        return null;
    }

    public List<Investment> findMany(){
        //
        List<Investment> investments = new ArrayList<>();

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM investment");

            ptmt = connection.prepareStatement(sql.toString());

            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                var investment = new Investment();

                investment.setId(resultSet.getLong("investment_id"));
                investment.setInvestment(resultSet.getString("investment"));
                investment.setDescription(resultSet.getString("description"));
                investment.setDateInvestment(DateConveter.convertToLocalDateTime(resultSet.getDate("date_investment").getTime()));
                investment.setDateCreation(DateConveter.convertToLocalDateTime(resultSet.getDate("date_creation").getTime()));

                if(resultSet.getDate("date_update") != null){
                    investment.setDateUpdate(DateConveter.convertToLocalDateTime(resultSet.getDate("date_update").getTime()));
                }

                // creates a user
                var user = new User();
                user.setId(resultSet.getLong("user_id"));

                //add user to investment
                investment.setUser(user);

                // add investment in list of investments
                investments.add(investment);
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

        return investments;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
