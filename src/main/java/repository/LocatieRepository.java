package repository;

import Model.Locatie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatieRepository extends JpaRepository<Locatie, Long> {
}
