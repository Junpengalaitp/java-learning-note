package com.junpenghe.design.pattern.creational.combinator;

import java.time.LocalDate;

import static com.junpenghe.design.pattern.creational.combinator.CustomerRegistrationValidator.*;

/**
 * @author Junpeng He
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2000, 1, 1)
        );

        CustomerValidatorService validatorService = new CustomerValidatorService();
        validatorService.isValid(customer);
        System.out.println(new CustomerValidatorService().isValid(customer));

        CustomerRegistrationValidator.ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

    }


}
