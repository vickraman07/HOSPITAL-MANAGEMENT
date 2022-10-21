package com.webservice.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import javax.transaction.Transactional;

import com.webservice.rest.controller.DoctorController;
import com.webservice.rest.controller.PatientController;
import com.webservice.rest.entity.Doctor;
import com.webservice.rest.entity.Patient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestApplicationTests 
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PatientController patientController;

    @Autowired
     DoctorController doctorController;


    @Test
    public void test(){
        assertTrue(true);
    }
    @Test
    public void  showPatientInformationTest(){
        Patient patient =patientController.showPatientInformation(5);
        assertEquals(patient.getName(),"RAINA");
    }

    @Test
    public void showDoctorInformationTest(){
        Doctor doc = doctorController.getDoctorInfo("VIRAT KOHLI"); 
        assertEquals(doc.getField(),"PSHYSIAN");
        logger.info(doc.toString());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void saveDoctorInformation(){
        Doctor doc = new Doctor("hello", 12, "male", "ent");
        boolean res=doctorController.addUser(doc);
        assertTrue(res);
    }

    //@Test
    //@DirtiesContext
    //@Transactional
    /*public void savePatientInformation(){
        Patient patient = new Patient(1001, "hello", 30, "DR. POONAM JALAN",LocalDate.now(), "male", "xyz");
        boolean res = patientController.createPatient(patient);
        assertTrue(res);
    } */
}
