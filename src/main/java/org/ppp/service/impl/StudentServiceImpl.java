package org.ppp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    @Override
    public String findByStudentNum(@PathParam("studentNum") String  studentNum) {
        JSONObject returnObject = new JSONObject();
        Student student = studentDao.findByStudentNum(studentNum);
        returnObject.put("data", JSON.toJSONString(student));
        returnObject.put("success", true);
        return returnObject.toJSONString();
    }

    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Override
    public String addStu(Student student) {
        JSONObject returnObject = new JSONObject();
        studentDao.addStu(student);
        returnObject.put("success", true);
        return returnObject.toJSONString();
    }

    @DELETE
    @Path("/deleteStu/{studentNum}")
    @Override
    public String deleteStu(@PathParam("studentNum") String studentNum) {
        JSONObject returnObject = new JSONObject();
        try {
            studentDao.deleteStu(studentNum);
            returnObject.put("success", true);
        } catch (Exception e) {
            returnObject.put("success", false);
        }
        return returnObject.toJSONString();
    }
}
