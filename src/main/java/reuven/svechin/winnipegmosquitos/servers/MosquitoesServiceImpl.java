package reuven.svechin.winnipegmosquitos.servers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reuven.svechin.winnipegmosquitos.dto.Mosquito;
import reuven.svechin.winnipegmosquitos.repo.MosquitoesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MosquitoesServiceImpl implements MosquitoesService{
    private final MosquitoesRepository mosquitoesRepository;

    
    public List<Mosquito> saveAll(List<Mosquito> mosquitoesData) {
        return mosquitoesRepository.saveAll(mosquitoesData);
    }
    
}
