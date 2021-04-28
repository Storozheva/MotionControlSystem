package app.model;

import lombok.Data;

import java.util.List;

@Data
public class Route {

    private int id;
    private String name;
    private double lengthInKilometers;

    private int startTimeInMinutesFromMidnight;

    private Station departurePoint;
    private List<Station> intermediateStations;
    private Station destinationPoint;

    private List<TrainStopPoint> trainStopPoints;
}
