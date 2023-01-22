//package models;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//public class ReviewTest {
//    @Before
//    public void setup() throws Exception{
//
//    }
//    @After
//    public void tearDown() throws Exception{
//
//    }
//    @Test
//    public  void getContentGetsCorrectContent() throws Exception{
//        Review review = setupReview();
//        assertEquals("KCA", review.getContent());
//    }
//    @Test
//    public void getWrittenByCorrectlyReturnsWrittenBy() throws Exception{
//        Review review = setupReview();
//        assertEquals("tito", review.getWrittenBy());
//    }
//    @Test
//    public void getRatingReturnsCorrectRating() throws Exception{
//        Review review = setupReview();
//        assertEquals(50, review.getRating());
//    }
//    @Test
//    public void getRestaurantIdReturnsCorrectRestaurantId() throws Exception{
//        Review review =setupReview();
//        assertEquals(2, review.getRestaurantId());
//    }
//    @Test
//    public void setContentCorrectlySetsContent() throws Exception{
//        Review review = setupReview();
//        review.setContent("myn");
//        assertNotEquals("kajela", review.getContent());
//    }
//    @Test
//    public void setWrittenByCorrectlySetsWrittenBy() throws Exception{
//        Review review = setupReview();
//        review.setWrittenBy("tito");
//        assertNotEquals("muchoki", review.getWrittenBy());
//    }
//    @Test
//    public void setRatingCorrectlySetsRating() throws Exception{
//        Review review = setupReview();
//        review.setRating(59);
//        assertNotEquals(60, review.getRating());
//    }
//    @Test
//    public void setRestaurantIdCorrectlySetsRestaurantsId() throws Exception{
//        Review review = setupReview();
//        review.setRestaurantId(23);
//        assertNotEquals(20, review.getRestaurantId());
//    }
//
//    public Review setupReview(){
//        return new Review("KCA","tito",50,2);
//    }
//}
