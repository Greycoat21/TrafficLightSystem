package org.trafficlights.domain;

public enum LightState {
    RED("red") {
        public LightState next() { return RED_YELLOW; }
    },
    RED_YELLOW("red, yellow") {
        public LightState next() { return GREEN; }
    },
    GREEN("green") {
        public LightState next() { return YELLOW; }
    },
    YELLOW {
        public LightState next() { return RED; }
    },
    UNKNOWN;

    public LightState next() {
        return UNKNOWN;
    }

    String description;

    LightState() {
        this("");
    }

    LightState(String description) {
        this.description = description;
    }
}