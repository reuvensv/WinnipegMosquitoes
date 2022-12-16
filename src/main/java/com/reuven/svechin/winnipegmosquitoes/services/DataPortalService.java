package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;

import java.util.List;

public interface DataPortalService {
    List<DataPortal>  fetchDataGreaterThanId(long id);
}
