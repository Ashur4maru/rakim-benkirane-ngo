package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;
    private String titel;
    private String omschrijving;
    private LocalDateTime tijdstip;
    private String organisatie;
    @Email
    private String mailContactPersoon;

    @ManyToOne
    @JoinColumn(name = "locatie_id", nullable = false)
    private Locatie locatie;

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public @Email String getMailContactPersoon() {
        return mailContactPersoon;
    }

    public void setMailContactPersoon(@Email String mailCantactPersoon) {
        this.mailContactPersoon = mailCantactPersoon;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }
}
