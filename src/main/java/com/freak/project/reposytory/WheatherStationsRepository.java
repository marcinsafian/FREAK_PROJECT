package com.freak.project.reposytory;

import com.freak.project.domain.WheatherStations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WheatherStationsRepository extends CrudRepository<WheatherStations, String> {
}