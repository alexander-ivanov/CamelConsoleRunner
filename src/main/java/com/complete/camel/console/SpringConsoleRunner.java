package com.complete.camel.console;

import org.apache.camel.spring.Main;
/**
 * Created by alexanderivanov on 10.02.15.
 */
public class SpringConsoleRunner {
    private Main main;

    public static void main(String[] args) throws Exception {
        SpringConsoleRunner springConsoleRunner = new SpringConsoleRunner();
        springConsoleRunner.boot();
    }

    public void boot() throws Exception {
        main = new Main();
        main.setFileApplicationContextUri("../conf/spring-camel-routes.xml");

        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }
}
