package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class AirportAPI {

    @GetMapping(value = {"/globalDirectory"})
    public String globalDirectory() {
        return("Welcome to the Global Airports System");
    }

    @PostMapping(value = {"/airportList"})
    public String airportList() {
        return("Please see below airports");
    }

    @PutMapping(value = {"/updateAirportList"})
    public String updateAirportList() {
        return("Select the airport you wish to amend");
    }

    @DeleteMapping(value = {"/deleteAirports"})
    public String deleteAirports() {
        return("Delete entire airport list");
    }

    @PutMapping(value = {"/updateAirpotRef"})
    public String updateAirpotRef() {
        return("Change ref of airport");
    }

    @DeleteMapping(value = {"/deleteAirport"})
    public String deleteAirport() {
        return("Delete specific airport");
    }
}
