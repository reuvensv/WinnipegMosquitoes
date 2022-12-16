package com.reuven.svechin.winnipegmosquitoes.servers;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.repo.MosquitoesRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MosquitoesServiceImpl implements MosquitoesService{
    private final MosquitoesRepository mosquitoesRepository;

    
    public List<Mosquito> saveAll(List<Mosquito> mosquitoesData) {
        return mosquitoesRepository.saveAll(mosquitoesData);
    }
    
    @Override
    public List<Mosquito> findByCreatedAtGreaterThanEqualAndLessThanEqualAndSectorIn(Timestamp startDate, Timestamp endDate, List<Sectors> sectors) {
        return mosquitoesRepository.findByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualAndSectorIn(startDate,endDate, sectors);
    }
    
}
