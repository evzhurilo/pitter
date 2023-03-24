package com.zhurilo.pitter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "pitts")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pitt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pitts", columnDefinition = "text")
    @NonNull
    public String pitt;

    @Column(name = "likes_quantity")
    private Integer likesQuantity;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;

}
