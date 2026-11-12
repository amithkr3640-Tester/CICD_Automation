package com.anhtester.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigFactory {
    // Jenkins CI/CD trigger test comment

    private ConfigFactory() {
    }

    public static Configuration getConfigs() {
        return ConfigCache.getOrCreate(Configuration.class);

    }

}

