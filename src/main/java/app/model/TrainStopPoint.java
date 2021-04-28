package app.model;

import lombok.Data;

@Data
public class TrainStopPoint {

    private int id;
    private Station trainStopStation;
    private int arrivalTimeInMinutes;
    private int dispatchTimeInMinutes;
    private int stopDurationInMinutes;
}
