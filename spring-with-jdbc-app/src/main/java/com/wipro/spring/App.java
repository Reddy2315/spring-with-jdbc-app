package com.wipro.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.spring.dao.IDoctorDao;

public class App 
{
    public static void main( String[] args )
    {      
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-bean-config.xml");
    	
    	IDoctorDao dao=ctx.getBean("doctorDao", IDoctorDao.class);
    	
    	Doctor doctor=new Doctor();
    	doctor.setRegNo(1002L);
    	doctor.setName("Mohan");
    	doctor.setSpecilization("Ortho");
    	
    	System.out.println("Doctor info saved with id:"+dao.addDoctor(doctor));
    	
    	Doctor obtainedDoctor = dao.getDoctor(1001);
    	
    	System.out.println(obtainedDoctor);
    	
    	List<Doctor> list=dao.getAllDoctors();
    	
    	for(Doctor d:list) {
    		System.out.println("Doctor is: "+d);
    	}
    	
    	
    }
}
