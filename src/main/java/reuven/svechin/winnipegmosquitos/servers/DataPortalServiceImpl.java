package reuven.svechin.winnipegmosquitos.servers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reuven.svechin.winnipegmosquitos.dto.DataPortal;
import reuven.svechin.winnipegmosquitos.repo.DataPortalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataPortalServiceImpl implements DataPortalService{
    private final DataPortalRepository dataPortalRepository;

    public List<DataPortal> fetchDataGreaterThanId(long id) {
        return dataPortalRepository.findByIdGreaterThan(id);
        
    }
}
