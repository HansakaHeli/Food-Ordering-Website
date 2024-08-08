package com.heli.scheduler;

import com.heli.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VoteSyncScheduler {

    @Autowired
    private VoteService voteService;

    @Scheduled(fixedRate = 60000) // Sync every minute
    public void syncVotes() {
        voteService.syncVotesToDatabase();
    }
}
