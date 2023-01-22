package dao;

import models.Restaurant;

import java.util.List;

public interface RestaurantDao {
        List<Restaurant> getAll();

        // CREATE
        void add(Restaurant restaurant);

        // READ
        Restaurant findById(int id);

        // UPDATE
        void update(int id, String name, String address, String zipcode, String phone, String website, String email);

        // DELETE
        void deleteById(int id);

        void clearAll();
    }

