package Read.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Read.FilterHttp.FilterRequest;

@Configuration
public class AppConfig {

	@Bean
	public FilterRegistrationBean<FilterRequest> filterRegistrationBean(){
		
		List<String> urllist = new ArrayList<String>();
		urllist.add("/api");
		
	FilterRegistrationBean<FilterRequest> registrationBean = new FilterRegistrationBean<FilterRequest>();
	FilterRequest filterRequest = new FilterRequest();
	
	registrationBean.setFilter(filterRequest);
	registrationBean.setUrlPatterns(urllist);
		
		return registrationBean;
		
	}
	
}
