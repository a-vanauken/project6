package com.careersforyou.jobservice.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JobRepository extends CrudRepository <Job, Long> {
    //Iterable<Job> findAll();
    Optional<Job> findByJobid(String jobid);
    boolean existsByJobid(String jobid);
    //Job save(Job job);

    @Modifying
    @Transactional
    @Query("DELETE FROM Job WHERE jobid = :jobid")
    void deleteByJobid(String jobid);

}
