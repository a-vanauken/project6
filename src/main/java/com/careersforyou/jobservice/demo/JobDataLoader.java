package com.careersforyou.jobservice.demo;

import com.careersforyou.jobservice.domain.Job;
import com.careersforyou.jobservice.domain.JobRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test data")

public class JobDataLoader {

    private final JobRepository jobRepository;

    public JobDataLoader(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadJobTestData() {
        jobRepository.deleteAll();
        var job1 = Job.of("00001", "Spring Boot Developer", "Java developer with spring boot experience", "ACC","Java", "Spring Boot");
        var job2 = Job.of("00002", "Python Developer", "Python developer, entry level", "ACC", "Python", "Java");
        jobRepository.saveAll(List.of(job1,job2));
        //jobRepository.save(job1);
        //jobRepository.save(job2);
    }



}
