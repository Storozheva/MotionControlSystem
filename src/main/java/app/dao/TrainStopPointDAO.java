package app.dao;


import app.model.Station;
import app.model.TrainStopPoint;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainStopPointDAO extends DAO<TrainStopPoint> {

    private StationDAO stationDAO;

    public TrainStopPointDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
        tableName = "train_stop_points";
        columns = new String[]{
                "station_id",
                "arrival_time_in_minutes",
                "dispatch_time_in_minutes",
                "stop_duration_in_minutes"
        };
    }

    @Override
    protected List<TrainStopPoint> convertFrom(ResultSet resultSet) throws SQLException {
        List<TrainStopPoint> trainStopPoints = new ArrayList<>();
        while (resultSet.next()) {
            TrainStopPoint trainStopPoint = new TrainStopPoint();

            trainStopPoint.setId(resultSet.getInt("id"));
            trainStopPoint.setArrivalTimeInMinutes(resultSet.getInt("arrival_time_in_minutes"));
            trainStopPoint.setDispatchTimeInMinutes(resultSet.getInt("dispatch_time_in_minutes"));
            trainStopPoint.setStopDurationInMinutes(resultSet.getInt(  "stop_duration_in_minutes"));

            Station station = stationDAO.findById(resultSet.getInt("station_id"));
            trainStopPoint.setTrainStopStation(station);

            trainStopPoints.add(trainStopPoint);
        }
        return trainStopPoints;
    }

    @Override
    protected String createInsertQuery(TrainStopPoint trainStopPoint) {
        String fields = String.join(", ", columns);

        String values =
                trainStopPoint.getTrainStopStation().getId() + ", "
                        + trainStopPoint.getArrivalTimeInMinutes() + ", "
                        + trainStopPoint.getDispatchTimeInMinutes() + ", "
                        + trainStopPoint.getStopDurationInMinutes();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(TrainStopPoint trainStopPoint) {
        String query =
                "UPDATE " + tableName + " SET "
                        + "station_id = " + trainStopPoint.getTrainStopStation().getId() + ", "
                        + "arrival_time_in_minutes = " + trainStopPoint.getArrivalTimeInMinutes() + ", "
                        + "dispatch_time_in_minutes = " + trainStopPoint.getDispatchTimeInMinutes() + ", "
                        + "stop_duration_in_minutes = " + trainStopPoint.getStopDurationInMinutes() + " "
                        + "WHERE id = " + trainStopPoint.getId();
        return query;
    }
}
