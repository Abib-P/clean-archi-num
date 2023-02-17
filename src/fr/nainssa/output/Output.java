package fr.nainssa.output;

public interface Output {
    void startOperation();
    void printResult(Integer result, String operationName);

    void printParsedNumberWithLine(Integer number, Integer index, String operationName);
    void printParsedNumberWithLineOperationAndResult(Integer number, Integer index, String operation, Integer result, String operationName);
}
