package reuven.svechin.winnipegmosquitos.servers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reuven.svechin.winnipegmosquitos.dto.DataPortalDto;
import reuven.svechin.winnipegmosquitos.repo.DataPortalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataPortalServiceImpl {
    private final DataPortalRepository dataPortalRepository;

    public List<DataPortalDto> fetchData() {
        return dataPortalRepository.findAll();

    }
}
