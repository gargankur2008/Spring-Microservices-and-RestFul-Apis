package com.ankurgarg.microservices.limitsservice;

import com.ankurgarg.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfig() {
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
