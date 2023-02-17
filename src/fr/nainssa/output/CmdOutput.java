package fr.nainssa.output;

import java.io.PrintStream;
import java.util.Optional;

public class CmdOutput implements Output {
    private final Optional<Logger> logger;
    private final PrintStream printStream;
    public CmdOutput(Optional<Logger> logger, PrintStream printStream) {
        this.logger = logger;
        this.printStream = printStream;
    }

    @Override
    public void startOperation() {
        logger.ifPresent(Logger::logStartOperation);
    }

    @Override
    public void printResult(Integer result, String operationName) {
        printStream.println("------------");
        printStream.printf("total: %d (%s)%n", result, operationName);
        logger.ifPresent(Logger::logEndOperation);
    }

    @Override
    public void printParsedNumberWithLine(Integer number, Integer index, String operationName) {
        logger.ifPresent(l -> l.logParsedNumber(number));
        printStream.printf("%d\n", number);
        logger.ifPresent(l -> l.logInfoAndLine(operationName, number, index));
    }

    @Override
    public void printParsedNumberWithLineOperationAndResult(Integer number, Integer index, String operation, Integer result, String operationName) {
        logger.ifPresent(l -> l.logParsedNumber(number));
        printStream.printf("%s%d (= %d)\n", operation, number, result);
        logger.ifPresent(l -> l.logInfoAndLine(operationName, result, index));
    }
}
