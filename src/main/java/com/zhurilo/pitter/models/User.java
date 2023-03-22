package com.zhurilo.pitter.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "Date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Pitt> pittList = new ArrayList<>();
    private Long previewPitt;
    private LocalDateTime dateOfCreation;

    @PrePersist
    private void init() {
        dateOfCreation = LocalDateTime.now();
    }

    public void addPittToList(Pitt pitt) {
        pitt.setUser(this);
        pittList.add(pitt);
    }
}

