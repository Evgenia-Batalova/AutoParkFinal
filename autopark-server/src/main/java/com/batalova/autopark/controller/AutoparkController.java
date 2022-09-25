package com.batalova.autopark.controller;

import com.batalova.autopark.dto.AutoDto;
import com.batalova.autopark.dto.JournalDto;
import com.batalova.autopark.dto.PersonnelDto;
import com.batalova.autopark.dto.RouteDto;
import com.batalova.autopark.services.AutoparkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoparkController {

    private final AutoparkService autoparkService;

    public AutoparkController(AutoparkService autoparkService) {
        this.autoparkService = autoparkService;
    }

    @PostMapping(path = "/add-auto")
    public ResponseEntity<Integer> addAuto(
            @RequestParam(name = "personnel_id")
            int personnelId,
            @RequestParam(name = "color")
            String color,
            @RequestParam(name = "num")
            String num,
            @RequestParam(name = "mark")
            String mark
    )
    {
        AutoDto newAuto = new AutoDto(Optional.empty(), personnelId, color, num, mark);

        int id = autoparkService.addAuto(newAuto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(path = "/add-personnel")
    public ResponseEntity<Integer> addPersonnel(
            @RequestParam(name = "first_name")
            String firstName,
            @RequestParam(name = "last_name")
            String lastName,
            @RequestParam(name = "father_name")
            String fatherName
    )
    {
        PersonnelDto newPersonnel = new PersonnelDto(Optional.empty(), firstName, lastName, fatherName);

        int id = autoparkService.addPersonnel(newPersonnel);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(path = "/add-route")
    public ResponseEntity<Integer> addRoute(
            @RequestParam(name = "name")
            String name
    )
    {
        RouteDto newRoute = new RouteDto(Optional.empty(), name);

        int id = autoparkService.addRoute(newRoute);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-route/{id}")
    public ResponseEntity<List<RouteDto>> deleteRoute(
            @PathVariable int id
    )
    {

        autoparkService.deleteRoute(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-personnel/{id}")
    public ResponseEntity<Void> deletePersonnel(
            @PathVariable(name = "id") int id
    )
    {
        autoparkService.deletePersonnel(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-auto/{id}")
    public ResponseEntity<List<AutoDto>> deleteAuto(
            @PathVariable int id
    )
    {

        autoparkService.deleteAuto(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-auto-by-color")
    public ResponseEntity<List<AutoDto>> findAutoByColor(
            @RequestParam(name = "color")
            String color
    )
    {
        List<AutoDto> autosByColor = autoparkService.findAutoByColor(color);

        return new ResponseEntity<>(autosByColor, HttpStatus.OK);
    }

    @GetMapping(value = "/find-auto-by-number")
    public ResponseEntity<List<AutoDto>> findAutoByNumber(
            @RequestParam(name = "num")
            String num
    )
    {
        List<AutoDto> autosByNumber = autoparkService.findAutoByNumber(num);

        return new ResponseEntity<>(autosByNumber, HttpStatus.OK);
    }

    @GetMapping(value = "/find-auto-by-mark")
    public ResponseEntity<List<AutoDto>> findAutoByMark(
            @RequestParam(name = "mark")
            String mark
    )
    {
        List<AutoDto> autosByMark = autoparkService.findAutoByMark(mark);

        return new ResponseEntity<>(autosByMark, HttpStatus.OK);
    }

    @GetMapping(value = "/find-personnel-by-first-name")
    public ResponseEntity<List<PersonnelDto>> findPersonnelByFirstName(
            @RequestParam(name = "first_name")
            String firstName
    )
    {
        List<PersonnelDto> findFirstName = autoparkService.findPersonnelByFirstName(firstName);

        return new ResponseEntity<>(findFirstName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-personnel-by-last-name")
    public ResponseEntity<List<PersonnelDto>> findPersonnelByLastName(
            @RequestParam(name = "last_name")
            String lastName
    )
    {
        List<PersonnelDto> personnelByLastName = autoparkService.findPersonnelByLastName(lastName);

        return new ResponseEntity<>(personnelByLastName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-personnel-by-father-name")
    public ResponseEntity<List<PersonnelDto>> findPersonnelByFatherName(
            @RequestParam(name = "father_name")
            String fatherName
    )
    {
        List<PersonnelDto> personnelByFatherName = autoparkService.findPersonnelByFatherName(fatherName);

        return new ResponseEntity<>(personnelByFatherName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-route-by-name")
    public ResponseEntity<List<RouteDto>> findRouteByName(
            @RequestParam(name = "name")
            String name
    )
    {
        List<RouteDto> routeByName = autoparkService.findRouteByName(name);

        return new ResponseEntity<>(routeByName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-unfinished-route-by-auto")
    public ResponseEntity<List<JournalDto>> findUnfinishedRouteByAuto(
            @RequestParam(name = "num")
            String num
    )
    {
        List<JournalDto> routeByAuto = autoparkService.findUnfinishedRouteByAuto(num);

        return new ResponseEntity<>(routeByAuto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-unfinished-route-by-auto-id")
    public ResponseEntity<List<JournalDto>> findUnfinishedRouteByAutoId(
            @RequestParam(name = "auto_id")
            int autoId
    )
    {
        List<JournalDto> routeByAutoId = autoparkService.findUnfinishedRouteByAutoId(autoId);

        return new ResponseEntity<>(routeByAutoId, HttpStatus.OK);
    }

    @GetMapping(value = "/is-route-finished")
    public ResponseEntity<Boolean> isRouteFinished(
            @RequestParam(name = "journal_id")
            int journalId
    )
    {
        Boolean isFinished = autoparkService.isRouteFinished(journalId);

        return new ResponseEntity<>(isFinished, HttpStatus.OK);
    }

    @GetMapping(value = "/finish-route-by-number")
    public ResponseEntity<Void> finishRouteByNumber(
            @RequestParam(name = "num")
            String num
    )
    {
        autoparkService.finishRouteByAutoNumber(num);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/start-route-by-auto-number-and-route-name")
    public ResponseEntity<Integer> startRouteByAutoNumberAndRouteName(
            @RequestParam(name = "num")
            String num,
            @RequestParam(name = "name")
            String name
    )
    {
        int startByAutoNumberAndRouteName = autoparkService.startRouteByAutoNumberAndRouteName(num, name);

        return new ResponseEntity<>(startByAutoNumberAndRouteName, HttpStatus.OK);
    }

    @PostMapping(value = "/update-auto-color")
    public ResponseEntity<Void> updateAutoColor(
            @RequestParam(name = "color")
            String color,
            @RequestParam(name = "num")
            String num
    )
    {
        autoparkService.updateAutoColor(color, num);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update-auto-number")
    public ResponseEntity<List<AutoDto>> updateAutoNumber(
            @RequestParam(name = "old_number")
            String oldNumber,
            @RequestParam(name = "new_number")
            String newNumber
    )
    {
        autoparkService.updateAutoNumber(oldNumber, newNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-personnel-by-full-name")
    public ResponseEntity<List<PersonnelDto>> findPersonnelByFullName(
            @RequestParam(name = "first_name")
            String firstName,
            @RequestParam(name = "last_name")
            String lastName,
            @RequestParam(name = "father_name")
            String fatherName
    )
    {
        List<PersonnelDto> personnelByFullName = autoparkService.findPersonnelByFullName(firstName, lastName, fatherName);

        return new ResponseEntity<>(personnelByFullName, HttpStatus.OK);
    }

    @PostMapping(value = "/update-personnel-first-name")
    public ResponseEntity<List<PersonnelDto>> updatePersonnelFirstName(
            @RequestParam(name = "old_first_name")
            String oldFirstName,
            @RequestParam(name = "old_last_name")
            String oldLastName,
            @RequestParam(name = "old_father_name")
            String oldFatherName,
            @RequestParam(name = "new_first_name")
            String newFirstName
    )
    {
        autoparkService.updatePersonnelFirstName(oldFirstName, oldLastName, oldFatherName, newFirstName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update-personnel-last-name")
    public ResponseEntity<List<PersonnelDto>> updatePersonnelLastName(
            @RequestParam(name = "old_first_name")
            String oldFirstName,
            @RequestParam(name = "old_last_name")
            String oldLastName,
            @RequestParam(name = "old_father_name")
            String oldFatherName,
            @RequestParam(name = "new_last_name")
            String newLastName
    )
    {
        autoparkService.updatePersonnelLastName(oldFirstName, oldLastName, oldFatherName, newLastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update-personnel-father-name")
    public ResponseEntity<List<PersonnelDto>> updatePersonnelFatherName(
            @RequestParam(name = "old_first_name")
            String oldFirstName,
            @RequestParam(name = "old_last_name")
            String oldLastName,
            @RequestParam(name = "old_father_name")
            String oldFatherName,
            @RequestParam(name = "new_father_name")
            String newFatherName
    )
    {
        autoparkService.updatePersonnelFatherName(oldFirstName, oldLastName, oldFatherName, newFatherName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/show-all-auto")
    public ResponseEntity<List<AutoDto>> showAllAuto()
    {
        List<AutoDto> autoDtoList = autoparkService.showAllAuto();

        return new ResponseEntity<>(autoDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/show-all-personnel")
    public ResponseEntity<List<PersonnelDto>> showAllPersonnel()
    {
        List<PersonnelDto> personnelDtoList = autoparkService.showAllPersonnel();

        return new ResponseEntity<>(personnelDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/show-all-route")
    public ResponseEntity<List<RouteDto>> showAllRoute()
    {
        List<RouteDto> routeDtoList = autoparkService.showAllRoute();

        return new ResponseEntity<>(routeDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/find-unfinished-route-by-route-name")
    public ResponseEntity<List<JournalDto>> findUnfinishedRouteByRouteName(
            @RequestParam(name = "name")
            String name
    )
    {
        List<JournalDto> routeByName = autoparkService.findUnfinishedRouteByRouteName(name);

        return new ResponseEntity<>(routeByName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-finished-route-by-auto")
    public ResponseEntity<List<JournalDto>> findFinishedRouteByAuto(
            @RequestParam(name = "num")
            String num
    )
    {
        List<JournalDto> finishedRouteByAuto = autoparkService.findFinishedRouteByAuto(num);

        return new ResponseEntity<>(finishedRouteByAuto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-finished-route-by-route-name")
    public ResponseEntity<List<JournalDto>> findFinishedRouteByRouteName(
            @RequestParam(name = "name")
            String name
    )
    {
        List<JournalDto> finishedRouteByRouteName = autoparkService.findFinishedRouteByRouteName(name);

        return new ResponseEntity<>(finishedRouteByRouteName, HttpStatus.OK);
    }

    @GetMapping(value = "/find-unfinished-route-by-full-name")
    public ResponseEntity<List<JournalDto>> findUnfinishedRouteByFullName(
            @RequestParam(name = "first_name")
            String firstName,
            @RequestParam(name = "last_name")
            String lastName,
            @RequestParam(name = "father_name")
            String fatherName
    )
    {
        List<JournalDto> routeByFullName = autoparkService.findUnfinishedRouteByFullName(firstName, lastName, fatherName);

        return new ResponseEntity<>(routeByFullName, HttpStatus.OK);
    }

}
