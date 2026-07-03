# Individuell Labb 1k5 – AI-integration

## Beskrivning

Detta projekt är en Spring Boot-applikation som integrerar med OpenAI:s API. Applikationen tar emot en fråga från användaren, skickar den till OpenAI och returnerar AI:ns svar.

Projektet är utvecklat som en del av kursens individuella laboration om AI-integration.

---

## Funktioner

- Integrering med OpenAI via HTTP API
- Säker hantering av API-nyckel genom miljövariabel
- REST-endpoint för att skicka frågor till AI
- Returnerar ett läsbart svar från AI
- Byggt med Spring Boot och Java 21

---

## Tekniker

- Java 21
- Spring Boot
- Maven
- RestClient
- OpenAI Responses API

---

## Projektstruktur

```
src
├── main
│   ├── java
│   │   └── org.example.individuell_labb_2k5markusnikolic
│   │       ├── controller
│   │       │   └── AiController.java
│   │       ├── service
│   │       │   └── AiClientService.java
│   │       └── IndividuellLabb1k5MarkusNikolicApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── IndividuellLabb1k5MarkusNikolicApplicationTests.java
```

---

## Installation

### Klona projektet

```bash
git clone <repository-url>
```

### Öppna projektet

Öppna projektet i IntelliJ IDEA.

### Miljövariabel

Skapa en miljövariabel med namnet:

```
OPENAI_API_KEY
```

och sätt värdet till din OpenAI API-nyckel.

Exempel:

```
OPENAI_API_KEY=sk-proj-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

---

## application.properties

```properties
spring.application.name=Individuell_Labb_1k5-Markus-Nikolic
openai.api.key=${OPENAI_API_KEY}
server.port=8081
```

---

## Starta projektet

Kör huvudklassen:

```
IndividuellLabb1k5MarkusNikolicApplication
```

Applikationen startar på:

```
http://localhost:8081
```

---

## API

### GET /ask

Skickar en fråga till OpenAI.

### Exempel

```
GET http://localhost:8081/ask?prompt=Vad är Java?
```

### Exempel på svar

```
Java är ett högnivåprogrammeringsspråk som används för att utveckla applikationer och system...
```

---

## Testning

Projektet har testats genom:

- Webbläsare
- Postman
- Maven (`mvn clean install`)

Exempel i Postman:

```
GET http://localhost:8081/ask?prompt=Berätta en rolig fakta
```

---

## Säkerhet

API-nyckeln lagras inte i projektet.

Applikationen hämtar istället nyckeln från miljövariabeln:

```
OPENAI_API_KEY
```

Om API-nyckeln saknas startar inte applikationen.

---

## Författare

**Markus Nikolic**