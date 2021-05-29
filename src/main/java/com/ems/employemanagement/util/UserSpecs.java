package com.ems.employemanagement.util;

import java.sql.Date;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.EmployeeFilterRequest;
import com.ems.employemanagement.models.EmployeeRequest;
import org.springframework.data.jpa.domain.Specification;
import java.util.*;

import javax.persistence.criteria.Predicate;

public class UserSpecs {

   
   
    public static Specification<User> getUserByIdUserNameNameAddress(EmployeeFilterRequest employeeRequest) {
   
          System.out.println(employeeRequest);
   
        return (root, query, criteriaBuilder) -> {
       
        List<Predicate> predicates = new ArrayList<>();

            // like

            // equal
           // predicates.add(criteriaBuilder.like(root.get("username"),"%" +  employeeRequest.getUserName()));
            predicates.add(criteriaBuilder.like(root.get("name"),"%" + employeeRequest.getName()));
          //  predicates.add(criteriaBuilder.like(root.get("address"),"%" +  employeeRequest.getAddress()));
            // AND all predicates
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            //return criteriaBuilder.between(root.get("grossdate"),startdate,enddate).;
        };
    }
   
   
   

   

    }
   

