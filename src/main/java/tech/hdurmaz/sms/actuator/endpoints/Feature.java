package tech.hdurmaz.sms.actuator.endpoints;

public class Feature {
    public Feature(Object enabled) {
        this.enabled = enabled;
    }

    private Object enabled;

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }
}