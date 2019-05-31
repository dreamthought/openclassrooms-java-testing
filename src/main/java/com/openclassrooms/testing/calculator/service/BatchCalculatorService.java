package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.domain.SolutionFormatter;
import com.openclassrooms.testing.calculator.domain.model.CalculationModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Supports solving calculations provided in a batch file.
 */
@Service
public class BatchCalculatorService implements Solver {

    // TODO Although I'm sticking to vanilla Java, the curious student,
    // can check out Project Lombok which saves you having to
    // write customer getters and setters: https://projectlombok.org/
    private BatchCalculationFileService batchCalculationFileService;
    private CalculatorService calculatorService;
    private SolutionFormatter formatter;

    /**
     * Constructor
     * @param batchCalculationFileService instance used to read the batch file
     * @param calculatorService instance used to solve problems
     */
    public BatchCalculatorService(BatchCalculationFileService batchCalculationFileService, CalculatorService calculatorService) {
        this.batchCalculationFileService = batchCalculationFileService;
        this.calculatorService = calculatorService;
   }

    public List<CalculationModel> calculateFromFile(String pathToFile) throws IOException {
        Stream<String> calculations = batchCalculationFileService.read(pathToFile);
        ArrayList<CalculationModel> solutions = new ArrayList<>();
        calculations.forEach(calculation -> {
            CalculationModel calculationModel = CalculationModel.fromText(calculation);
            CalculationModel solutionModel = calculatorService.calculate(calculationModel);
            solutions.add(solutionModel);
        });
        return solutions;
    }
}
