package com.heli.controller;

import com.heli.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/count")
    public int getVotes(@RequestParam int restaurantId) {
        return voteService.getVotes(restaurantId);
    }

    @PostMapping("/upvote")
    public void upvote(@RequestParam int restaurantId, @RequestParam int userId) {
        voteService.upvote(restaurantId, userId);
    }

    @PostMapping("/downvote")
    public void downvote(@RequestParam int restaurantId, @RequestParam int userId) {
        voteService.downvote(restaurantId, userId);
    }

}
