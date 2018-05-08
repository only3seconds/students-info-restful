# Spring + Mybatis + CXF Restful服务

## 配置
### 1. maven项目的 pom.xml配置

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>only3seconds</groupId>
  <artifactId>students-info-restful</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>students-info-restful Maven Webapp</name>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
    <spring.version>4.3.14.RELEASE</spring.version>
    <cxf.version>3.1.11</cxf.version>
    <c3p0.version>0.9.5.2</c3p0.version>
    <mysql-connector-java.version>5.1.45</mysql-connector-java.version>
    <mybatis-spring.version>1.3.1</mybatis-spring.version>
    <mybatis.version>3.4.5</mybatis.version>
  </properties>

  <dependencies>
    <!-- c3p0 -->
    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>${c3p0.version}</version>
    </dependency>

    <!-- mysql-connector -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql-connector-java.version}</version>
    </dependency>

    <!-- spring -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <!-- spring end.  -->

    <!-- mybatis-spring -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>${mybatis-spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>

    <!-- cxf -->
    <dependency>
      <groupId>org.apache.cxf</groupId>
      <artifactId>cxf-rt-frontend-jaxrs</artifactId>
      <version>${cxf.version}</version>
    </dependency>
    <dependency>
      <groupId>org.apache.cxf</groupId>
      <artifactId>cxf-rt-rs-client</artifactId>
      <version>${cxf.version}</version>
    </dependency>
    <!-- cxf end. -->

    <!-- json -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.41</version>
    </dependency>
    <dependency>
      <groupId>org.codehaus.jackson</groupId>
      <artifactId>jackson-jaxrs</artifactId>
      <version>1.2.1</version>
    </dependency>

    <dependency>
      <groupId>javax.ws.rs</groupId>
      <artifactId>jsr311-api</artifactId>
      <version>1.1.1</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.0-b01</version>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <finalName>students-info-restful</finalName>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.7.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.20.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>

```

### 2. Spring 基本配置 applicatoncontext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <import resource="spring-cxf-restful.xml"/>
    <!-- 使用注解式注入 -->
    <context:annotation-config />
    <!-- 自动扫描 -->
    <context:component-scan base-package="org.ppp" />
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>

    <!--调用restful服务端-->
    <bean id="webClient" class="org.apache.cxf.jaxrs.client.WebClient" factory-method="create">
        <constructor-arg type="java.lang.String" value="http://localhost:8080/students-info-restful/" />
    </bean>

    <!-- for properties -->
    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="fileEncoding" value="utf-8" />
        <property name="locations">
            <list>
                <value>classpath*:students-info-restful.properties</value>
            </list>
        </property>
    </bean>

    <!-- for database -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"  destroy-method="close">
        <property name="driverClass" value="${students.info.db.driverClass}" />
        <property name="jdbcUrl" value="${students.info.db.url}" />
        <property name="user" value="${students.info.db.user}" />
        <property name="password" value="${students.info.db.password}" />
        <property name="initialPoolSize" value="3" />
        <property name="minPoolSize" value="2" />
        <property name="maxPoolSize" value="10" />
        <property name="maxIdleTime" value="60" />
        <property name="acquireRetryDelay" value="1000" />
        <property name="acquireRetryAttempts" value="10" />
        <property name="preferredTestQuery" value="SELECT 1" />
    </bean>

    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="mapperLocations" value="classpath:mybatis-mapper/*.xml"/>
    </bean>

    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <property name="basePackage" value="org.ppp.dao" />
    </bean>
</beans>
```

### 3.Spring 整合 CXF spring-cxf-restful.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:jaxrs="http://cxf.apache.org/jaxrs"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://cxf.apache.org/jaxrs
       http://cxf.apache.org/schemas/jaxrs.xsd">

    <!-- 使用注解式注入 -->
    <context:annotation-config />
    <!-- 自动扫描 -->
    <context:component-scan base-package="org.ppp" />

    <bean id="student" class="org.ppp.service.impl.StudentServiceImpl"></bean>
    <jaxrs:server address="/" id="StudentService">
        <jaxrs:serviceBeans>
            <ref bean="student"/>
        </jaxrs:serviceBeans>

        <jaxrs:providers>
            <bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider" />
            <bean class="org.apache.cxf.jaxrs.provider.JAXBElementProvider" />
        </jaxrs:providers>
    </jaxrs:server>

</beans>
```

## 设计
### 1. model层实体类设计 Student.java
```java
package org.ppp.model;

public class Student {
    private int id;
    private String studentNum;
    private String studentName;
    private int gender;
    private int age;
    private String address;
    private String major;
    private int deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
```

### 2. 学生服务接口 IStudentService.java
```java
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
    @Path(value = "/findStuByNum/{studentNum}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findStuByNum(@PathParam("studentNum") String  studentNum);

    /**
     * 增加一个学生信息
     * @param student 学生对象
     */
    @POST
    @Path("/addStu")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void addStu(Student student);

    /**
     * 删除一个学生信息
     * @param studentNum 学生学号
     */
    @DELETE
    @Path("/deleteStu/{studentNum}")
    public void deleteStu(@PathParam("studentNum") String studentNum);

}

```

### 3. 学生服务实现 StudentServiceImpl.java
```java
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
    @Path("/deleteStu/{studentNum}")
    public void deleteStu(@PathParam("studentNum") String studentNum) {

    }


}
```


