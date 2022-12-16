package com.reuven.svechin.winnipegmosquitoes.servers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;
import com.reuven.svechin.winnipegmosquitoes.repo.DataPortalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataPortalServiceImpl implements DataPortalService{
    private final DataPortalRepository dataPortalRepository;

    public List<DataPortal> fetchDataGreaterThanId(long id) {
        return dataPortalRepository.findByIdGreaterThan(id);
        
    }
}
