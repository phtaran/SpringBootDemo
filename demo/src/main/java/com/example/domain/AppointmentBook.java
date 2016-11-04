package com.example.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentBook implements Serializable {

    public Map<String, Appointment> getAppointmentsForToday() {
        return new HashMap<>();
    }

    public Map<String, Appointment> getAppointmentsForDay(Date day) {
        return new HashMap<>();
    }

    public void addAppointment(AppointmentForm appointmentForm) {

    }
}
