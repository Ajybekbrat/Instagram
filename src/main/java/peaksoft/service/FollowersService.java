package peaksoft.service;

import peaksoft.entities.Follower;

import java.util.List;

public interface FollowersService {
    int subscribers(Long followerId);
    int subscriptions(Long followerId);

    void following(Long userId,Long foundId);
}
