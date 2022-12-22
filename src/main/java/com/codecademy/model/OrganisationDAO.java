package com.codecademy.model;

import com.codecademy.entity.Organisation;
import com.codecademy.logic.DAO;
import com.codecademy.logic.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganisationDAO implements DAO<Organisation> {
    private DBConnection dbConnection;

    public OrganisationDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Organisation> getAll() throws SQLException {
        Statement statement = null;
        ResultSet result = null;
        ArrayList<Organisation> organisationList = new ArrayList<>();

        try {
            Connection connection = dbConnection.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM ORGANISATION");

            while (result.next()) {
                Organisation organisation = new Organisation();
                organisation.setOrganisationId(result.getInt(1));
                organisation.setName(result.getString(2));
                organisationList.add(organisation);
            }

        } catch(SQLException e) {
            e.printStackTrace();

        } finally {
            if (result != null) {
                result.close();
            }

            if (statement != null) {
                statement.close();
            }
        }
        return organisationList;
    }

    @Override
    public Optional<Organisation> get(long id) {
        return Optional.empty();
    }

    @Override
    public void save(Organisation organisation) {

    }

    @Override
    public void update(Organisation organisation, String[] params) {

    }

    @Override
    public void delete(Organisation organisation) {

    }
}