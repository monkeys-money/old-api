package br.com.monkeys_money.infradb.repository;

import br.com.monkeys_money.infradb.repository.factory.ConnectionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public abstract class Repository<T> {
    @Inject
    private ConnectionFactory factory;

    protected Connection connection = null ;
    protected PreparedStatement ptmt = null;
    protected ResultSet resultSet = null;

    public void getConnection() throws SQLException {
       connection = factory.getConnection();
    }

    public abstract T save(T t);

    public abstract T update(T t);

    public abstract T findById(final Long id);

    public abstract Boolean delete(final Long id);


}
