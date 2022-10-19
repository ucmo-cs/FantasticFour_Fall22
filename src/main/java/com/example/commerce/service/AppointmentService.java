package com.example.commerce.service;

import com.example.commerce.domain.Appointment;
import com.example.commerce.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerService customerService;
    private final LocationService locationService;

    public List<Appointment> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.size() > 0) return appointments;
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no appointments");
    }

    public Appointment getById(Long appId) {
        if (appId != null && appId > 0) {
            Optional<Appointment> appointment = appointmentRepository.findById(appId);
            if (appointment.isPresent()) return appointment.get();
            else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No appointment found with id " + appId);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public Appointment create(Long cus_id, Appointment appointment) {
        appointment.setCustomer(customerService.getById(cus_id));
        appointment.setLocation(locationService.getById(appointment.getLocation().getId()));
        return appointmentRepository.save(appointment);
    }

    public Appointment update(Long appId, Appointment appointment) {
        appointment.setId(appId);
        return appointmentRepository.save(appointment);
    }

    public void delete(Long appId) {
        try {
            appointmentRepository.deleteById(appId);
        } catch (InvalidDataAccessResourceUsageException | EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Appointment with id " + appId + " doesn't exist and could not be deleted");
        }
    }

}

