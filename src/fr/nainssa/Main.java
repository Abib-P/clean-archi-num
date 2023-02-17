package fr.nainssa;

import fr.nainssa.Operation.*;
import fr.nainssa.input.FileReaders;
import fr.nainssa.input.Reader;
import fr.nainssa.output.CmdOutput;
import fr.nainssa.output.Logger;
import fr.nainssa.output.Output;

import java.io.PrintStream;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //output
        Optional<Logger> logger = Optional.empty();
        LocalTime now = LocalTime.now();
        PrintStream printStream = System.out;
        if (args.length > 2 && args[2].equals("-log")) {
            logger = Optional.of(new Logger("log", now, printStream));
        }
        Output output = new CmdOutput(logger, printStream);

        //input
        if (args.length == 0) {
            throw new NoEnoughArgumentException("No file name given");
        }
        String fileName = args[0];
        Reader reader = new FileReaders(fileName, output);
        List<Integer> numbers = reader.read();

        //operation
        if (args.length == 1) {
            throw new NoEnoughArgumentException("No operation type given");
        }
        Operation operation = switch (args[1]) {
            case "+" -> new AdditionOperation(output);

            case "*" -> new MultiplicationOperation(output);

            case "-" -> new MinusOperation(output);

            default -> throw new UnknownOperationException("Unknown operation type");
        };

        //execute
        Integer result = operation.execute(numbers);
        output.printResult(result, operation.getName());
    }
}
