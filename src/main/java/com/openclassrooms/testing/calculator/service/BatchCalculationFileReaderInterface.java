package com.openclassrooms.testing.calculator.service;

import java.io.IOException;
import java.util.stream.Stream;

public interface BatchCalculationFileReaderInterface {

    /**
     * Reads the calculations from a batch file and returns a stream
     * of written calculations.
     * @param file
     * @return stream of calculations in the form "2 + 2"
     */
    Stream<String> getCalculationsFromBatchFile(String file) throws IOException;
}
