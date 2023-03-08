package com.microservices.micro.models;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "role_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleUser {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
     User user;

    @ManyToOne
    @JoinColumn(name="role_id")
     Role role;

    private UserStatus status=UserStatus.Active;

}
