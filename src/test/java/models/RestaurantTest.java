package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
  @Before
    public void setup() throws Exception{

  }
  @After
    public void tearDown() throws Exception{

  }
    @Test
    public void getNameReturnsCorrectName() throws Exception{
    Restaurant restaurant = setupRestaurant();
    assertEquals("Joy", restaurant.getName());
    }
    @Test
    public void getAddressReturnsCorrectAddress() throws Exception{
    Restaurant restaurant =setupRestaurant();
    assertEquals("214 kimbo", restaurant.getAddress());
    }
    @Test
    public void getZipcodeReturnsCorrectZipcode() throws Exception{
    Restaurant restaurant = setupRestaurant();
    assertEquals("978", restaurant.getZipcode());
    }
    @Test
    public void getPhoneReturnsCorrectPhone() throws Exception{
    Restaurant restaurant = setupRestaurant();
    assertEquals("0717553340", restaurant.getPhone());
    }
    @Test
    public void getWebsiteReturnsCorrectWebsite() throws Exception{
    Restaurant restaurant = setupRestaurant();
    assertEquals("http://fishwitch.com", restaurant.getWebsite());
    }
    @Test
    public void getEmailReturnsCorrectEmail() throws Exception{
    Restaurant restaurant = setupRestaurant();
    assertEquals("titoyut56@gmail.com", restaurant.getEmail());
    }

  public Restaurant setupRestaurant (){
    return new Restaurant("Joy", "214 kimbo", "978", "0717553340", "http://fishwitch.com", "titoyut56@gmail.com");
  }
}
