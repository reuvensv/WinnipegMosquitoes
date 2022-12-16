package com.reuven.svechin.winnipegmosquitoes.servers;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;

import java.sql.Timestamp;
import java.util.List;

public interface MosquitoesService {
    List<Mosquito> saveAll(List<Mosquito> mosquitoesData) ;
    List<Mosquito> getData(Timestamp startDate, Timestamp endDate, List<Sectors> sectors);
}
