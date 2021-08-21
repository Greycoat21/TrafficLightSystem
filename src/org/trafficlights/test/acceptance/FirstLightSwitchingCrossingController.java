package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;
import org.trafficlights.domain.CrossingValidator;

public class FirstLightSwitchingCrossingController {
    private LightState firstState;
    private LightState secondState;
    public void setFirstLight(LightState state) {
        this.firstState = state;
    }
    public void setSecondLight(LightState state) {
        this.secondState = state;
    }
    public LightState firstLight() {
        return firstState;
    }
    public LightState secondLight() {
        return secondState;
    }
    public void execute() {
        switchFirstLight();
    }
    private final CrossingValidator validator = new CrossingValidator();
    public void switchFirstLight() {
        if (!validator.isValidConfiguration(firstState, secondState)) {
            warningConfiguration();
            return;
        }
        firstState = firstState.next();
        if (!validator.isValidConfiguration(firstState, secondState)) {
            warningConfiguration();
        }
    }
    private void warningConfiguration() {
        firstState = LightState.UNKNOWN;
        secondState = LightState.UNKNOWN;
    }
}