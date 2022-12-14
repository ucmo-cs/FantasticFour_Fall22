package com.example.commerce.domain.DTO;

import com.example.commerce.domain.Location;
import com.example.commerce.domain.Services;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class LocationDTO {
    private Long id;
    private String name;
    private String address;
    private LocalDateTime open;
    private LocalDateTime close;
    private List<Services> services;
    private Boolean mon;
    private Boolean tue;
    private Boolean wed;
    private Boolean thu;
    private Boolean fri;
    private Boolean sat;
    private Boolean sun;
    private List<AppointmentDTO> appointments = new ArrayList<>();

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.address = location.getAddress();
        this.open = location.getOpen();
        this.close = location.getClose();
        this.services = location.getServices();
        this.mon = location.getMon();
        this.tue = location.getTue();
        this.wed = location.getWed();
        this.thu = location.getThu();
        this.fri = location.getFri();
        this.sat = location.getSat();
        this.sun = location.getSun();
    }

}
