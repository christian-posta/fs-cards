package com.christianposta.fuse.integration;

import com.christianposta.fuse.Player;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 8:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class DealCardsTest extends CamelSpringTestSupport{
    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("/spring/deal-cards-context.xml");
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:file")
                        .split(body(String.class).tokenize("\n"), new PlayerAggregationStrategy())
                        .log("Player names: ${body}")
                        .bean(StringToPlayerTranslator.class)
                        .to("mock:split")
                        .end()
                        .log("What we have so far \"${body}\"")
                        .beanRef("dealer")
                        .to("mock:players");

            }
        };
    }

    @Test
    public void simpleTest() throws InterruptedException {
        final MockEndpoint mockEndpoint = getMockEndpoint("mock:players");
        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.message(0).body(List.class);
        mockEndpoint.expects(new Runnable() {
            public void run() {
                Exchange exchange = mockEndpoint.getExchanges().get(0);
                List<Player> playerList = exchange.getIn().getBody(List.class);
                assertEquals(2, playerList.size());
                for (Player player : playerList) {
                    assertEquals(5, player.getTotalNumCards());
                }
            }
        });

        MockEndpoint splitMockEndpoint = getMockEndpoint("mock:split");
        splitMockEndpoint.expectedMessageCount(2);
        splitMockEndpoint.allMessages().body(Player.class);

        template.sendBody("direct:file", "christian\ntodd");

        assertMockEndpointsSatisfied();

    }

}
