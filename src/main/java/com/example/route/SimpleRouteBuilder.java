package com.example.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.example.exception.CamelCustomException;
import com.example.processor.MyProcessor;
import com.example.processor.RedeliveryProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).onRedelivery(new RedeliveryProcessor()).redeliveryPolicyRef("testRedeliveryPolicyProfile")
            .log("Received body ${body}").handled(true);

        from("file:F:\\data\\exception-retry\\inbox?noop=true").process(new MyProcessor()).to("file:F:\\data\\exception-retry\\outbox");

    }

}
