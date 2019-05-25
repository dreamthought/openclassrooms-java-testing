package com.openclassrooms.testing.calculator.domain;

import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsCalculator {

    private final IntSummaryStatistics summaryStatistics;

    public StatisticsCalculator(IntSummaryStatistics summaryStatistics) {
        this.summaryStatistics = summaryStatistics;
    }

    public Integer average(List<Integer> samples) {
        samples.forEach(summaryStatistics::accept);
        // Extract the average
        Double average = summaryStatistics.getAverage();
        return average.intValue();
    }
}
