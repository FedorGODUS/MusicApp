package Andersen.SeqDemo.repo;

import Andersen.SeqDemo.entities.Concert;
import org.springframework.data.repository.CrudRepository;

public interface ConcertRepository extends CrudRepository<Concert, Long> {
}
