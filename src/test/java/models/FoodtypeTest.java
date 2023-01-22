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
    @Test
    public void setIdCorrectlySetsTheId() throws Exception{
        Foodtype foodtype = setupFoodtype();
        foodtype.setName("vima");
        assertEquals("vima", foodtype.getName());

    }
    @Test
    public void setIdSetsIdCorrectly() throws Exception{
        Foodtype foodtype = setupFoodtype();
        foodtype.setId(2);
        assertEquals(2, foodtype.getId());
    }
    public Foodtype setupFoodtype(){
        return new Foodtype("tito");
    }
}
