package reuven.svechin.winnipegmosquitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reuven.svechin.winnipegmosquitos.dto.DataPortal;

import java.util.List;

@Repository
public interface DataPortalRepository extends JpaRepository<DataPortal, Long> {
    List<DataPortal> findByIdGreaterThan(long id);
}
