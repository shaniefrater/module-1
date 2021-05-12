package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class AirportAPI {

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String siteHome() {

        return("{\"message\":\"Welcome to the Global Airports System\"}");
    }
    // get all airports (200 / 404-400)

    @GetMapping(value = {"/airports"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAirports() {

        return("{\"message\":\"View all airports data\"}");
    }
    // get all airports (200 / 404-400)

    @GetMapping(value = {"/airports/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAirport() {

        return("{\"message\":\"You are now viewing {id}\"}");
    }
    // retrieve specific airport data (200 / 400)

    @PostMapping(value = {"/airports"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addAirport() {

        return("{\"message\":\"Please select which airport to add to the system\"}");
    }
    // create an airport in the collection (201)

    @PutMapping(value = {"/airports/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateAirport() {

        return("{\"message\":\"Select the airport you wish to amend\"}");
    }
    // updating a specific airport (200-204)

    @DeleteMapping(value = {"/airports"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAirports() {

        return("{\"message\":\"Delete entire airport list\"}");
    }
    // delete entire array of airports (200-204)

    @DeleteMapping(value = {"/airports/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAirport() {

        return("{\"message\":\"Delete specific airport\"}");
    }
    // deleting a specific airport or airport data field (200-204)
}
