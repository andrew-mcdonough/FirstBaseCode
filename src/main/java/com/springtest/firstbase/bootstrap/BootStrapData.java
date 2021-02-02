package com.springtest.firstbase.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springtest.firstbase.domain.FBEmployee;
import com.springtest.firstbase.repositories.EmployeeRepository;


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
        employeeFBfirst.setName("Santa Clause");
        employeeFBfirst.setEmail("santa.clause@hotmail.com");
        employeeFBfirst.setTitle("The Boss");
        employeeRepository.save(employeeFBfirst);
         
        FBEmployee employeeFBsecond = new FBEmployee();
        employeeFBsecond.setName("Rudolf Reindeer");
        employeeFBsecond.setEmail("rudolf.reindeer@homail.com");
        employeeFBsecond.setTitle("Shiny Nose");
        employeeRepository.save(employeeFBsecond);
        
        FBEmployee employeeFBthird = new FBEmployee();
        employeeFBthird.setName("Snow white");
        employeeFBthird.setEmail("snow.white@hotmail.com");
        employeeFBthird.setTitle("Head Organiser");
        employeeRepository.save(employeeFBthird);

        System.out.println("employeeRepository Count: " + employeeRepository.count());
    }
}
