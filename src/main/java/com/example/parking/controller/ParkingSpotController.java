package com.example.parking.controller;

import com.example.parking.model.ParkingSpot;
import com.example.parking.service.ParkingSpotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spots")
public class ParkingSpotController {
    private final ParkingSpotService service;

    public ParkingSpotController(ParkingSpotService service) {
        this.service = service;
    }

    @GetMapping
    public List<ParkingSpot> getAll() {
        return service.getAllSpots();
    }

    @GetMapping("/{id}")
    public ParkingSpot getById(@PathVariable Long id) {
        return service.getSpot(id);
    }

    @PostMapping
    public ParkingSpot add(@RequestBody ParkingSpot spot) {
        return service.addSpot(spot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSpot(id);
    }
}
