package reuven.svechin.winnipegmosquitos.servers;

import reuven.svechin.winnipegmosquitos.dto.Mosquito;
import reuven.svechin.winnipegmosquitos.repo.MosquitoesRepository;

import java.util.List;

public interface MosquitoesService {
    List<Mosquito> saveAll(List<Mosquito> mosquitoesData) ;
}
