package com.heli.service;

public interface VoteService {

    public int getVotes(int restaurantId);

    public void upvote(int restaurantId, int userId);

    public void downvote(int restaurantId, int userId);

    public void syncVotesToDatabase();
}
