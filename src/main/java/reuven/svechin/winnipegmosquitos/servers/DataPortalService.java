package reuven.svechin.winnipegmosquitos.servers;

import reuven.svechin.winnipegmosquitos.dto.DataPortalDto;

import java.util.List;

public interface DataPortalService {
    List<DataPortalDto> fetchData();
}
