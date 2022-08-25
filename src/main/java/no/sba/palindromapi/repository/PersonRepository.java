package no.sba.palindromapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.sba.palindromapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
}
