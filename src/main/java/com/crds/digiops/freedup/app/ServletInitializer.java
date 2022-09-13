package com.crds.digiops.freedup.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author S RAJAIAH
 * @Date : August 2, 2022
 * @Desc : 
 *
 */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FreedUpWooCommerceApplication.class);
	}

}
