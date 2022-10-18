package tech.hdurmaz.sms.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import tech.hdurmaz.sms.entity.Course;
import tech.hdurmaz.sms.utils.ErrorMessageConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeaturesEndpoint {

    private Map<String, Feature> features = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Feature> features() {
        features.put("1",new Feature(ErrorMessageConstants.COURSE_IS_ALREADY_EXIST));
        features.put("2",new Feature(false));
        features.put("3",new Feature(true));
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }



}