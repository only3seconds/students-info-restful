package org.ppp.service.impl;

import com.alibaba.fastjson.JSON;
import org.ppp.dao.StudentDao;
import org.ppp.model.Student;
import org.ppp.service.IStudentService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

public class StudentServiceImpl implements IStudentService {
    @Context
    private UriInfo uriInfo;

    @Context
    private Request request;

    @Resource
    private StudentDao studentDao;

    @GET
    @Path(value = "/findStuByNum/{studentNum}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findStuByNum(@PathParam("studentNum") String  studentNum) {
        Student student = studentDao.findByStudentNum(studentNum);

        return JSON.toJSONString(student);
    }

    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void addStu(Student student) {

    }

    @DELETE
    @Path("/deleteStu/{studentId}")
    public void deleteStu(@PathParam("studentId") String studentId) {

    }


}
