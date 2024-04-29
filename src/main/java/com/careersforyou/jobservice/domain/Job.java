package com.careersforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import java.time.Instant;

public record Job(
        @Id
        Long id,
        @NotBlank(message = "A job id must be defined")
        String jobid,
        String title,
        String description,
        String companyname,
        String skill1,
        String skill2,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
         int version
) {
    public static Job of (String jobid, String title, String description, String companyname, String skill1, String skill2) {
        return new Job (null, jobid, title, description, companyname, skill1, skill2, null, null, 0);
    }
}


