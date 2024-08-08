package com.heli.service;

import com.heli.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public int getVotes(int restaurantId) {

        String voteKey = "restaurant:" + restaurantId + ":votes";
        Integer votes = (Integer) redisTemplate.opsForValue().get(voteKey);

        if (votes == null) {
            votes = initializeVotes(restaurantId);
        }

        return votes;

    }

    @Override
    public void upvote(int restaurantId, int userId) {

        String voteKey = "restaurant:" + restaurantId + ":votes";
        String userVoteKey = "restaurant:" + restaurantId + ":user:" + userId;

        String currentVote = (String) redisTemplate.opsForValue().get(userVoteKey);

        if ("downvote".equals(currentVote)) {
            redisTemplate.opsForValue().increment(voteKey, 2);
        } else if (currentVote == null) {
            redisTemplate.opsForValue().increment(voteKey);
        }

        redisTemplate.opsForValue().set(userVoteKey, "upvote");

    }

    @Override
    public void downvote(int restaurantId, int userId) {

        String voteKey = "restaurant:" + restaurantId + ":votes";
        String userVoteKey = "restaurant:" + restaurantId + ":user:" + userId;

        String currentVote = (String) redisTemplate.opsForValue().get(userVoteKey);

        if ("upvote".equals(currentVote)) {
            redisTemplate.opsForValue().increment(voteKey, -2);
        } else if (currentVote == null) {
            redisTemplate.opsForValue().increment(voteKey, -1);
        }

        redisTemplate.opsForValue().set(userVoteKey, "downvote");

    }

    @Override
    public void syncVotesToDatabase() {

        Map<Object, Object> voteData = redisTemplate.opsForHash().entries("restaurant_votes");
        for (Map.Entry<Object, Object> entry : voteData.entrySet()) {
            String restaurantId = (String) entry.getKey();
            Integer votes = (Integer) entry.getValue();
            // Update the database with the current vote count
            voteRepository.updateVoteCount(restaurantId, votes);
        }

    }

    private int initializeVotes(int restaurantId) {

        // Fetch initial count from database
        int initialVotes = restaurantService.getVoteCountByRestaurantId(restaurantId);

        String voteKey = "restaurant:" + restaurantId + ":votes";
        redisTemplate.opsForValue().set(voteKey, initialVotes);

        return initialVotes;
    }


}
