package com.heli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id" ,referencedColumnName = "user_id")
    private User user;

    //referencedColumnName -> Look Note

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type")
    private VoteType voteType;

    public enum VoteType {
        UPVOTE,
        DOWNVOTE
    }


}
