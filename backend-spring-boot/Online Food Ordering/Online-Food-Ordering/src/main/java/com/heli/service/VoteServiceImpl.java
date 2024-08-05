package com.heli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public int getVotes(int restaurantId) {

        String voteKey = "restaurant:" + restaurantId + ":votes";
        Integer votes = (Integer) redisTemplate.opsForValue().get(voteKey);

        if (votes == null) {
            votes = initializeVotes(restaurantId);
        }

        return votes;

    }

    private int initializeVotes(int restaurantId) {

        // Fetch initial count from database
        int initialVotes = restaurantService.getVoteCountByRestaurantId(restaurantId);

        String voteKey = "restaurant:" + restaurantId + ":votes";
        redisTemplate.opsForValue().set(voteKey, initialVotes);

        return initialVotes;
    }


}
