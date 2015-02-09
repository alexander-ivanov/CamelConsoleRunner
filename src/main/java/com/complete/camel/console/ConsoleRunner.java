package com.complete.camel.console;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.model.RoutesDefinition;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by alexanderivanov on 09.02.15.
 */
public class ConsoleRunner {
    private Main main;

    public static void main(String[] args) throws Exception {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        consoleRunner.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.addRouteBuilder(new XmlRouteBuilder());

        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }

    private static class XmlRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            InputStream is = new FileInputStream("../conf/camel-routes.xml");
            ModelCamelContext camelContext = getContext();
            if (camelContext == null) {
                throw new IllegalArgumentException("CamelContext has not been injected!");
            }
            RoutesDefinition routes = camelContext.loadRoutesDefinition(is);
            camelContext.addRouteDefinitions(routes.getRoutes());
        }
    }
}
