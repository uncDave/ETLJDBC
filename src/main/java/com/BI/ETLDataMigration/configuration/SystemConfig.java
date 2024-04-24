package com.BI.ETLDataMigration.configuration;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SystemConfig {

//    @Value("${spring.config.location}")
//    private String configLocation;
//    @Bean(name = "propertiesConfiguration")
//    @ConditionalOnProperty(name = "spring.config.location", matchIfMissing = false)
//    public PropertiesConfiguration propertiesConfiguration () throws Exception {
////        String filePath = new File(path.substring("file:".length())).getCanonicalPath();
//        PropertiesConfiguration configuration = new PropertiesConfiguration(configLocation);
//        FileChangedReloadingStrategy reloadingStrategy = new FileChangedReloadingStrategy();
//        reloadingStrategy.setRefreshDelay(2000);
//        configuration.setReloadingStrategy(reloadingStrategy);
//        return configuration;
//    }

    @Bean(name = "propertiesConfiguration")
    @ConditionalOnProperty(name = "spring.config.location", matchIfMissing = false)
    public PropertiesConfiguration propertiesConfiguration(@Value("${spring.config.location}") String path) throws Exception {
//        String filePath = new File(path.substring("file:".length())).getCanonicalPath();
        PropertiesConfiguration configuration = new PropertiesConfiguration("./"+path);
        FileChangedReloadingStrategy reloadingStrategy = new FileChangedReloadingStrategy();
        reloadingStrategy.setRefreshDelay(2000);
        configuration.setReloadingStrategy(reloadingStrategy);
        return configuration;
    }
}
