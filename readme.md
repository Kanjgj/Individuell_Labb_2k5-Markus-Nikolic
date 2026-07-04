# Individuell Labb 2k5 – DevOps, CI/CD & Applikationssäkerhet

## Beskrivning

Detta projekt är en Spring Boot-applikation som kommunicerar med OpenAI:s API. Användaren kan skicka en fråga via en REST-endpoint och få ett AI-genererat svar tillbaka.

Projektet bygger vidare på Labb 1 och har utökats med containerisering, Continuous Integration (CI) samt grundläggande säkerhetsåtgärder.

---

## Funktioner

- Spring Boot REST API
- Kommunikation med OpenAI Responses API
- Docker-containerisering
- GitHub Actions (Continuous Integration)
- HTTP Basic Authentication med Spring Security
- Säker hantering av API-nyckel via miljövariabler

---

## Teknologier

- Java 21
- Spring Boot
- Maven
- Docker
- GitHub Actions
- Spring Security

---

## Installation

### Klona projektet

```bash
git clone <repository-url>
```

### Bygg projektet

```bash
./mvnw clean package
```

eller på Windows

```cmd
mvnw.cmd clean package
```

---

## Köra lokalt

Sätt miljövariabeln:

Windows PowerShell

```powershell
$env:OPENAI_API_KEY="DIN_API_NYCKEL"
```

Starta sedan applikationen.

---

## Köra med Docker

### Bygg imagen

```bash
docker build -t individuell-labb-2k5 .
```

### Starta containern

```bash
docker run -p 8081:8081 -e OPENAI_API_KEY="DIN_API_NYCKEL" individuell-labb-2k5
```

---

## API

### GET /ask

Exempel:

```
GET /ask?prompt=Hej
```

Denna endpoint kräver autentisering.

### Inloggningsuppgifter

```
Användarnamn: admin
Lösenord: password
```

---

## Continuous Integration

Projektet använder GitHub Actions.

Vid varje push eller pull request till `master` sker följande automatiskt:

- Projektet byggs
- Java 21 installeras
- Maven-tester körs

Om testerna lyckas markeras körningen med en grön status i GitHub Actions.

---

## Säkerhet

Följande säkerhetsåtgärder har implementerats:

- OpenAI API-nyckeln lagras som en miljövariabel (`OPENAI_API_KEY`) och är inte hårdkodad i projektet.
- REST-endpointen `/ask` är skyddad med Spring Security och HTTP Basic Authentication.
- Applikationen kontrollerar att en giltig API-nyckel finns innan den startar.

---

## Projektstruktur

```
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── security
│   │   ├── service
│   │   └── IndividuellLabb2k5MarkusNikolicApplication
│   └── resources
│       └── application.properties
│
└── test
    └── java
```

---

## Författare

Markus Nikolic

Kurs: Individuell Labb 2k5 – DevOps, CI/CD & Applikationssäkerhet