package edu.hw2.task4;

public class Calling {
    private Calling() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement caller = stackTraceElements[1];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {}
}
