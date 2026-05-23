package com.tenzing.job_tracker;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface JobRepository extends CrudRepository<JobApplication, Long> {

    long countByStatus(String status);

    List<JobApplication> findAllByOrderByDateAppliedDesc();
    List<JobApplication> findByCompanyContainingIgnoreCase(String company);
}

