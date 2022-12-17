package com.reuven.svechin.winnipegmosquitoes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;
import com.reuven.svechin.winnipegmosquitoes.repo.DataPortalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataPortalServiceImpl implements DataPortalService{
    private final DataPortalRepository dataPortalRepository;

    /**
     * {@link DataPortalService#fetchDataGreaterThanId(long)}
     */
    public List<DataPortal> fetchDataGreaterThanId(long id) {
        return dataPortalRepository.findByIdGreaterThan(id);
        
    }

}
