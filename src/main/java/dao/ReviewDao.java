package dao;

import models.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getAll();

    // CREATE
    void add(Review review);

    // READ
    Review findById(int id);

    // UPDATE
    void update(int id,   String content,String writtenBy, int rating, int restaurantId);

    // DELETE
    void deleteById(int id);
    void clearAllReview();

}
