package sayant.springframeworkguru.sfgurubeerservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by sayantjm on 28/2/21
 */
@Profile("local-discovery")
@EnableDiscoveryClient
@Configuration
public class LocalDiscovery {

}
