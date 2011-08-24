package com.christianposta.fuse.integration;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/19/11
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardRoutingDefinition extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/users?noop=true").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Trying to move a file");
                System.out.println(exchange.getIn().getHeader("CamelFileName"));
            }
        });
    }
}
