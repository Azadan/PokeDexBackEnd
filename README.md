# PokeDex Backend
Projektet är byggt som en del av utbildningen på IT-Högskolan.

## Om Projektet
Detta är ett REST API som fungerar som backend för en frontend applikation. API:et hanterar lagring och hantering av fångade Pokémon.

Frontend-applikationen finns här: (https://github.com/Azadan/PokeFrontEnd)

## Funktioner
- Spara nya Pokémon i databasen
- Hämta alla sparade Pokémon
- Hämta specifik Pokémon via ID
- Uppdatera kommentarer för sparade Pokémon
- Ta bort Pokémon från databasen

## API Endpoints
- `GET /api/pokedex` - Hämta alla Pokémon
- `GET /api/pokedex/{id}` - Hämta specifik Pokémon
- `POST /api/pokedex/add` - Lägg till ny Pokémon
- `PUT /api/pokedex/{id}/comments` - Uppdatera Pokémon-kommentar
- `DELETE /api/pokedex/{id}` - Ta bort Pokémon

## Tech Stack
- Java
- Spring Boot
- MySQL
- JPA/Hibernate
- Maven
