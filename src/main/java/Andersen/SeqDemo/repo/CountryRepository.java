package Andersen.SeqDemo.repo;

import Andersen.SeqDemo.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findCountryByCountryName(String countryName);
}
