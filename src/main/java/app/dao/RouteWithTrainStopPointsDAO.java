package app.dao;


import app.model.RouteWithTrainStopPoints;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteWithTrainStopPointsDAO extends DAO<RouteWithTrainStopPoints> {

    public RouteWithTrainStopPointsDAO() {
        tableName = "routes_with_train_stop_points";
        columns = new String[]{
                "route_id",
                "train_stop_point_id",
        };
    }

    @Override
    protected String createInsertQuery(RouteWithTrainStopPoints routeWithTrainStopPoints) {
        String fields = String.join(", ", columns);

        String values =
               routeWithTrainStopPoints.getRouteId() + ", "
                        + routeWithTrainStopPoints.getTrainStopPointId();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected List<RouteWithTrainStopPoints> convertFrom(ResultSet resultSet) throws SQLException {
        List<RouteWithTrainStopPoints> routeWithTrainStopPointsList = new ArrayList<>();
        while (resultSet.next()) {
            RouteWithTrainStopPoints routeWithTrainStopPoints = new RouteWithTrainStopPoints();
            routeWithTrainStopPoints.setRouteId(resultSet.getInt("route_id"));
            routeWithTrainStopPoints.setTrainStopPointId(resultSet.getInt("train_stop_point_id"));

            routeWithTrainStopPointsList.add(routeWithTrainStopPoints);
        }
        return routeWithTrainStopPointsList;
    }

    public boolean delete(Integer monthId, Integer contractId) {
        final String query = String.format("DELETE FROM %s WHERE route_id = %d and train_stop_point_id = %d", tableName,
               monthId, contractId);
        return executeModifyQuery(query);
    }

    @Override
    protected String createUpdateQuery(RouteWithTrainStopPoints routeWithTrainStopPoints) {
        throw new NotImplementedException();
    }
}
