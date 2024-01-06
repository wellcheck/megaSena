package br.com.mega.virada.repository;

import br.com.mega.virada.model.MegaResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MegaResultRepository extends JpaRepository<MegaResult, Long> {


}
