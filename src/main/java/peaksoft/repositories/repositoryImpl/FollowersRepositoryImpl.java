package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.repositories.FollowersRepository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class FollowersRepositoryImpl implements FollowersRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public int subscribers(Long followerId) {
        Follower follower = entityManager.find(Follower.class, followerId);
        return follower.getSubscribers().size();
    }

    @Override
    public int subscriptions(Long followerId) {
        Follower follower = entityManager.find(Follower.class, followerId);
        return follower.getSubscriptions().size();
    }
    @Override
    public void following(Long currentUserId, Long foundUserId) {


        User currentUser = entityManager.find(User.class, currentUserId);
        User foundUser = entityManager.find(User.class, foundUserId);

        List<Long> subscriptions = currentUser.getFollower().getSubscriptions();
        List<Long> subscribers = foundUser.getFollower().getSubscribers();

        boolean foundUs = false;

        for (Long subscriptionId : subscriptions) {
            if (subscriptionId.equals(foundUserId)) {
                subscriptions.remove(subscriptionId);
                foundUs = true;
                break;
            }
        }
        if (!foundUs) subscriptions.add(foundUserId);


        for (Long subscriber : subscribers) {
            if (subscriber.equals(currentUserId)) {
                subscribers.remove(subscriber);
                foundUs = true;
                break;
            }
        }
        if (!foundUs) subscribers.add(currentUserId);
    }

}
