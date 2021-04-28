package app.dao;


import app.model.Route;
import app.model.RouteWithTrainStopPoints;
import app.model.Station;
import app.model.TrainStopPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteDAO extends DAO<Route> {

    private StationDAO stationDAO;
    private TrainStopPointDAO trainStopPointDAO;
    private RouteWithTrainStopPointsDAO routeWithTrainStopPointsDAO;

    public RouteDAO(StationDAO stationDAO, TrainStopPointDAO trainStopPointDAO, RouteWithTrainStopPointsDAO routeWithTrainStopPointsDAO) {
        this.stationDAO = stationDAO;
        this.trainStopPointDAO = trainStopPointDAO;
        this.routeWithTrainStopPointsDAO = routeWithTrainStopPointsDAO;
        tableName = "routes";
        columns = new String[]{
                "name",
                "start_time_in_minutes_from_midnight",
                "length_in_kilometers",
                "departure_point_id",
                "destination_point_id"
        };
    }

    @Override
    protected List<Route> convertFrom(ResultSet resultSet) throws SQLException {
        List<Route> routes = new ArrayList<>();
        while (resultSet.next()) {
            Route route = new Route();

            route.setId(resultSet.getInt("id"));
            route.setName(resultSet.getString( "name"));
            route.setStartTimeInMinutesFromMidnight(resultSet.getInt("start_time_in_minutes_from_midnight"));
            route.setLengthInKilometers(resultSet.getDouble( "length_in_kilometers"));

            Station departurePoint = stationDAO.findById(resultSet.getInt("departure_point_id"));
            Station destinationPoint = stationDAO.findById(resultSet.getInt("destination_point_id"));

            route.setDeparturePoint(departurePoint);
            route.setDestinationPoint(destinationPoint);

            List<Integer> trainStopPointsId = new ArrayList<>();
            List<TrainStopPoint> trainStopPoints = new ArrayList<>();

            List<RouteWithTrainStopPoints> pairs = routeWithTrainStopPointsDAO.findAll();
            for (RouteWithTrainStopPoints r:
                 pairs) {
                if (r.getRouteId() == route.getId()){
                    trainStopPointsId.add(r.getTrainStopPointId());
                }
            }
            List<TrainStopPoint> allTrainStopPoints =  trainStopPointDAO.findAll();
            for (TrainStopPoint t:
                 allTrainStopPoints) {
                if (trainStopPointsId.contains(t.getId())) {
                    trainStopPoints.add(t);
                }
            }

            route.setTrainStopPoints(trainStopPoints);

            List<Station> intermediateStations = new ArrayList<>();
            for (TrainStopPoint t:
                 trainStopPoints) {
                intermediateStations.add(t.getTrainStopStation());
            }
            route.setIntermediateStations(intermediateStations);

            routes.add(route);
        }
        return routes;
    }

    @Override
    protected String createInsertQuery(Route route) {
        String fields = String.join(", ", columns);

        String values =
                "'" + route.getName() + "', "
                        + route.getStartTimeInMinutesFromMidnight() + ", "
                        + route.getLengthInKilometers() + ", "
                        + route.getDeparturePoint().getId() + ", "
                        + route.getDestinationPoint().getId();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(Route route) {
        String query =
                "UPDATE " + tableName + " SET "
                        + "name = '" + route.getName() + "', "
                        + "start_time_in_minutes_from_midnight = " + route.getStartTimeInMinutesFromMidnight() + ", "
                        + "length_in_kilometers = " + route.getLengthInKilometers() + ", "
                        + "departure_point_id = " + route.getDeparturePoint().getId() + ", "
                        + "destination_point_id = " + route.getDestinationPoint().getId() + " "
                        + "WHERE id = " + route.getId();
        return query;
    }
}
