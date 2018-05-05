package org.ppp.service;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */


public class Client {
    @Autowired
    private RESTSample rESTSample;
    @Autowired
    private WebClient webClient;
    @Before
    public void initContext(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring/applicationcontext.xml");
        webClient=(WebClient)ac.getBean("webClient");
        rESTSample=(RESTSample)ac.getBean("rESTSample");
    }
    @Test
    public void testWebService(){
        /*第一种调用接口方式
                 优点：不需要服务端提供接口
                 缺点:不够方便*/
        String user=  webClient.path("sample/message/6").accept("MediaType.APPLICATION_JSON").get(String.class);
        System.out.println(user);
    }

    @Test
    public void testWebService2(){
        /*第二种调用接口方式
        优点:调用方便
        缺点:需要服务端提供接口*/
        String user=  rESTSample.getMessage(6);
        System.out.println(user);
    }
}
