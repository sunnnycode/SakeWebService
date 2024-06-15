package org.sake.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.sake.db")
@EnableJpaRepositories(basePackages = "org.sake.db")
public class JpaConfig {
}
