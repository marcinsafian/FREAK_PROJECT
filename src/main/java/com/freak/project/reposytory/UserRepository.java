package com.freak.project.reposytory;

import com.freak.project.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUserName (String userName);

    @Override
    Optional<User> findById(Long id);
}
