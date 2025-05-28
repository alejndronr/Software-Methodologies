package com.example.parking.service;

import com.example.parking.model.ParkingSpot;
import com.example.parking.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {
    private final ParkingSpotRepository repository;

    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public List<ParkingSpot> getAllSpots() {
        return repository.findAll();
    }

    public ParkingSpot getSpot(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public ParkingSpot addSpot(ParkingSpot spot) {
        return repository.save(spot);
    }

    public void deleteSpot(Long id) {
        repository.deleteById(id);
    }
}
