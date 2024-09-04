package com.selftechlearner.doctor_service.controller;

import com.selftechlearner.doctor_service.model.Doctor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @GetMapping("/details")
    public Map<String, List<Doctor>> getDetails() {
        Doctor doctor1 = new Doctor("Aarav", "Mehta", "Cardiology");
        Doctor doctor2 = new Doctor("Isha", "Patel", "Neurology");
        Doctor doctor3 = new Doctor("Rajesh", "Sharma", "Orthopedics");
        Doctor doctor4 = new Doctor("Sanya", "Desai", "Pediatrics");
        Doctor doctor5 = new Doctor("Vikram", "Reddy", "Cardiology");
        Doctor doctor6 = new Doctor("Ankit", "Kapoor", "Neurology");

        return Stream.of(doctor1, doctor2, doctor3, doctor4, doctor5, doctor6)
                .collect(Collectors.groupingBy(Doctor::specialization, Collectors.toList()));
    }

}
