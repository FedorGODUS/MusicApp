package Andersen.SeqDemo.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    @OneToOne
    @JoinColumn(name = "current_user_subscription_id", referencedColumnName = "id")
    private UserSubscription currentUserSubscriptionId;
    @OneToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Author author;
}
