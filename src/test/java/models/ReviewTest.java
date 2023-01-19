package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReviewTest {
    @Before
    public void setup() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public  void getContentGetsCorrectContent() throws Exception{
        Review review = setupReview();
        assertEquals("KCA", review.getContent());
    }
    @Test
    public void getWrittenByCorrectlyReturnsWrittenBy() throws Exception{
        Review review = setupReview();
        assertEquals("tito", review.getWrittenBy());
    }
    @Test
    public void getRatingReturnsCorrectRating() throws Exception{
        Review review = setupReview();
        assertEquals(50, review.getRating());
    }
    @Test
    public void getRestaurantIdReturnsCorrectRestaurantId() throws Exception{
        Review review =setupReview();
        assertEquals(2, review.getRestaurantId());
    }

    public Review setupReview(){
        return new Review("KCA","tito",50,2);
    }
}
