import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.logging.Logger;

import static junit.framework.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestCsd {

    public static Logger log = Logger.getLogger(TestCsd.class.getName());

    @Test
    public void test1() {

        log.info("Start");
        int five_var  = 5;
        assertTrue(five_var > 0);
    }


}
