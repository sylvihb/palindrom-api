package no.sba.palindromapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.sba.palindromapi.data.api.PersonDto;
import no.sba.palindromapi.model.Person;
import no.sba.palindromapi.repository.PersonRepository;
import no.sba.palindromapi.service.PersonService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/v1/")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @GetMapping("/personer")
    public List<Person> getAllPersoner() {
        return personRepository.findAll();
    }

    @PostMapping("/personer")
    public Person createPerson(@RequestBody PersonDto person) {
        Person newPerson = new Person(person.getFornavn(), person.getEtternavn());
        return personRepository.save(newPerson);
    }

    @GetMapping("/personer/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> ret = personRepository.findById(id);
        return ret.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/personer/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody PersonDto person) {
        Person ret = personRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Fant ikke person som skal oppdateres, brukerId = " + id + person.toString()));

        ret.setFornavn(person.getFornavn());
        ret.setEtternavn(person.getEtternavn());

        personRepository.save(ret);
        return ResponseEntity.ok(ret);
    }

    @DeleteMapping("/personer/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Person ret = personRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fant ikke person som skal slettes, brukerId = " + id));
        personRepository.delete(ret);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/personer/palindrom/{id}")
    public ResponseEntity<PersonDto> getPersonPalindromById(@PathVariable Long id) {
        Person ret = personRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Fikk ikke sjekket for palindrom, fant ikke person med brukerId " + id));

        PersonDto person =
            new PersonDto(ret.getFornavn(), personService.erPalindrom(ret.getFornavn()), ret.getEtternavn(),
                personService.erPalindrom(ret.getEtternavn()));

        return ResponseEntity.ok(person);
    }
}