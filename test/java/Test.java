package test.java;

public abstract class Test {
    public abstract void run();

    public <T> void assertEquals(String testName, T exp, T act) {
        if (exp == act) {
            System.err.println(testName + " successful");
        }
        else {
            System.err.println(String.format("%s failed. Expected %s, actual %s", testName, exp, act));
        }
    }
}
