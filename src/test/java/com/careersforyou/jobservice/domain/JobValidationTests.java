package com.careersforyou.jobservice.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import static org.assertj.core.api.Assertions.assertThat;


class JobValidationTests {
    private static Validator validator;

    @BeforeAll   // Set up the tests

    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test   // Run a test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var job = new Job("", "", "", "", "", "");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).isEmpty();
    }

    @Test   // Run a test
    void whenIsbnDefinedButIncorrectThenValidationsFails() {
        var job = new Job("", "", "", "", "", "");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The job format must be valid");

    }


}
