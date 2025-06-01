package service;

import Model.Event;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.LocatieRepository;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final LocatieRepository locatieRepository;

    public EventService(EventRepository eventRepository, LocatieRepository locatieRepository) {
        this.eventRepository = eventRepository;
        this.locatieRepository = locatieRepository;
    }

    public Event saveEvent(Event event) {
        if (event.getLocatie() == null || event.getLocatie().getId() == null) {
            throw new IllegalArgumentException("Locatie is verplicht");
        }
        return eventRepository.save(event);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public List<Event> getRecentEvents() {
        return eventRepository.findTop10ByOrderByTijdstipDesc();
    }

    public List<Event> findById(String id) {
        return eventRepository.findById(id);
    }
}
