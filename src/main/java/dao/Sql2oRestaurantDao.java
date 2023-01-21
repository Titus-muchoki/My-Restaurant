package dao;

import models.Restaurant;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oRestaurantDao implements RestaurantDao {
    private final Sql2o sql2o;

    public  Sql2oRestaurantDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public void add(Restaurant restaurant) {

    }

    @Override
    public Restaurant findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name, String address, String zipcode, String phone, String website, String email) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllRestaurant() {

    }
}
