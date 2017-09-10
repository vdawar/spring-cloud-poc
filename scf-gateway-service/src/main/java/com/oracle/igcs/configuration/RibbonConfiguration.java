package com.oracle.igcs.configuration;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

public class RibbonConfiguration {

	
	@Bean
    public IPing ribbonPing(final IClientConfig config) {
        PingUrl p = new PingUrl(false,"/health");
        //p.setExpectedContent("true");
        return p;
    }

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new AvailabilityFilteringRule();
    	//return new WeightedResponseTimeRule();
    }
	
}
