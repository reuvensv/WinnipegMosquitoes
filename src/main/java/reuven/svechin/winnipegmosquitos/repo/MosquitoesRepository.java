package reuven.svechin.winnipegmosquitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reuven.svechin.winnipegmosquitos.dto.Mosquito;

@Repository
public interface MosquitoesRepository extends JpaRepository<Mosquito, Long> {

}
