package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Follower;
import peaksoft.repositories.FollowersRepository;
import peaksoft.service.FollowersService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowersService {
    private final FollowersRepository followerRepository;


    @Override
    public int subscribers(Long followerId) {
        return followerRepository.subscribers(followerId);
    }

    @Override
    public int subscriptions(Long followerId) {
        return followerRepository.subscriptions(followerId);
    }

    @Override
    public void following(Long userId, Long foundId) {
        followerRepository.following(userId, foundId);
    }
}
