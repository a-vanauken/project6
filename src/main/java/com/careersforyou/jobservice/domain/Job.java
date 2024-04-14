package com.careersforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;

public record Job(
    @NotBlank(message = "A job id must be defined")
    String jobid,
    String title,
    String description,
    String companyname,
    String skill1,
    String skill2
) { }
