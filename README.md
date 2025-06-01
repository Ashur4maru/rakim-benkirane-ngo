Anderlechtse NGO Website (<Rakim.Benkirane>)
Beschrijving
Dit is een Spring Boot-applicatie ontwikkeld voor een Anderlechtse ngo die zich inzet voor gemeenschapsvorming en ondersteuning van mensen in nood. De webapplicatie biedt een overzicht van evenementen, een formulier om nieuwe evenementen toe te voegen, een detailweergave per evenement, en een statische pagina met informatie over de ngo. De applicatie is gebouwd met Spring Boot, Thymeleaf, Spring Data JPA, en een H2 in-memory database, met Tailwind CSS voor styling.
Functionaliteiten

Index: Toont een tabel met de 10 meest recente evenementen (titel, organisatie, en een detailknop). Bevat een knop om een nieuw evenement toe te voegen.
New: Formulier om een nieuw evenement aan te maken, met validatie van alle velden (inclusief een geldig e-mailadres en een verplichte locatie). Bij succes wordt de gebruiker teruggeleid naar de Index-pagina; bij fouten wordt het formulier opnieuw getoond met foutmeldingen.
Details: Toont alle details van een specifiek evenement (tijdstip, titel, omschrijving, organisatie, e-mail contactpersoon, en locatie: naam, adres, capaciteit). Bereikbaar via de detailknop in de Index-tabel.
About: Statische pagina met fictieve informatie over de ngo (adres, contactgegevens, en een Lorem Ipsum-beschrijving).
Menu en Footer: Elke pagina heeft een consistent navigatiemenu (met links naar Index, New, en About) en een footer met copyright (© 2025 Anderlechtse NGO).

Gegevensmodel

Evenement:
id: Unieke ID (autoincrement).
tijdstip: Datum en tijd (LocalDateTime).
titel: Korte naam van het evenement.
omschrijving: Beschrijving van het evenement.
organisatie: Eigen beheer of partnernaam.
mailContactpersoon: Geldig e-mailadres.
locatie: Verwijzing naar een locatieobject (many-to-one).


Locatie:
id: Unieke ID (autoincrement).
naam: Naam van de locatie.
adres: Volledig adres.
capaciteit: Maximum aantal personen.



Gebruikte Frameworks en Tools

Spring Boot: Versie 3.x, voor backend en MVC-functionaliteit.
Spring Data JPA: Voor database-interactie met entiteiten en repositories.
H2 Database: In-memory database voor prototyping.
Thymeleaf: Voor server-side rendering van HTML-sjablonen.
Tailwind CSS: Voor responsieve en consistente styling (via CDN).
Maven: Voor dependency management en build-processen.
Java: Versie 17 of hoger.

Projectstructuur
<Rakim.Benkirane>/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.<voornaam>.<achternaam>.ngo/
│   │   │       ├── model/           # Event, Location entiteiten
│   │   │       ├── repository/      # JPA repositories
│   │   │       ├── service/         # EventService
│   │   │       ├── controller/      # EventController
│   │   │       └── Application.java # Hoofd Spring Boot-applicatie
│   │   ├── resources/
│   │   │   ├── templates/          # Thymeleaf HTML-sjablonen
│   │   │   │   ├── index.html      # Index pagina
│   │   │   │   ├── new.html        # Formulier voor nieuw evenement
│   │   │   │   ├── details.html    # Evenementdetails
│   │   │   │   ├── about.html      # Over de ngo
│   │   │   │   └── fragments/      # Herbruikbare fragmenten
│   │   │   │       ├── menu.html   # Navigatiemenu
│   │   │   │       └── footer.html # Footer
│   │   │   ├── static/             # Statische bestanden (CSS, JS)
│   │   │   └── application.properties # Configuratie (H2, Thymeleaf)
│   └── test/                       # Unit- en integratietests
├── README.md                       # Deze documentatie
├── pom.xml                         # Maven configuratie
├── docs/
│   └── grok_chat_history.txt       # AI-chatgeschiedenis
└── .gitignore                      # Git ignore

Deployment Instructies

Vereisten:

Java 17 of hoger.
Maven 3.6 of hoger.
Git (voor het clonen van de repository).


Stappen:

Clone de repository: git clone <repository-url>.
Navigeer naar de projectmap: cd <voornaam.achternaam>.
Bouw het project: mvn clean install.
Start de applicatie: mvn spring-boot:run.
Open de applicatie in een browser: http://localhost:8080.
(Optioneel) Toegang tot de H2-console: http://localhost:8080/h2-console (gebruik JDBC URL: jdbc:h2:mem:ngo).


Configuratie:

De H2 in-memory database wordt automatisch geïnitialiseerd.
Enkele voorbeeldlocaties worden geladen via src/main/resources/data.sql.
Thymeleaf-cache is uitgeschakeld voor ontwikkeling (spring.thymeleaf.cache=false in application.properties).



Gebruikte Bronnen
Tutorials

Spring Boot: Officiële Spring Boot Getting Started Guide (https://spring.io/guides/gs/spring-boot/).
Thymeleaf: Thymeleaf Tutorial (https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html).
Spring Data JPA: Spring Data JPA Reference (https://spring.io/guides/gs/accessing-data-jpa/).
Tailwind CSS: Officiële documentatie (https://tailwindcss.com/docs/installation).

Documentatie

Spring Boot: https://docs.spring.io/spring-boot/docs/current/reference/html/
Spring Data JPA: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
H2 Database: http://www.h2database.com/html/main.html
Thymeleaf: https://www.thymeleaf.org/documentation.html
Tailwind CSS: https://tailwindcss.com/docs

AI-tools

Grok (xAI): Gebruikt voor het opstellen van de projectstructuur, codevoorbeelden, en richtlijnen. De chatgeschiedenis kan je terug vinden via deze link: https://grok.com/share/bGVnYWN5_8d37b5c2-127b-440e-b1c9-d0a111582e9b

Implementatiedetails

Backend:
Gebruik van Spring Data JPA voor CRUD-operaties op Event en Location entiteiten.
Een many-to-one relatie tussen Event en Location wordt beheerd via @ManyToOne en @JoinColumn(name = "locatie_id").
Formuliervalidatie is geïmplementeerd met Spring Validation (@Valid, @Email) en aanvullende server-side checks (e-mail regex).


Frontend:
Thymeleaf-sjablonen in src/main/resources/templates/ (index.html, new.html, details.html, about.html).
Herbruikbare fragmenten (menu.html, footer.html) in src/main/resources/templates/fragments/.
Tailwind CSS wordt via CDN geladen voor responsieve styling.


Database:
H2 in-memory database voor prototyping.
Vooraf gedefinieerde locaties worden geladen via data.sql (bijv. "Gemeenschapscentrum, Hoofdstraat 123, capaciteit: 50").


Validatie:
Alle velden in het New-formulier zijn verplicht.
E-mailadressen worden gevalideerd met @Email en een regex (^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$).



Opmerkingen

De applicatie is ontworpen als een prototype met een in-memory database (H2). Voor productie kan PostgreSQL worden geconfigureerd via application.properties.
De styling is minimaal maar responsief, dankzij Tailwind CSS.
De Details-pagina is alleen bereikbaar via de detailknop in de Index-tabel, zoals gespecificeerd.
Voor extra functionaliteit (bijv. zoeken of filteren van evenementen) kan de applicatie worden uitgebreid.

Contact
Voor vragen of feedback, contacteer <voornaam.achternaam>@email.com.
