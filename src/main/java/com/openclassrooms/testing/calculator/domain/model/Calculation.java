package com.openclassrooms.testing.calculator.domain.model;

import javax.validation.constraints.NotNull;

public class Calculation {

    @NotNull
    private String calculationType;

    @NotNull
    private Integer leftArgument;

    @NotNull
    private Integer rightArgument;

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType){
        this.calculationType = calculationType;
    }

    public Integer getLeftArgument() {
        return leftArgument;
    }

    public void setLeftArgument(Integer leftArgument) {
        this.leftArgument = leftArgument;
    }

    public Integer getRightArgument() {
        return rightArgument;
    }

    public void setRightArgument(Integer rightArgument) {
        this.rightArgument = rightArgument;
    }
}
