package reuven.svechin.winnipegmosquitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reuven.svechin.winnipegmosquitos.dto.DataPortalDto;

@Repository
public interface DataPortalRepository extends JpaRepository<DataPortalDto, Long> {

}
