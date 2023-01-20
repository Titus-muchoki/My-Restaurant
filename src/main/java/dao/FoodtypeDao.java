package dao;

import models.Foodtype;
import models.Review;

import java.util.List;

public interface FoodtypeDao {
    List<Foodtype> getAll();

    // CREATE
    void add(Foodtype foodtype);

    // READ
    Foodtype findById(int id);

    // UPDATE
    void update(int id,String name);

    // DELETE
    void deleteById(int id);
    void clearAllFoodtype();
}
