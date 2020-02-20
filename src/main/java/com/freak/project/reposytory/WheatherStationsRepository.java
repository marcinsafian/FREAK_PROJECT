package com.freak.project.reposytory;

import com.freak.project.domain.Stations;
import com.freak.project.domain.WheatherStations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface WheatherStationsRepository extends CrudRepository<WheatherStations, String> {


    Optional<WheatherStations> save(Stations stations);
    List<WheatherStations> save(List<WheatherStations> stations);

    Optional<Object> findById(WheatherStations stationsId);
}
