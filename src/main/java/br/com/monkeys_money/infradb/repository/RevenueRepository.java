package br.com.monkeys_money.infradb.repository;

import br.com.monkeys_money.cross.DateConveter;
import br.com.monkeys_money.infradb.model.Revenue;
import br.com.monkeys_money.infradb.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RevenueRepository extends Repository<Revenue>{
    @Override
    public Revenue save(Revenue revenue) {
        try {
            StringBuffer sql = new StringBuffer("");
            sql.append("INSERT INTO REVENUE (revenue_id,");
            sql.append("user_id,");
            sql.append("revenue,");
            sql.append("description,");
            sql.append("value,");
            sql.append("date_revenue,");
            sql.append("date_creation,");

            sql.append("VALUES (revenue_revenue_id_SEQ.nextval,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?,");
            sql.append("?)");

            ptmt = connection.prepareStatement(sql.toString());
            ptmt.setLong(1,revenue.getUser().getId());
            ptmt.setString(2, revenue.getRevenue());
            ptmt.setString(3, revenue.getDescription());
            ptmt.setDouble(4, revenue.getValue());
            ptmt.setDate(5, new java.sql.Date(DateConveter.convertToDateUtil(revenue.getDateRevenue()).getTime()));
            ptmt.setDate(4, new java.sql.Date(DateConveter.convertToDateUtil(revenue.getDateCreation()).getTime()));

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

        return revenue;
    }

    @Override
    public Revenue update(Revenue revenue) {
        return null;
    }

    @Override
    public Revenue findById(Long id) {
        return null;
    }

    public List<Revenue> findMany(){
        //
        List<Revenue> revenues = new ArrayList<>();

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM revenue");

            ptmt = connection.prepareStatement(sql.toString());

            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                var revenue = new Revenue();

                revenue.setId(resultSet.getLong("revenue_id"));
                revenue.setRevenue(resultSet.getString("revenue"));
                revenue.setDescription(resultSet.getString("description"));
                revenue.setDateRevenue(DateConveter.convertToLocalDateTime(resultSet.getDate("date_revenue").getTime()));
                revenue.setDateCreation(DateConveter.convertToLocalDateTime(resultSet.getDate("date_creation").getTime()));

                if(resultSet.getDate("date_update") != null){
                    revenue.setDateUpdate(DateConveter.convertToLocalDateTime(resultSet.getDate("date_update").getTime()));
                }

                // creates a user
                var user = new User();
                user.setId(resultSet.getLong("user_id"));

                //add user to revenue
                revenue.setUser(user);

                // add revenue in list of revenue
                revenues.add(revenue);
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

        return revenues;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
