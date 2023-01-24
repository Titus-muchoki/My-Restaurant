import com.google.gson.Gson;
import com.networknt.exception.ApiException;
import dao.Sql2oFoodtypeDao;
import dao.Sql2oRestaurantDao;
import dao.Sql2oReviewDao;
import models.Foodtype;
import models.Restaurant;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oFoodtypeDao foodtypeDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oReviewDao reviewDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();

        //CREATE
        post("/restaurants/new", "application/json", (req, res) -> {
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
            restaurantDao.add(restaurant);
            res.status(201);;
            return gson.toJson(restaurant);
        });

        //READ
        get("/restaurants", "application/json", (req, res) -> {
            System.out.println(restaurantDao.getAll());

            if (restaurantDao.getAll().size() > 0){
                return gson.toJson(restaurantDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no restaurants are currently listed in the database.\"}";
            }
        });

        get("/restaurants/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(restaurantDao.findById(restaurantId));
        });
        get("/restaurants/:id/reviews", "application/json", (req, res) ->{
            int restaurantId = Integer.parseInt(req.params("id"));

            Restaurant restaurantToFind = restaurantDao.findById(restaurantId);
            List<Review> allReviews;

            if (restaurantToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }
            allReviews = reviewDao.getAllReviewsByRestaurant(restaurantId);
            return gson.toJson(allReviews);

        }
    );
        //CREATE
        get("/foodtypes", "application/json", (req, res) ->{
            return gson.toJson(foodtypeDao.getAll());
                }
        );
        post("/foodtypes/new", "application/json", (req, res) ->{
            Foodtype foodtype = gson.fromJson(req.body(), Foodtype.class);
            foodtypeDao.add(foodtype);
            res.status(201);
            return  gson.toJson(foodtype);
        }
    );
        // CREATE
        get("/reviews", "application/json", (req, res) ->{
            return gson.toJson(reviewDao.getAll());
        }
    );
        post("reviews/new", "application/json", (req, res) ->{
            Review review = gson.fromJson(req.body(),Review.class);
            reviewDao.add(review);
            res.status(201);
            return gson.toJson(review);
        }
    );
        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) ->{
            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setRestaurantId(restaurantId);
            reviewDao.add(review);
            res.status(201);
            return gson.toJson(review);
        }
    );
        //FILTERS

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatus());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.hashCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });
    }
}