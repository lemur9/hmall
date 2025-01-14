package com.hmall.gateway.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintAnyGatewayFilterFactory extends AbstractGatewayFilterFactory<PrintAnyGatewayFilterFactory.Config> {
    @Override
    public GatewayFilter apply(Config config) {
        String a = config.getA();
        String b = config.getB();
        String c = config.getC();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return new OrderedGatewayFilter((exchange, chain) -> chain.filter(exchange), 1);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("a", "b", "c");
    }

    public PrintAnyGatewayFilterFactory() {
        super(Config.class);
    }

    @Data
    public static class Config {
        private String a;
        private String b;
        private String c;
    }
}
