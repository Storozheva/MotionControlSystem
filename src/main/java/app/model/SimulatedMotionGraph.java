package app.model;

import lombok.Data;

import java.util.List;

@Data
public class SimulatedMotionGraph {

    private List<EmergencySituation> emergencySituationList;
    private int averageDelayForStationsInMinutes;
    private int totalTimeOfTrafficDisturbance;

    private DailyTimetable finalTimetable;
}
