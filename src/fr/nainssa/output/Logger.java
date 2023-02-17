package fr.nainssa.output;

import java.io.PrintStream;
import java.time.LocalTime;

public class Logger {
    private final String loggerName;

    private final LocalTime time;
    private final PrintStream printStream;

    public Logger(String loggerName, LocalTime time, PrintStream printStream) {
        this.loggerName = loggerName;
        this.time = time;
        this.printStream = printStream;
    }

    private String getTime() {
        return String.format("[%02d%02d%02d:%06d]", time.getHour(), time.getMinute(), time.getSecond(), time.getNano());
    }

    private String introLog() {
        return getTime() + "[" + loggerName+ "] ";
    }

    public void logStartOperation() {
        printStream.println(introLog() + "started");
        printStream.println(introLog() + "applying operation addition");
    }

    public void logEndOperation() {
        printStream.println(introLog() + "end of program");
    }

    public void logParsedNumber(Integer integer) {
        printStream.println(introLog() + "parsed value = " + integer);
    }

    public void logInfoAndLine(String operationName, Integer result, Integer index) {
        printStream.println(introLog() + operationName + " : " + result + " on line " + index);
    }
}
