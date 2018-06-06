package unittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("teardown");
    }

    @Test
    public void truncateAInFirst2Positions() throws Exception {

    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame() throws Exception {

    }

}