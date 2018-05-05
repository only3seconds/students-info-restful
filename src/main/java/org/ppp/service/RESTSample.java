package org.ppp.service;

import org.ppp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */

@Path(value = "/sample")
public interface RESTSample {
    @GET
    @Path(value ="/doGet")
    @Produces(MediaType.TEXT_PLAIN)
    public String doGet();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/request/{param}")
    public String doRequest(@PathParam("param") String param,
                            @Context HttpServletRequest servletRequest,
                            @Context HttpServletResponse servletResponse) ;

    @GET
    @Path("/bean/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getBean(@PathParam("id") int id) ;

    @GET
    @Path("/message/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getMessage(@PathParam("id") int id);

    /*
        @Consumes：声明该方法可以接受的MIME
        @FormParam：注入该方法的 HTML 属性确定的表单输入。
        @Produces ：表示该方法返回的MIME类型
     */
    @POST
    @Path("/postData")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User postData(User user) throws IOException;

    @PUT
    @Path("/putData/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public User putData(@PathParam("id") int id, User user);

    @DELETE
    @Path("/removeData/{id}")
    public void deleteData(@PathParam("id") int id) ;
}
