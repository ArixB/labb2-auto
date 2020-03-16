package testCase;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class runAllTheTest {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(createAccountCase.class, signInCase.class);
        System.out.println("Result: " + result.wasSuccessful());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());

        }
    }
}