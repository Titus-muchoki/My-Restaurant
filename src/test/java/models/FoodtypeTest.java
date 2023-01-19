package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodtypeTest {
    @Before
    public void setup() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void getNameCorrectlyGetName() throws Exception{
        Foodtype foodtype = setupFoodtype();
        assertEquals("tito", foodtype.getName());
    }
    public Foodtype setupFoodtype(){
        return new Foodtype("tito");
    }
}
