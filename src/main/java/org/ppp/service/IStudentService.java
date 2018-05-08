package org.ppp.service;

import org.ppp.model.Student;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(value = "/student")
public interface IStudentService {

    /**
     * 根据学生学号查询学生信息
     * @param studentNum 学生学号
     * @return
     */
    @GET
    @Path(value = "/findStuByNum/")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByStudentNum(@FormParam("studentNum") String  studentNum);

    /**
     * 增加一个学生信息
     * @param student 学生对象
     */
    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String addStu(Student student);

    /**
     * 删除一个学生信息
     * @param studentNum 学生学号
     */
    @GET
    @Path("/deleteStu/")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteStu(@FormParam("studentNum") String studentNum);

}


