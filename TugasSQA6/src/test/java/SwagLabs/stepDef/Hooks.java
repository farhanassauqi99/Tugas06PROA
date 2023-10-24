package SwagLabs.stepDef;

import SwagLabs.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public static void setUp() {
//        System.out.println("Begin");
//        HelperClass.setUpDriver();
    }
    @After
    public static void tearDown() {
//        System.out.println("End");
//        HelperClass.tearDown();
    }
}
