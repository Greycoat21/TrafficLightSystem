package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

public class FirstLightSwitchingCrossingController {

    LightState firstState;
    LightState secondState;

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

    public void switchFirstLight() {
        if (!isValidLightStateConfiguration()) {
            warningConfiguration();
            return;
        }
        firstState = firstState.next();
    }

    private void warningConfiguration() {
        firstState = LightState.UNKNOWN;
        secondState = LightState.UNKNOWN;
    }

    private boolean isValidLightStateConfiguration() {
        return !LightState.UNKNOWN.equals(firstState) && LightState.RED.equals(secondState);
    }

}