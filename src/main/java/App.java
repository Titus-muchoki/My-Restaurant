import com.google.gson.Gson;
import dao.ReviewDao;
import dao.Sql2oFoodtypeDao;
import dao.Sql2oRestaurantDao;
import dao.Sql2oReviewDao;
import models.Review;

import static spark.Spark.*;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class App {
    public static void main(String[] args) {
        Sql2oFoodtypeDao foodtypeDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oReviewDao reviewDao;
        Connection conn;
        Gson gson = new Gson();

//        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");

        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();

    }
}