package unittest;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitTestSampleTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addition() throws Exception {
        int a = 6;
        int b = 8;
        JUnitTestSample jUnitTestSample = new JUnitTestSample();
        int result = jUnitTestSample.addition(a,b);
        assertEquals(14,result);
    }

}