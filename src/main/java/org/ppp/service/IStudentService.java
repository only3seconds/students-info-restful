package org.ppp.service;


import org.ppp.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path(value = "/student")
public interface IStudentService {

    /**
     * 根据学生学号查询学生信息
     * @param studentId 学生学号
     * @return
     */
    @GET
    @Path(value = "/findStuByNum/{studentNum}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findStuByNum(@PathParam("studentNum") String  studentNum);

    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void addStu(Student student);

    @DELETE
    @Path("/deleteStu/{studentId}")
    public void deleteStu(@PathParam("studentId") String studentId);

}


