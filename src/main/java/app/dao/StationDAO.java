package app.dao;


import app.model.Station;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StationDAO extends DAO<Station> {

    public StationDAO() {
        tableName = "stations";
        columns = new String[]{
               "name"
        };
    }

    @Override
    protected List<Station> convertFrom(ResultSet resultSet) throws SQLException {
        List<Station> stations = new ArrayList<>();
        while (resultSet.next()) {
            Station station = new Station();

            station.setId(resultSet.getInt("id"));
            station.setName(resultSet.getString("name"));

            stations.add(station);
        }
        return stations;
    }

    @Override
    protected String createInsertQuery(Station station) {
        String fields = String.join(", ", columns);

        String values =
                "'" + station.getName() + "'";
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(Station station) {
        String query =
                "UPDATE " + tableName + " SET "
                        + "name = '" + station.getName() + "' "
                        + "WHERE id = " + station.getId();
        return query;
    }
}
