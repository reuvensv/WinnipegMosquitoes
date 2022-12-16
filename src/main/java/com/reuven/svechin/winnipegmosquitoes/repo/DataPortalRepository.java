package com.reuven.svechin.winnipegmosquitoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;

import java.util.List;

@Repository
public interface DataPortalRepository extends JpaRepository<DataPortal, Long> {
    List<DataPortal> findByIdGreaterThan(long id);
}
