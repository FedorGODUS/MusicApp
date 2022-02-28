package Andersen.SeqDemo.repo;

import Andersen.SeqDemo.entities.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findCityByCityName(String cityName);
}
