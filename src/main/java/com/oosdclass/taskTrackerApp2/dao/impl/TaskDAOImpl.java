package com.oosdclass.taskTrackerApp2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.scheduling.config.Task;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;

public class TaskDAOImpl implements TaskDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Task> retrieveAllTasks() {
		try {
			String sql = "select * from task";
			List<Task> tasklist = jdbcTemplate.query(sql, new ResultSetExtractor<List<Task>>() {
				
				@Override
				public List<Task> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					List<Task> list = new ArrayList<Task>();
					while (rs.next()) {
						Task task = new Task(null);
						task.setTaskId(rs.getInt(1));
						task.setTaskDescription(rs.getString(2));
						task.setAssignedTo(rs.getString(3));
						task.setStatus(rs.getString(4));
						list.add(task);
					}
					return list;
				}
			});
		return tasklist;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
}



