package com.reuven.svechin.winnipegmosquitoes.repo;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MosquitoesRepository extends JpaRepository<Mosquito, Long> {
    List<Mosquito> findByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualAndSectorIn(Timestamp startDate, Timestamp endDate, List<Sectors> sectors);
}
