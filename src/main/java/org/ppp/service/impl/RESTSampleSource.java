package org.ppp.service.impl;

import com.alibaba.fastjson.JSON;
import org.ppp.model.User;
import org.ppp.service.RESTSample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */

public class RESTSampleSource implements RESTSample {
    @Context
    private UriInfo uriInfo;

    @Context
    private Request request;


    @GET
    @Path(value ="/doGet")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String doGet() {
        System.out.println("测试时doGet");
        return "this is get rest request";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/request/{param}")
    @Override
    public String doRequest(@PathParam("param") String param,
                            @Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse) {
        System.out.println(servletRequest);
        System.out.println(servletResponse);
        System.out.println("param======"+param);
        System.out.println(servletRequest.getContentType());
        System.out.println(servletResponse.getCharacterEncoding());
        try {
            System.out.println(servletResponse.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GET
    @Path("/bean/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Override
    public User getBean(@PathParam("id") int id) {
        System.out.println("============getBean==============");
        System.out.println("id:" + id);
        System.out.println("客户端请求方式:" + request.getMethod());
        System.out.println("客户端请求的uri:" + uriInfo.getPath());
        System.out.println(uriInfo.getPathParameters());

        User user = new User();
        user.setId(id);
        user.setName("lulu");
        return user;
    }

    @GET
    @Path("/message/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getMessage(@PathParam("id") int id) {
        User user = new User();
        user.setId(id);
        user.setName("JojO");
        return JSON.toJSONString(user);
    }

    @POST
    @Path("/postData")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public User postData(User user) throws IOException {
        System.out.println("user=========="+user);
        user.setName("jacky");
        return user;
    }

    @PUT
    @Path("/putData/{id}")
    @Produces({ MediaType.APPLICATION_XML })
    @Override
    public User putData(@PathParam("id") int id, User user) {
        System.out.println("=========putData========");
        System.out.println(user);
        user.setId(id);
        user.setAddress("hoojo#gz");
        user.setEmail("hoojo_@126.com");
        user.setName("hoojo");
        System.out.println(user);
        return user;
    }

    @DELETE
    @Path("/removeData/{id}")
    @Override
    public void deleteData(@PathParam("id") int id) {
        System.out.println("======deleteData=========" + id);
    }
}
