package com.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RedeliveryProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        //exchange.getIn().setBody("test1");
    	Thread.sleep(2000);
    	System.out.println("trying redelivery");
        }

}
