import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.logging.Logger;

import static junit.framework.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestCsd {

    public static Logger log = Logger.getLogger(TestCsd.class.getName());

    int five_var;

    @Before
    public void setUp() {
        log.info("setup");
        five_var = 5;
    }

    @Test
    public void test1() {

        log.info("Start");
        assertTrue(five_var > 0);
    }

    @Test
    public void test2() {

        log.info("Start2");
        assertTrue(five_var > 1);
    }

    @After
    public void tearDown() {
        log.info("teardown");
    }
}
