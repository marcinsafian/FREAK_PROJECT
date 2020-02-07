package com.freak.project.reposytory;

import com.freak.project.statistic.RegistrationLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface LogRepository extends CrudRepository<RegistrationLog, Long> {}
