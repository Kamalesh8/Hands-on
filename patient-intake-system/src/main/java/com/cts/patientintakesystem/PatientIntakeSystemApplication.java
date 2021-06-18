package com.cts.patientintakesystem;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class PatientIntakeSystemApplication {
	@Autowired
	private static ClinicCalender clinicCalender;
	
	public static void main(String[] args) {
		SpringApplication.run(PatientIntakeSystemApplication.class, args);
		PatientAppointment patientAppointment =new PatientAppointment();
		patientAppointment.setName("Kamalesh");
		patientAppointment.setAge(25);
		patientAppointment.setVisitingDoctor(Doctor.DENTIST);
		patientAppointment.setAppointment(new Date());
		
		clinicCalender.addPatientAppointment(patientAppointment);
		log.info("View All Appointments: {}",clinicCalender.viewAllAppointments());
		
	}

}
