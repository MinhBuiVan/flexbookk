package com.example.flexbookk.utils;

import com.example.flexbookk.model.*;
import com.example.flexbookk.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDate;

@Configuration
public class UserFaker implements CommandLineRunner {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PostRepository postRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private FriendRepository friendRepository;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusYears(5);
        java.util.Date date = faker.date().between(
                java.sql.Date.valueOf(startDate),
                java.sql.Date.valueOf(endDate)
        );
        Timestamp createdAt = new Timestamp(date.getTime());
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfilePicture(faker.internet().image());
            user.setBio(faker.lorem().paragraph());
            user.setCreatedAt(createdAt);
            user.setUpdatedAt(createdAt);
            userRepository.save(user);
        }
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setContent(faker.lorem().sentence());
            post.setPostImage(faker.internet().image());
            post.setCreatedAt(createdAt);
            post.setUpdatedAt(createdAt);
            Long userID = (long) faker.number().numberBetween(1, 10);
            User author = userRepository.findById(userID).orElse(null);
            post.setUser(author);
            postRepository.save(post);
        }
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setMessage(faker.lorem().sentence());

            // Set the sender and recipient of the message to random users
            Long senderId = (long) faker.number().numberBetween(1, 10);
            User sender = userRepository.findById(senderId).orElse(null);
            message.setSender(sender);

            Long recipientId = (long) faker.number().numberBetween(1, 10);
            User recipient = userRepository.findById(recipientId).orElse(null);
            message.setReceiver(recipient);
            message.setCreatedAt(createdAt);
            message.setUpdatedAt(createdAt);
            messageRepository.save(message);
        }
        for (int i = 0; i < 10; i++) {
            Like like = new Like();

            // Set the user who liked the post to a random user
            Long userId = (long) faker.number().numberBetween(1, 10);
            User user = userRepository.findById(userId).orElse(null);
            like.setUser(user);

            // Set the post that was liked to a random post
            Long postId = (long) faker.number().numberBetween(1, 10);
            Post post = postRepository.findById(postId).orElse(null);
            like.setCreatedAt(createdAt);
            like.setPost(post);
            likeRepository.save(like);
        }
        for (int i = 0; i < 10; i++) {
            Friend friend = new Friend();

            // Set the users who became friends to random users
            Long user1Id = (long) faker.number().numberBetween(1, 10);
            User user1 = userRepository.findById(user1Id).orElse(null);
            friend.setUser1(user1);

            Long user2Id = (long) faker.number().numberBetween(1, 10);
            User user2 = userRepository.findById(user2Id).orElse(null);
            friend.setUser2(user2);
            // Set the status of the friend connection to a random status
            String[] statuses = {"pending", "blocked", "accepted", "declined"};
            String status = statuses[faker.number().numberBetween(0, 4)];
            friend.setStatus(status);

            // Set the action user of the friend connection to a random user
            Long actionUserId = (long) faker.number().numberBetween(1, 10);
            User actionUser = userRepository.findById(actionUserId).orElse(null);
            friend.setActionUser(actionUser);
            friend.setCreatedAt(createdAt);
            friend.setUpdatedAt(createdAt);

            friendRepository.save(friend);
        }
    }
}
