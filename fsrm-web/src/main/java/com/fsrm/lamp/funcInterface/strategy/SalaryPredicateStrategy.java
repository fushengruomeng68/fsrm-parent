package com.fsrm.lamp.funcInterface.strategy;

import com.fsrm.lamp.funcInterface.Employee;
import com.fsrm.lamp.funcInterface.MyPredicate;

/**
 * @desc SalaryPredicateStrategy
 * @Author xw
 * @Date 2019/9/9
 */
public class SalaryPredicateStrategy implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
