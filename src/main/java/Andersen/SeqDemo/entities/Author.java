package Andersen.SeqDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
}
