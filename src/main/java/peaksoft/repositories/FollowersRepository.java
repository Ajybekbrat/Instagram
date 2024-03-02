package peaksoft.repositories;

import peaksoft.entities.Follower;

import java.util.List;

public interface FollowersRepository {
    int subscribers(Long followerId);
    int subscriptions(Long followerId);

    void following(Long userId,Long foundId);
}
