## Curl

Opprett person

`curl --location --request POST 'http://localhost:8080/api/v1/personer/' \
--header 'Content-Type: application/json' \
--data-raw '{"brukerId": null, "fornavn": "Hannah", "etternavn": "Nordmann"}'`

Hent person

`curl --location --request GET 'http://localhost:8080/api/v1/personer/1' \
--header 'Cookie: JSESSIONID=4DB90359162ECB8639DF8814C7C5932A'`

Oppdater person

`curl --location --request PUT 'http://localhost:8080/api/v1/personer/1' \
--header 'Content-Type: application/json' \
--data-raw '{"brukerId": null, "fornavn": "Ola", "etternavn": "Nordmannen"}'`

Slett person

`curl --location --request DELETE 'http://localhost:8080/api/v1/personer/1'`

Hent alle

`curl --location --request GET 'http://localhost:8080/api/v1/personer/'`

Sjekk for palindrom

`curl --location --request GET 'http://localhost:8080/api/v1/personer/palindrom/1' \
--data-raw ''`