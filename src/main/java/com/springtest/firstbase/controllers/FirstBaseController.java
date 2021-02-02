package com.springtest.firstbase.controllers;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.springtest.firstbase.domain.Book;
import com.springtest.firstbase.domain.FBEmployee;
import com.springtest.firstbase.pojo.Employee;
import com.springtest.firstbase.pojo.Greeting;
import com.springtest.firstbase.pojo.Result;
import com.springtest.firstbase.repositories.EmployeeRepository;


@Controller
public class FirstBaseController {
Logger logger = Logger.getLogger(FirstBaseController.class.getName());
    private final EmployeeRepository employeeRepository;

    public FirstBaseController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    } 
    
    @RequestMapping("/firstBase")
    public String firstBase(Model model) {
       
    	logger.info("get requestsdfsdfs ");
        model.addAttribute("books", employeeRepository.findAll());
        FBEmployee employeeFBthird = new FBEmployee();
        model.addAttribute("fbEmployee", employeeFBthird);
        return "firstBase";
    }
    
    private ResponseEntity<Employee> getEmployeeRandom()
    {
    	ResponseEntity<Employee> result = null;
        final String uri = "https://randomuser.me/api/";
        RestTemplate restTemplate = new RestTemplate();
        try
        {
         result = restTemplate.getForEntity(uri, Employee.class);
        }
        catch(Exception e)
        {
        	 return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return result;
    }
    
    @PostMapping("/newemployee")
    public String newEmployeeSubmit(@ModelAttribute FBEmployee fbEmployee, Model model) {
       logger.info("greeting ANDREW fbEmployee  " + fbEmployee.getTitle());
       FBEmployee employeeFBthird = new FBEmployee();
       ResponseEntity<Employee> newEmployeeList = getEmployeeRandom();
       if(newEmployeeList.getStatusCode() == HttpStatus.OK)
       {
    	   
    	   Result employee = newEmployeeList.getBody().getResults().get(0);
	       employeeFBthird.setName(employee.getName().first + " " + employee.getName().last);
	       employeeFBthird.setEmail(employee.getEmail());
	       employeeFBthird.setTitle(fbEmployee.getTitle());
	       logger.info("employee submit success " + employee.getEmail()); 
           employeeRepository.save(employeeFBthird);
       }else
       {
    	   logger.info("employee submit failed");   
       }
       model.addAttribute("fbEmployee", employeeFBthird);
       return "redirect:/firstBase";
    }
        
}
