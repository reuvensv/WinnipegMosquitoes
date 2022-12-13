package reuven.svechin.winnipegmosquitos.servers;

import reuven.svechin.winnipegmosquitos.dto.DataPortal;

import java.util.List;

public interface DataPortalService {
    List<DataPortal>  fetchDataGreaterThanId(long id);
}
