package com.example.commerce.service;

import com.example.commerce.domain.Appointment;
import com.example.commerce.domain.Customer;
import com.example.commerce.repository.AppointmentRepository;
import com.example.commerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public Appointment create(Long cus_id, Appointment appointment) {

        Customer customer;

        System.out.println("location " + appointment.getLocation());
        System.out.println("time " + appointment.getTime());
        System.out.println("customer id " + cus_id);
        customer = customerRepository.findById(cus_id).orElseThrow(() -> new IllegalArgumentException("Check customer Id"));

        System.out.println("setCustomer ");
        appointment.setCustomer(customer);
        System.out.println("Method call ");

        return appointmentRepository.save(appointment);
    }

}


