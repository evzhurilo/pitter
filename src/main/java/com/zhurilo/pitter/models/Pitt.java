package com.zhurilo.pitter.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "pitts")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Pitt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pitts", columnDefinition = "text")
    @NonNull
    private String pitt;

    @Column(name = "likes_quantity")
    private Integer likesQuantity;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;

}
