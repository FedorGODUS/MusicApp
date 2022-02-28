package Andersen.SeqDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserSubscription {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;
}
