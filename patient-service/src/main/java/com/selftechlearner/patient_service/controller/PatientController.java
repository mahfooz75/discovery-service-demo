package com.selftechlearner.patient_service.controller;

import com.selftechlearner.patient_service.model.Doctor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final RestClient.Builder restClientBuilder;

    public PatientController(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    @GetMapping("/appointment")
    public Map<String, List<Doctor>> bookAppointment() {
        RestClient restClient = restClientBuilder.baseUrl("http://doctor-service/doctor").build();

        return restClient.get().uri("/details").retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
