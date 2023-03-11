package com.microservices.micro.interceptor;

import lombok.Data;

@Data
public class BearerTokenWrapper {

  private String token;
}
