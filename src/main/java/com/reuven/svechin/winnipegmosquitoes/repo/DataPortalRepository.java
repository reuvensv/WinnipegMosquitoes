package com.reuven.svechin.winnipegmosquitoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;

import java.util.List;

/**
 * JPA repository to handle public data portal
 */
@Repository
public interface DataPortalRepository extends JpaRepository<DataPortal, Long> {
    /**
     * Get to get latest updated from public data portal. everything greater than provided id need to be received.
     * @param id - the highest id of record of a previous update
     * @return list of records.
     */
    List<DataPortal> findByIdGreaterThan(long id);
}
