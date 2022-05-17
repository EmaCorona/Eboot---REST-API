package it.corona.eboot.repository;

import it.corona.eboot.model.CareIstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareIstructionRepository extends JpaRepository<CareIstruction, Integer> {
}