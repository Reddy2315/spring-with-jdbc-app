package com.wipro.spring.dao;

import java.util.List;

import com.wipro.spring.Doctor;

public interface IDoctorDao {
	
	public long addDoctor(Doctor doctor);
	public long updateDoctor(Doctor doctor);
	public Doctor getDoctor(long regNo);
	public List<Doctor> getAllDoctors();

}
