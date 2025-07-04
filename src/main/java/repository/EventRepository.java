package repository;

import Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findTop10ByOrderByTijdstipDesc();
    List<Event> findByLocatieId(Long locatieId);
    List<Event> findById(String id);
}
