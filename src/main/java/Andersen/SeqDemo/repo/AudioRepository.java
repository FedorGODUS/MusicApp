package Andersen.SeqDemo.repo;

import Andersen.SeqDemo.entities.Audio;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AudioRepository extends CrudRepository<Audio, Long> {
    Optional<Audio> findAudioByTitle(String title);
}
