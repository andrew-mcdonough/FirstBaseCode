package com.springtest.firstbase.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springtest.firstbase.domain.FBEmployee;
import com.springtest.firstbase.repositories.EmployeeRepository;

/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public BootStrapData( EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        FBEmployee employeeFBfirst = new FBEmployee();
//        Picture picture = new Picture();
//        picture.setMedium("http//abc.abc");
        employeeFBfirst.setName("Santa Clause");
        employeeFBfirst.setEmail("santa.clause@hotmail.com");
        employeeFBfirst.setTitle("The Boss");
   //     employeeFB.setPicture(picture);
        employeeRepository.save(employeeFBfirst);
        
        FBEmployee employeeFBsecond = new FBEmployee();
//        picture.setMedium("http//abc.abc");
        employeeFBsecond.setName("Rudolf Reindeer");
        employeeFBsecond.setEmail("rudolf.reindeer@homail.com");
        employeeFBsecond.setTitle("Shiny Nose");
    //    employeeFB.setPicture(picture);
        employeeRepository.save(employeeFBsecond);
        
        FBEmployee employeeFBthird = new FBEmployee();
      //  picture.setMedium("http//abc.abc");
        employeeFBthird.setName("Snow white");
        employeeFBthird.setEmail("snow.white@hotmail.com");
        employeeFBthird.setTitle("Head Organiser");
      //  employeeFB.setPicture(picture);
        employeeRepository.save(employeeFBthird);

        System.out.println("employeeRepository Count: " + employeeRepository.count());
    }
}
