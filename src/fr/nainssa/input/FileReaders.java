package fr.nainssa.input;

import fr.nainssa.output.Output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileReaders implements Reader {
    private final BufferedReader objReader;
    private final Output output;

    public FileReaders(String fileName, Output output) {
        this.output = output;
        try {
            objReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new FileCannotBeReadException("%s cannot be read".formatted(fileName));
        }
    }

    @Override
    public List<Integer> read() {
        output.startOperation();
        return objReader
                .lines()
                .map(Integer::parseInt)
                .toList();
    }
}
