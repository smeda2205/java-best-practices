package unittest.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unittest.JUnitTestSampleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JUnitTestSampleTest.class
})
public class TestSuite {
}
