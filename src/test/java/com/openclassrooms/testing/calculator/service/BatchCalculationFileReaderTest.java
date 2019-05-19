package com.openclassrooms.testing.calculator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BatchCalculationFileReader.class, Files.class, Paths.class})
public class BatchCalculationFileReaderTest {

    @Test
    public void getCalculationsFromBatchFile_shouldReturnAStreamOfCalculations_whenGivenAValidFile() throws IOException {

        // ARRANGE
        BatchCalculationFileReader classUnderTest = new BatchCalculationFileReader();

        // Mocking
        String fakeBatchFile = "/path/to/batchFile.txt";
        // fake response stream
        List<String> expectedCalculations = Arrays.asList("1 + 2", "3 - 2");


        PowerMockito.mockStatic(Files.class);
        PowerMockito.mockStatic(Paths.class);

        Path path = mock(Path.class);
        when(Paths.get(fakeBatchFile)).thenReturn(path);
        // return the stream of our calculations
        when(Files.lines(path)).thenReturn( expectedCalculations.stream() );

        // ACT
        Stream<String> response = classUnderTest.getCalculationsFromBatchFile(fakeBatchFile);
        List<String> responseAsList = response.collect(Collectors.toList());

        // ASSERT
        assertThat(responseAsList, containsInAnyOrder(expectedCalculations.toArray()));
    }

}