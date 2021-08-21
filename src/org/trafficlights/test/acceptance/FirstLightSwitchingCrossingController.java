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
        return firstState.next();
    }

    public LightState secondLight() {
        return secondState;
    }
}