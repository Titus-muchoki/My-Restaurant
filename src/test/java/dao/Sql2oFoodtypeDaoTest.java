package dao;

import models.Foodtype;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class Sql2oFoodtypeDaoTest {
private Sql2oFoodtypeDao foodtypeDao;
private static Connection con;
@Before
    public void setup(){
    String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
    Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
    foodtypeDao = new Sql2oFoodtypeDao(sql2o); //ignore me for now
    con = sql2o.open(); //keep connection open through entire test so, it does not get erased
}
@After
    public void tearDown(){
    System.out.println("clearing database");
    foodtypeDao.clearAllFoodtype();
    con.close();
}

    @AfterClass                                     //run once after all tests in this file completed
    public static void shutDown() {
        con.close();                               // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingFoodtypeSetsId() {
        Foodtype foodtype = new Foodtype("tito");
        int originalFoodtypeId = foodtype.getId();
        foodtypeDao.add(foodtype);
        assertNotEquals(originalFoodtypeId, foodtype.getId()); //how does this work?

    }
    public Foodtype setupNewFoodtype(){
        return new Foodtype("rice");
    }

}
