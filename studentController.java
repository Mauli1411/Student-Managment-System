package management.system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import management.system.service.*;
import management.system.entity.*;
@Controller
public class studentController {
	
private service studentService;

		public studentController(service studentService) {
			super();
			this.studentService = studentService;
		}
		
		// handler method to handle list students and return mode and view
		@GetMapping("/students")
		public String listStudents(Model model) {
			model.addAttribute("students", studentService.getAllStudents());
			return "students";
		}
		
		@GetMapping("/students/new")
		public String createStudentForm(Model model) {
			
			// create student object to hold student form data
			student student = new student();
			model.addAttribute("student", student);
			return "createStudent";
			
		}
		
		@PostMapping("/students")
		public String saveStudent(@ModelAttribute("student") student student) {
			studentService.saveStudent(student);
			return "redirect:/students";
		}
		
		@GetMapping("/students/edit/{id}")
		public String editStudentForm(@PathVariable Long id, Model model) {
			model.addAttribute("student", studentService.getStudentById(id));
			return "editStudent";
		}

		@PostMapping("/students/{id}")
		public String updateStudent(@PathVariable Long id,@ModelAttribute("student") student student,Model model) {
			
			// get student from database by id
			student existingStudent = studentService.getStudentById(id);
			existingStudent.setId(id);
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setEmail(student.getEmail());
			
			// save updated student object
			studentService.updateStudent(existingStudent);
			return "redirect:/students";		
		}
		
		// handler method to handle delete student request
		
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			studentService.deleteStudentById(id);
			return "redirect:/students";
		}
		
	}

