package com.cyc.service;

import org.junit.Test;
public class HelloServiceTest
{
    @Test
    public void helloServiceTest()
    {
        HelloService service = new HelloService();
        assert service.getGreeting().equalsIgnoreCase("Hello CYC");
    }
}
