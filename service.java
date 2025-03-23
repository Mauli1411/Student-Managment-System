package management.system.service;
import java.util.List;
import management.system.entity.*;
public interface service {
	
	
	

	
		List<student> getAllStudents();
		
		student saveStudent(student student);
		
		student getStudentById(Long id);
		
		student updateStudent(student student);
		
		void deleteStudentById(Long id);
	}

