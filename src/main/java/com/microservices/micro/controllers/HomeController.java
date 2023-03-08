package com.microservices.micro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")

        public String Home()
        {
            logger.debug(" Opps ! debug went wrong ! ");
            logger.info(" Opps ! info went wrong ! ");
            logger.warn(" Opps ! warn went wrong ! ");
            logger.error(" Opps ! someting went wrong ! ");

            return  "Hello form the other side";
        }
}
