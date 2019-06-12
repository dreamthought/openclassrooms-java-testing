package com.openclassrooms.testing.calculator.model;

/**
 * A model to represent a two argument integer calculation
 * which needs to be performed
 */
public class CalculationModel {
    public static final String SEPARATOR = " ";
    private Double leftArgument;
    private Double rightArgument;
    private CalculationType type;
    private Double solution;

    public static CalculationModel fromText(String calculation) {
        CalculationModel model = new CalculationModel();
        String[] parts = calculation.split(SEPARATOR);

        model.setLeftArgument(new Double(Integer.parseInt(parts[0])));
        model.setRightArgument(new Double(Integer.parseInt(parts[2])));
        String operation = parts[1];
        model.setType( CalculationType.fromSymbol(operation) );
        return model;
    }

    public Double getLeftArgument() {
        return leftArgument;
    }

    public void setLeftArgument(Double leftArgument) {
        this.leftArgument = leftArgument;
    }

    public Double getRightArgument() {
        return rightArgument;
    }

    public void setRightArgument(Double rightArgument) {
        this.rightArgument = rightArgument;
    }

    public CalculationType getType() {
        return type;
    }

    public void setType(CalculationType type) {
        this.type = type;
    }

    public Double getSolution() {
        return solution;
    }

    public void setSolution(Double solution) {
        this.solution = solution;
    }
}
