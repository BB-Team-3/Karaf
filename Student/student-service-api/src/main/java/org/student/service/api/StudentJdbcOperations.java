package org.student.service.api;

public interface StudentJdbcOperations {
	
	void createTable() throws Exception;

	void displayStudent() throws Exception;

	void addStudent() throws Exception;

	void updateStudent() throws Exception;

	void deleteStudent() throws Exception;
}
