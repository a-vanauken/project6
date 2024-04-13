package com.careersforyou.jobservice.domain;

public record Job(
    String jobid,
    String title,
    String description,
    String companyname,
    String skill1,
    String skill2
) { }
