package Andersen.SeqDemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Subscription {
    @Id
    private Long id;
    private String name;
    private String price;
    private String description;
}
