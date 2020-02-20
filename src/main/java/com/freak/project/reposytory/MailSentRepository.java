package com.freak.project.reposytory;

import com.freak.project.statistic.AllUsersCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MailSentRepository extends CrudRepository<AllUsersCount, Long> {
}
