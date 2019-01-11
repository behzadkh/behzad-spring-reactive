package com.behzad.spring.reactive.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
