package org.jhotdraw;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JHotDrawTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JHotDrawTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("failure: " + failure.toString());
        }

        System.out.println("succes " + result.wasSuccessful());
    }
}
