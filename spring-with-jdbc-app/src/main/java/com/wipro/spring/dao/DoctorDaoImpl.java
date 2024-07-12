package com.wipro.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.wipro.spring.Doctor;

public class DoctorDaoImpl implements IDoctorDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public long addDoctor(Doctor doctor) {

		return jdbcTemplate.update("insert into doctor values(?,?,?)", doctor.getRegNo(), doctor.getName(),
				doctor.getSpecilization());
	}

	public long updateDoctor(Doctor doctor) {
		return jdbcTemplate.update("update doctor set name=?,specilization=? where regno=?", doctor.getName(),
				doctor.getSpecilization(), doctor.getRegNo());
	}

	public Doctor getDoctor(long regNo) {
		return jdbcTemplate.query("select *from doctor where regno=" + regNo, new ResultSetExtractor<Doctor>() {

			Doctor doctor = new Doctor();

			public Doctor extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					doctor.setRegNo(rs.getLong(1));
					doctor.setName(rs.getString(2));
					doctor.setSpecilization(rs.getString(3));
				}

				return doctor;

			}

		});
	}

	public List<Doctor> getAllDoctors() {

		return jdbcTemplate.query("select *from doctor", new RowMapper<Doctor>() {

			public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {

				Doctor d = new Doctor();
				d.setRegNo(rs.getLong(1));
				d.setName(rs.getString(2));
				d.setSpecilization(rs.getString(3));
				return d;
			}

		});

	}

}
