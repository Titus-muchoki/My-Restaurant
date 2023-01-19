package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    @Test
    public void RestaurantInstantiatesCorrectly_true(){
        Restaurant restaurant = new Restaurant("hotel","","","");
        assertEquals(true, restaurant instanceof Restaurant);
    }
    @Test
    public void RestaurantInstantiatesWithName(){
        Restaurant restaurant =new Restaurant("hotel","","","");
        assertEquals( "hotel",restaurant.getName());
    }
}
