package com.training.demo0515.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
        import org.ehcache.config.builders.ExpiryPolicyBuilder;
        import org.ehcache.config.builders.ResourcePoolsBuilder;
        import org.ehcache.jsr107.Eh107Configuration;
        import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
        import org.springframework.cache.annotation.EnableCaching;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration() {
        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                        ResourcePoolsBuilder.heap(100))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(30)))
                        .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache("stuAll", jcacheConfiguration);
            cm.createCache(com.training.demo0515.domain.Student.class.getName(), jcacheConfiguration);
        };
    }
}
