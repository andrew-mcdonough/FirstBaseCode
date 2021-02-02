package com.springtest.firstbase.repositories;

import org.springframework.data.repository.CrudRepository;
import com.springtest.firstbase.domain.FBEmployee;

public interface EmployeeRepository  extends CrudRepository<FBEmployee, Long> {

}
