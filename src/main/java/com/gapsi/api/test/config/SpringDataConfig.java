
package com.gapsi.api.test.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories("com.gapsi.api.test.repositories")
public class SpringDataConfig {

}