Eksamen PGR112 – Objektorientert programmering (V2024)

Introduksjon

Dette prosjektet er en eksamensbesvarelse i emnet Objektorientert programmering (PGR112).

Caset tar utgangspunkt i hobbyarkeologer som registrerer funn av historiske gjenstander. Informasjonen finnes i en tekstfil (funn.txt) og skal leses inn, struktureres og lagres i en database. Programmet tilbyr deretter funksjonalitet for å hente ut og vise informasjon basert på databasen.

Prosjektet demonstrerer bruk av arv, innkapsling, unntakshåndtering, JDBC, filhåndtering og objektrelasjonell modellering.

---
 
Oppgavestruktur

Del 1 – Importere data til database

-	Lese data fra funn.txt.
-	Strukturere dataene i Java-klasser (Person, Museum, Historiske objekter).
-	Importere dataene til en MySQL-database basert på tabelloppsettet i funn.sql.
-	Håndtere unntak under lesing og lagring.

Del 2 – Bruke databasen

Et menybasert program (Main/Main2) gir brukeren følgende funksjonalitet:
-	Se informasjon om alle funn.
-	Filtrere funn basert på årstall.
-	Vise antall registrerte funn.
-	Avslutte programmet.

---
 
Gjennomgang av klasser

DatabaseManager / DatabaseManager2

-	Ansvar: Opprette tilkobling til databasen, utføre spørringer og håndtere SQL-operasjoner.
-	Bruker unntakshåndtering (SQLException) for å fange opp feil som oppstår ved databaseoperasjoner.
-	Lærerpunkt: Hvordan bruke JDBC og unntakshåndtering for robust databasekommunikasjon.

HistoricalObject + subklasser (Mynt2, Vaapen2, Smykke2)

-	HistoricalObject fungerer som superklasse med felles egenskaper som id, funnsted, finnerId, funntidspunkt, antattÅrstall og museumId.
-	Subklassene legger til spesialiserte felt:
1. Mynt2: diameter, metall
2.	Vaapen2: type, materiale, vekt
3.	Smykke2: type, verdiestimat, bilde
-	Bruker arv og polymorfi for å strukturere kode gjenbrukbart.

Person

-	Representerer en person med id, navn, telefon, epost.
-	Bruker private instansvariabler med gettere og settere → eksempel på innkapsling.

Museum

-	Representerer et museum med id, navn, sted.
-	Kobles mot funn via museumId.

Funn

-	Holder data om funn og kobler sammen person, museum og gjenstand.
-	Viser hvordan sammensatte data kan struktureres i objektorientert kode.

Main / Main2

-	Inneholder hovedprogram og menylogikk.
-	Leser inn data fra funn.txt og setter opp databasen (Del 1).
-	Tilbyr menyvalg for brukeren (Del 2).
-	Bruker FileNotFoundException og NumberFormatException for å fange opp feil.
 
Database

-	SQL-strukturen er definert i funn.sql.
-	Database og tabeller:
1.	Person
2.	Museum
3.	Mynt
4.	Smykke
5.	Våpen
-	Filen discovery.properties brukes for tilkoblingsinformasjon.

 ---
 
Læringsutbytte

Gjennom prosjektet har jeg fått praktisk erfaring med:

-	Arv og polymorfi – strukturering av felles og spesifikke egenskaper i klasser.
-	Innkapsling – sikring av interne data med private felt og kontrollert tilgang via gettere/settere.
-	Unntakshåndtering – bruk av SQLException, FileNotFoundException, NumberFormatException for å gjøre programmet robust.
-	JDBC – koble Java-programmer mot en MySQL-database.
-	Filhåndtering – parsing og strukturering av rådata fra tekstfil.
-	Kopling og samhørighet – designvalg som gir bedre kodekvalitet.

 ---
 
Teknologier brukt

-	Java
-	MySQL (via JDBC)
-	IntelliJ IDEA
-	Properties-fil for konfigurasjon

---
 
Hvordan kjøre prosjektet

1.	Opprett databasen med funn.sql i MySQL.
2.	Juster discovery.properties med riktige innloggingsdetaljer.
3.	Kjør Main.java for å importere data fra funn.txt.
4.	Kjør Main2.java for å starte menyprogrammet.

 ---
 
Refleksjon

Arbeidet med prosjektet ga verdifull innsikt i hvordan man kombinerer objektorientert programmering, databaseintegrasjon og filbehandling. Selv om jeg støtte på utfordringer underveis (f.eks. dupliserte database-innslag og parsing av tekstfilen), opplever jeg at prosjektet demonstrerer solid forståelse av kjernetemaene i objektorientert programmering og praktisk bruk av Java i en helhetlig applikasjon.

---

Kontakt

Har du spørsmål, eller er du en rekrutterer som vil vite mer? Ta gjerne kontakt via GitHub eller LinkedIn-profilen min - www.linkedin.com/in/anders-myhrvang-9a6629339.
