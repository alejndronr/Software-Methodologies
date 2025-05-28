package com.example.parking.service;

import com.example.parking.model.ParkingSpot;
import com.example.parking.repository.ParkingSpotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotServiceTest {

    @Mock
    private ParkingSpotRepository repository;

    @InjectMocks
    private ParkingSpotService service;

    @Test
    void testGetAllSpots() {
        when(repository.findAll()).thenReturn(List.of(new ParkingSpot()));
        assertEquals(1, service.getAllSpots().size());
    }

    @Test
    void testGetSpotNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.getSpot(1L));
    }
}
