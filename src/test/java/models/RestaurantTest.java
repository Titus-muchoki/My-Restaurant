package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    @Test
    public void setNameSetsNameCorrectly() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setName("crystalust");
    assertNotEquals("thisa", restaurant.getName());
    }
    @Test
    public void setAddressSetsAddressCorrectly() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setAddress("mundoro");
    assertNotEquals("zimmer", restaurant.getAddress());
    }
    @Test
    public void setZipcodeCorrectlySetsZipcode() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setZipcode("120");
    assertNotEquals("130", restaurant.getZipcode());
    }
    @Test
    public void setPhoneCorrectlySetsPhone() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setPhone("0717553340");
    assertNotEquals("0776509158", restaurant.getPhone());
    }
    @Test
    public void setWebsiteCorrectlySetsWebsite() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setWebsite("http//kca.com");
    assertNotEquals("http//kajela.com", restaurant.getWebsite());
    }
    @Test
    public void setEmailCorrectlySetsEmail() throws Exception{
    Restaurant restaurant = setupRestaurant();
    restaurant.setEmail("titoyut56@gmail.com");
    assertNotEquals("wambuchiri12@gmail.com", restaurant.getEmail());
    }

  public Restaurant setupRestaurant (){
    return new Restaurant("Joy", "214 kimbo", "978", "0717553340", "http://fishwitch.com", "titoyut56@gmail.com");
  }
}
