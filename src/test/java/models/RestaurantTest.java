package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    @Test
    public void RestaurantInstantiatesCorrectly_true(){
        Restaurant restaurant = new Restaurant("hotel","1","1","1");
        assertEquals(true, restaurant instanceof Restaurant);
    }
    @Test
    public void RestaurantInstantiatesWithName(){
        Restaurant restaurant =new Restaurant("hotel","1","1","1");
        assertEquals( "hotel",restaurant.getName());
    }
    @Test
    public void RestaurantInstantiatesWithAddress(){
    Restaurant restaurant = new Restaurant("hotel","1","1","1");
    assertEquals("1", restaurant.getAddress());
    }
    @Test
    public void RestaurantInstantiatesWithZipcode(){
        Restaurant restaurant = new Restaurant("hotel","1","1","1");
        assertEquals("1",restaurant.getZipcode());
    }
}
