package fr.nainssa.Operation;

import java.util.List;

public interface Operation {
    Integer execute(List<Integer> numbers);
    String getName();
}
