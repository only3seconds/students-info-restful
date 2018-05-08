package org.ppp.dao;

import org.apache.ibatis.annotations.Param;
import org.ppp.model.Student;

public interface StudentDao {
    public Student findByStudentNum(@Param("studentNum")  String studentNum);

    public void addStu(Student student);

    public void deleteStu(@Param("studentNum")  String studentNum);

}
