package com.openclassrooms.testing.calculator.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Reads a text file and returns a stream of calculations
 */
public class BatchCalculationFileReader implements BatchCalculationFileReaderInterface {

    /**
     * Returns a stream of the rows in a file
     * with file. The file format should have a calculation
     * with a mathematical operator and an argument on each side,
     * separated by a spaces. Eg:
     *
     * <pre>
     *     2 + 2
     *     3 - 2
     *     2022 / 4
     * </pre>
     * @param file
     * @return
     */
    @Override
    public Stream<String> getCalculationsFromBatchFile(String file) throws IOException {
        return Files.lines(Paths.get(file));
    }
}
