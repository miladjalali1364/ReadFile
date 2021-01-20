package Read.FilterHttp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



import Read.Service.TokenFind;

@Component
public class FilterRequest implements Filter{

	private static final Logger LOG = LoggerFactory.getLogger(FilterRequest.class);
	

	TokenFind tokenfind = new TokenFind();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("########## Initiating Custom filter ##########");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String requesttokenheader = null;
		String TokenHeader,host = null;
		
		requesttokenheader = ((HttpServletRequest) request).getHeader("Authorization");
		                                    
		 
		if(requesttokenheader != null && requesttokenheader.startsWith("Bearer")) {
			
			TokenHeader = requesttokenheader.substring(7);
			LOG.info("TokenHeader : " + TokenHeader);
			Boolean  node = false;
			//node = thistokenfind.gettoken(TokenHeader);
		//	node =(Boolean) this.tokenfind.gettoken(TokenHeader);
			
			
		if (tokenfind.gettoken(TokenHeader)) {
			
			host = req.getHeader("origin");
			 try {
				if (tokenfind.geturl(host)) {
					
					LOG.info("Committing a transaction for RemoteHost : {}", req.getRemoteHost());
					LOG.info("Committing a transaction for RemoteHost : {}", request.getRemoteAddr());
					LOG.info("Committing a transaction for ServerName : {}", req.getServerName());
					
					LOG.info("Committing a transaction for .getRequestURI : {}", req.getRequestURI());
					LOG.info("Committing a transaction for getLocalName : {}", req.getLocalName());
					LOG.info("Committing a transaction for .getScheme : {}", req.getScheme());
					LOG.info("Committing a transaction for getRequestURL : {}", req.getRequestURL());
					LOG.info("Committing a transaction for getRemoteUser : {}", req.getRemoteUser());
					LOG.info("Committing a transaction for getQueryString : {}", req.getQueryString());
					HttpServletRequest request2 = (HttpServletRequest) request;
					LOG.info("Committing a transaction for referer : {}", request2.getHeader("referer"));
					LOG.info("Committing a transaction for Host : {}", request2.getHeader("Host"));
					System.out.println("origin       : " + request2.getHeader("origin"));
						
					chain.doFilter(request, response);		
					
					 
					 
				 }else {
						System.out.println("The Url Token is invalid: ");
						System.out.println("The Url Token is invalid: " + req.getHeader("referer"));
						//LOG.info("Committing a transaction for Host : {}", req.getHeader("host"));
						// added for test : 
						System.out.println("getRequestURI : " + req.getRequestURI());
						System.out.println("getRequestURL : " + req.getRequestURL());
						System.out.println("getRemoteAddr : " + req.getRemoteAddr());
						System.out.println("getRemoteHost : " + req.getRemoteHost());
						HttpServletRequest request2 = (HttpServletRequest) request;
						System.out.println("referer       : " + request2.getHeader("referer"));
						System.out.println("host          : " + request2.getHeader("host"));
						System.out.println("X-REFERER       : " + request2.getHeader("X-REFERER"));
						System.out.println("origin       : " + request2.getHeader("origin"));
						
						
						
						
					}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			
						
	}else 
			{
				System.out.println("The "
						+ "Token is invalid: ");
			}
			
		}else {
			LOG.warn("Authorization does not begin with Bearer String");
			System.out.println("Authorization does not begin with Bearer String!!!!!!!");
		}
		
		
		
		
			
	}

	
	
	
	
	
}	
	
	

