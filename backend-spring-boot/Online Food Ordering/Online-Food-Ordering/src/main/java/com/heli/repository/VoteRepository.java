package com.heli.repository;

import com.heli.model.Vote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.vote = :voteCount WHERE r.id = :restaurantId")
    void updateVoteCount(String restaurantId, int voteCount);
}
