package org.zerock.ex00.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

// Note: I think the general direction of testing is basically bottom-up
// meaning that we first test the most basic requirements
// (i.e. check if the Object exists, check if one class is being properly injected into another, test if method is returning the correct value, etc)
// then we test the more specific circumstances.
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DITests {

    @Autowired
    Restaurant restaurant;

    @Autowired
    DataSource dataSource;

    @Autowired
    Chef chef;

    // Test if Restaurant object exists
    @Test
    public void testExist(){
        System.out.println(restaurant);
    }

    @Test
    public void testCon() throws Exception {
        Connection conn = dataSource.getConnection();
        System.out.println("Connection @: " + conn);
        conn.close();
    }
}
