# Hotel

## Testowanie i jakość oprogramowania- projekt

## Temat projektu

### Testowanie systemu wynajmu pokoi


**Opis:**<br>
Aplikacja pozwala użytkownikom na przeglądanie dostępnych pokoi ogólnie w hotelu oraz w podanym terminie. W wypadku, gdy
użytkownik jest zalogowany, może zarezerwować interesujący go pokój na dany termin.<br>
W przypadku gdy zalogowany jest administrator, ma on dostęp do panelu administracyjnego, w którym może przeglądać
rezerwacje, pokoje oraz rodzaje pokoi. Ma również możliwość dodawania nowych rodzajów pokoi oraz pokoi.

* Strona główna
  ![Strona glówna](https://cdn.discordapp.com/attachments/912663225630343178/1186347137391415456/image.png?ex=6592eade&is=658075de&hm=cc33f7b60d383ea47f3a466554c7606374a22bbaf9d6e6dd9de7681fcb825d31&)
* Panel administratora
  ![Panel administratora](https://cdn.discordapp.com/attachments/912663225630343178/1186352201732456610/image.png?ex=6592ef96&is=65807a96&hm=0d995186b801e63d2d24f7ccc55ade03a185e9d207e38dbac41b03900ef99305&)

### Autorzy


| Imię i Nazwisko     | Index |
|---------------------|-------|
| Katarzyna Bączek    | 34270 |
| Wojciech Schabowski | 34324 |

## Uruchomienie Aplikacji


1. Sklonuj aplikacje:
    * backend: `git clone https://github.com/swojciech35/hotel.git `
    * frontend: `git clone https://github.com/swojciech35/hotel-frontend.git`
2. Utwórz nową bazę danych w PostgreSQL
3. Dodaj zmiene środowiskowe do aplikacji backendowej:
    * `spring.datasource.username`   - nazwa użytkownika bazy danych (np. `postgres`)
    * `spring.datasource.password`   - hasło użytkownika (np. `postgres`)
    * `spring.datasource.url`   - link do bazy danych (np. `jdbc:postgresql://localhost:5432/hotel`)
4. Uruchom aplikację backendową:
    * uruchom aplikację- plik HotelApplication
5. Uruchom aplikację frontendową:
    * `npm install`
    * `npm start`
6. Aplikacje będą domyslnie dostępne pod adresem:
    * frontend:`http://localhost:3000/`
    * backend:`http://localhost:8080/` (swagger dostępny pod adresem: `http://localhost:8080/swagger-ui/index.html#`)

## Uruchomienie testów

Do utuchomienia testów integracyjnych wymagany jest docker.

**Aby uruchomić wszystkie testy jednostkowe i integracyjne należy:**

1. Oznaczyć folder `test/groovy` i `test/java` jako `Test Sources Root`
2. Kliknąć PPM na folder groovy i wybrać opcję `Run 'Tests in 'groovy''`

## Scenariusze testowe dla testera manualnego

Zakładamy, że istnieje jeden typ pokoju z jednym pokojem.

| Test <br/>Case ID | Opis                                                                                                     | Kroki testowe                                                                                                                                                                                                  | Oczekiwany wynik                                                                                                                     |
|-------------------|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| TC_01             | Zarejestrowanie nowego uzytkownika.                                                                      | 1. Kliknij przycisk na stronie "Zarejestruj się".<br/>2. Wypełnij formularz rejestracji. <br/>3. Kliknij Przycisk 'Zarejestruj się'.                                                                           | Utworzenie nowego konta użytkownika                                                                                                  |
| TC_02             | Próba zarejestrowania nowego użytkownika na ten sam adres email.                                         | 1. Zarejestruj nowego użytkownika o adresie email: janek@email.com.<br/> 2.Zarejestruj kolejnego użytkownika o adresie email: janek@email.com.                                                                 | Konto o adresie email janek@email.com nie zostanie utworzone, użytkownik już istnieje.                                               |
| TC_03             | Próba zalogowania się na istniejącego w systemie użytkownika.                                            | 1. Kliknij przycisk 'Zaloguj się'.<br/>2. Wypełnij formularz poprawnymi danymi do logowania istniejącego użytkownika.<br/>3. Kliknij przycisk 'Zaloguj się'.                                                   | Użytkownik zostanie zalogowany na swój profil.                                                                                       |
| TC_04             | Próba zalogowania się na nieistniejącego użytkownika w systemie                                          | 1. Kliknij przycisk 'Zaloguj się'.<br/>2. Wypełnij formularz danymi do logowania nieistniejącego użytkownika.<br/>3. Kliknij przycisk 'Zaloguj się'.                                                           | Użytkownik nie zostanie zalogowany, użytkownik nie jest zarejestrowany w systemie.                                                   |
| TC_05             | Próba rezerwacji pokoju na dni 12.12.2023-14.12.2023 przez niezalogoawnego użytkownika.                  | 1. Wybierz pokój.<br/>2. Kliknij w przycisk 'zarezerwuj'.<br/>3. Wybierz zakres dni 12.12.2023-14.12.2023.<br/>4. Potwierdź rezerwacje przyciksiem 'zarezerwuj'                                                | Użytkownik nie jest w stanie zarezerwować pokoju na termin 12.12.2023-14.12.2023, brak uprawnień.                                    |
| TC_06             | Próba rezerwacji pokoju na dni 12.12.2023-14.12.2023 przez zalogowanego użytkownikowa.                   | 1.Zaloguj się jako uzytkownk.<br>2. Wybierz pokój.<br/>3. Kliknij w przycisk 'zarezerwuj'.<br/>4. Wybierz zakres 12.12.2023-14.12.2023.<br/>5. Potwierdź rezerwacje przyciksiem 'zarezerwuj pokój'             | Użytkownik rezerwuje pokój na termin 12.12.2023-14.12.2023, zalogowany użytkownik posiada uprawnienia do rezerwacji pokoju.          |
| TC_07             | Próba rezerwacji zajętego pokoju hotelowgo na dni 12.12.2023-14.12.2023  przez zalogowanego użytkownika. | 1.Zaloguj się jako uzytkownk.<br>2.Zarezerwuj pokój na okres 12.12.2023-14.12.2023.<br> 3. Zarezerwuj pokój ponownie na okres 12.12.2023-14.12.2023.<br>                                                       | Uzytkownik nie jest w stanie zarezerwować pokoju na termin 12.12.2023-14.12.2023, nie można zarezerwować zarezerwowanego już pokoju. |
| TC_08             | Dodanie nowego pokoju 309 przez Administratora.                                                          | 1.Zaloguj się jako administrator.<br>2. Kliknij w plusik  w panelu administracyjnym znajdujący się w tabelce 'Pokoje'.<br/>3. Wypełnij formularz wymaganymi danymi.<br/>4.kliknij przycisk 'dodaj pokój'       | Pokój zostanie dodany do hotelu.                                                                                                     |
| TC_09             | Dodanie nowego pokoju o tym samym numerze przez Administratora.                                          | 1.Zaloguj się jako administrator.<br>2. Kliknij w plusik  w panelu administracyjnym znajdujący się w tabelce 'Pokoje'.<br>3. Wypełnij formularz z numerem pokoju 309.<br>4. Dodaj kolejny pokój z numerem 309. | Wybrany pokój nie zostanie dodany ponownie, nie może być pokoi o tych samych numerach.                                               | 
| TC_10             | Dodanie nowego typu pokoju.- pokój 2-osobowy, 2-łóżka przez Administratora.                              | 1.Zaloguj się jako administrator.<br>2. Kliknij w plusik  w panelu administracyjnym znajdujący się w tabelce 'Rodzaje pokoi'.<br/>3.Wypełnij formularz 'pokój 2-osobowy, 2-łóżka'                              | Dodanie nowego typu pokoju - '2-osobowy 2-łóżka'.                                                                                    |

## Dokumentacja API


Dokumentacja api dostępna jest pod adresem `http://localhost:8080/swagger-ui/index.html#/` po uruchomieniu aplikacji.

## Użyte technologie

* Java 17
* Spring boot
* Spock
* Groovy
* PostgreSQL
* Liquibase
* SpringSecurity
* JWT
* Docker
* React
* Typescript