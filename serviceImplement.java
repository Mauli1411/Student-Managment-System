package management.system.service;

import java.util.List;
import management.system.service.*;
import management.system.repository.*;
import management.system.entity.student;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class serviceImplement implements service {

	
private studentRepository studentRepository;
		
		public serviceImplement(studentRepository studentRepository) {
			super();
			this.studentRepository = studentRepository;
		}

		@Override
		public List<student> getAllStudents() {
			return studentRepository.findAll();
		}

		@Override
		public student saveStudent(student student) {
			return studentRepository.save(student);
		}

		@Override
		public student getStudentById(Long id) {
			return studentRepository.findById(id).get();
		}

		@Override
		public student updateStudent(student student) {
			return studentRepository.save(student);
		}

		@Override
		public void deleteStudentById(Long id) {
			studentRepository.deleteById(id);	
		}

	
}
