package com.reuven.svechin.winnipegmosquitoes.repo;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;

import java.sql.Timestamp;
import java.util.List;

/**
 * JPA repository to handle local data
 */
@Repository
public interface MosquitoesRepository extends JpaRepository<Mosquito, Long> {
    /**
     * The method is to  get data by range of dates and list of sectors.
     * @param startDate requested start date
     * @param endDate requested end data
     * @param sectors list of requested sectors
     * @return list of records from mosquitoes table.
     */
    List<Mosquito> findByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualAndSectorIn(Timestamp startDate, Timestamp endDate, List<Sectors> sectors);
}
