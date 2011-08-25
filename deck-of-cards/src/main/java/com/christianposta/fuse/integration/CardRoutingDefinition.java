package com.christianposta.fuse.integration;

import com.christianposta.fuse.Player;
import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
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
        XStream xStream = new XStream();
        xStream.processAnnotations(Player.class);
        XStreamDataFormat dataFormat = new XStreamDataFormat();
        dataFormat.setXstream(xStream);
        from("file:data/users?noop=true")
                .split(body(String.class).tokenize("\n"), new PlayerAggregationStrategy())
                .log("Player names: ${body}")
                .bean(StringToPlayerTranslator.class)
                .end()
                .log("What we have so far \"${body}\"")
                .beanRef("dealer")
                .split(body())
                .marshal(dataFormat).setHeader(Exchange.FILE_NAME, xpath("/player/name/text()"))
                .to("file:data/cards");
    }
}
