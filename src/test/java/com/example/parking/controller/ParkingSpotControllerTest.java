package com.example.parking.controller;

import com.example.parking.model.ParkingSpot;
import com.example.parking.service.ParkingSpotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ParkingSpotController.class)
public class ParkingSpotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingSpotService service;

    @Test
    void testGetAll() throws Exception {
        when(service.getAllSpots()).thenReturn(List.of(new ParkingSpot()));
        mockMvc.perform(get("/spots"))
               .andExpect(status().isOk());
    }

    @Test
    void testGetByInvalidId() throws Exception {
        when(service.getSpot(99L)).thenThrow(new RuntimeException("Not found"));
        mockMvc.perform(get("/spots/99"))
               .andExpect(status().isInternalServerError());
    }
}
