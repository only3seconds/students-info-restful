package org.ppp.service;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path(value = "/student")
public interface IStudentService {

    /**
     * 根据学生学号查询学生信息
     * @param id 学生学号
     * @return
     */
    @GET
    @Path(value = "/findStuById/{id}")
    @Produces({MediaType.APPLICATION_JSON)
    public String findStuById(@PathParam("id") int id);

    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Student addStu(Student student);


}


