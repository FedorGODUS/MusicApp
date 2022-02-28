package Andersen.SeqDemo.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Schema(description = "Объект для представления запроса на сохранение перевода")
@Table(name = "audios")
public class Audio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private byte[] audio;
}
