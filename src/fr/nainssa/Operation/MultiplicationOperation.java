package fr.nainssa.Operation;

import fr.nainssa.output.Output;

import java.util.List;

public class MultiplicationOperation implements Operation{
    public final String name = "multiplication";
    private final String operation = "*";
    private final Output output;
    public MultiplicationOperation(Output output) {
        this.output = output;
    }

    @Override
    public Integer execute(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        }
        int firstNumber = numbers.get(0);
        output.printParsedNumberWithLine(firstNumber, 1, name);
        return numbers.subList(1, numbers.size()).stream()
                .reduce(firstNumber, (a, b) -> {
                    int result = a * b;
                    output.printParsedNumberWithLineOperationAndResult(b, numbers.indexOf(b) + 1, operation, result, name);
                    return result;
                });
    }

    @Override
    public String getName() {
        return name;
    }
}
