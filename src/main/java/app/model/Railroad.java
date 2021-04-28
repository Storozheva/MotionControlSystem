package app.model;

import lombok.Data;

import java.util.List;

@Data
public class Railroad {

    List<Station> stationList;
    DailyTimetable timetable;
}
