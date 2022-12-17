package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;

import java.util.List;

/**
 * Data portal service
 */
public interface DataPortalService {

    /**
     * Fetch data from public data portal that greater than the provided Id.
     * @param id Given id
     * @return list of records from public data portal
     */
    List<DataPortal>  fetchDataGreaterThanId(long id);
}
