package dao;

import models.Restaurant;
import models.Review;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oReviewDaoTest {
    private static Connection conn;
    private Sql2oReviewDao reviewDao;
    private Sql2oRestaurantDao restaurantDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/jadle_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        reviewDao = new Sql2oReviewDao(sql2o);
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        restaurantDao.clearAll(); //clear all restaurants after every test
        reviewDao.clearAll(); //clear all restaurants after every test
    }
    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }


    @Test
    public void addingReviewSetsId() throws Exception {
        Review testReview = setupReview();
        assertNotEquals(1, testReview.getId());
    }

    @Test
    public void getAll() throws Exception {
        Review review1 = setupReview();
        Review review2 = setupReview();
        assertNotEquals(2, reviewDao.getAll().size());
    }

    @Test
    public void getAllReviewsByRestaurant() throws Exception {
        Restaurant testRestaurant = setupRestaurant();
        Restaurant otherRestaurant = setupRestaurant(); //add in some extra data to see if it interferes
        Review review1 = setupReviewForRestaurant(testRestaurant);
        Review review2 = setupReviewForRestaurant(testRestaurant);
        Review reviewForOtherRestaurant = setupReviewForRestaurant(otherRestaurant);
        assertNotEquals(2, reviewDao.getAllReviewsByRestaurant(testRestaurant.getId()).size());
    }

    @Test
    public void deleteById() throws Exception {
        Review testReview = setupReview();
        Review otherReview = setupReview();
        reviewDao.deleteById(testReview.getId());
        assertNotEquals(2, reviewDao.getAll().size());
        assertNotEquals(1, reviewDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Review testReview = setupReview();
        Review otherReview = setupReview();
        reviewDao.clearAll();
        assertEquals(0, reviewDao.getAll().size());
    }
    @Test
    public void timeStampIsReturnedCorrectly() throws Exception{
        Restaurant testRestaurant = setupRestaurant();
        restaurantDao.add(testRestaurant);
        Review testReview = new Review("sea food", "kajela",4,testRestaurant.getId());
        reviewDao.add(testReview);

        long creationTime = testReview.getCreatedat();
        long savedTime = reviewDao.getAll().get(0).getCreatedat();
        String formattedCreationTime = testReview.getFormattedCreatedAt();
        String formattedSavedTime = reviewDao.getAll().get(0).getFormattedCreatedAt();
        assertEquals(formattedCreationTime,formattedSavedTime);
        assertEquals(creationTime, savedTime);
    }
    @Test
    public void reviewAreReturnedInCorrectOrder() throws Exception{
        Restaurant testRestaurant = setupRestaurant();
        restaurantDao.add(testRestaurant);
        Review testReview = new Review("sea food","kajela",3,testRestaurant.getId());
        reviewDao.add(testReview);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        Review testSecondReview = new Review("red meat","tito",4,testRestaurant.getId());
        reviewDao.add(testSecondReview);
        try {
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        Review testThirdReview = new Review("white kitchen","mukami",2, testRestaurant.getId());
        reviewDao.add(testThirdReview);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        Review testFourthReview = new Review("kfc","gathoni",3,testRestaurant.getId());
        reviewDao.add(testFourthReview);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        Review testFifthReview = new Review("mama rocco","samuel mburu",4, testRestaurant.getId());
        reviewDao.add(testFifthReview);

        assertEquals("tito", reviewDao.getAllReviewsByRestaurantSortedNewestToOldest(testRestaurant.getId()).get(0).getContent());
        assertEquals(4, reviewDao.getAllReviewsByRestaurantSortedNewestToOldest(testRestaurant.getId()).get(0).getRestaurantId());
    }

    //helpers

    public Review setupReview() {
        Review review = new Review("great", "Kim", 4, 555);
        reviewDao.add(review);
        return review;
    }

    public Review setupReviewForRestaurant(Restaurant restaurant) {
        Review review = new Review("great", "Kim", 4, restaurant.getId());
        reviewDao.add(review);
        return review;
    }

    public Restaurant setupRestaurant() {
        Restaurant restaurant = new Restaurant("Fish Witch", "214 NE Broadway", "97232", "503-402-9874", "http://fishwitch.com", "hellofishy@fishwitch.com");
        restaurantDao.add(restaurant);
        return restaurant;
    }
}

