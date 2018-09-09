/**
 * 
 */
package com.gapsi.api.test.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.gapsi.api.test.services.ItemServices;


@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		 register(ItemServices.class);
	}
}
