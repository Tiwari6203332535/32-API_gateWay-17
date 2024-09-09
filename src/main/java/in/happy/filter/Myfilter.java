package in.happy.filter;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class Myfilter implements GlobalFilter  {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	System.out.println("filter executed");
	ServerHttpRequest request = exchange.getRequest();
	HttpHeaders headers = request.getHeaders();
	Set<String> keyset = headers.keySet();
	for(String key : keyset ) {
		System.out.println(key);
		System.out.println(headers.getValuesAsList(key));
	
		
	}
	return chain.filter(exchange);
	}
	}