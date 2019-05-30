package com.openclassrooms.testing.calculator.controller;

import com.openclassrooms.testing.calculator.domain.model.CalculationModel;
import com.openclassrooms.testing.calculator.domain.model.Calculation;
import com.openclassrooms.testing.calculator.domain.model.CalculationType;
import com.openclassrooms.testing.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculatorController {

    public static final String CALCULATOR_TEMPLATE = "calculator";
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String index(Calculation calculation){
        return "redirect:/calculator";
    }

    @GetMapping("/calculator")
    public String root(Calculation calculation){
        return CALCULATOR_TEMPLATE; // see resources/templates/calculator.html
    }

    @PostMapping("/calculator")
    public String calculate(@Valid Calculation calculation, BindingResult bindingResult, Model model) {
        // TODO: For the eger beaver, feel free to change this to use a formatter
        // I'm keeping the code transparent here to reduce "Magic"
        CalculationType type = CalculationType.valueOf(calculation.getCalculationType());
        CalculationModel calculationModel = new CalculationModel(
                type,
                calculation.getLeftArgument(),
                calculation.getRightArgument());

        CalculationModel response = calculatorService.calculate(calculationModel);

        model.addAttribute("response", response);
        return CALCULATOR_TEMPLATE;  // see resources/templates/calculator.html
    }
}
