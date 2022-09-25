package com.batalova.autopark.jdbc;

import com.batalova.autopark.dto.AutoDto;
import com.batalova.autopark.dto.JournalDto;
import com.batalova.autopark.dto.PersonnelDto;
import com.batalova.autopark.dto.RouteDto;

import java.time.Instant;
import java.util.List;


public interface AutoparkDao {

    int addAuto(AutoDto autoDto);

    int addPersonnel(PersonnelDto personnelDto);

    int addRoute(RouteDto routeDto);

    void deleteAuto(int autoId);

    void deletePersonnel(int personnelId);

    void deleteRoute(int routeId);

    List<JournalDto> deleteJournal(int journalId);

    List<AutoDto> findAutoByColor(String color);

    List<AutoDto> findAutoByMark(String color);

    List<AutoDto> findAutoByNumber(String number);

    List<PersonnelDto> findPersonnelByFirstName(String firstName);

    List<PersonnelDto> findPersonnelByLastName(String lastName);

    List<PersonnelDto> findPersonnelByFatherName(String fatherName);

    List<JournalDto> findUnfinishedRouteByAuto(String autoNumber);

    List<JournalDto> findUnfinishedRouteByAutoId(int autoId);

    Boolean isRouteFinishedByJournalId(int routeId);
    int startRoute(JournalDto journalDto);

    void finishRouteByJournalId(int id, Instant timeOut);

    List<RouteDto> findRouteByName(String routeName);

    void updateAutoColor(String color, String number);

    void updateAutoNumber(String num, int id);

    List<PersonnelDto> findPersonnelByFullName(String firstName, String lastName, String fatherName);

    List<PersonnelDto> updatePersonnelFirstName(String firstName, String lastName, String fatherName);

    List<PersonnelDto> updatePersonnelLastName(String lastName, String firstName, String fatherName);

    List<PersonnelDto> updatePersonnelFatherName(String fatherName, String firstName, String lastName);

    List<AutoDto> showAllAuto();

    List<PersonnelDto> showAllPersonnel();

    List<RouteDto> showAllRoute();

    List<JournalDto> findFinishedRouteByAuto(String autoNumber);

    List<JournalDto> findUnfinishedRouteByRouteName(String routeName);

    List<JournalDto> findFinishedRouteByRouteName(String routeName);

    List<JournalDto> findUnfinishedRouteByFullName(String firstName, String lastName, String fatherName);
}

