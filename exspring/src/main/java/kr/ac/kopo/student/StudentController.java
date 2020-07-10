package kr.ac.kopo.student;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	@Resource(name="studentService")
	private StudentService studentService;

	@RequestMapping("/student/list.do")
	public String list(Map modelMap) {
		List<StudentVo> list = studentService.selectStudentList();
		modelMap.put("stuList", list);
		return "Student/StudentList";
	}

	@RequestMapping(value = "/student/add.do", method = RequestMethod.GET)
	public String addform() {
		return "Student/StudentAddForm";
	}

	@RequestMapping(value = "/student/add.do", method = RequestMethod.POST)
	public String add(StudentVo vo) {

		int num = studentService.insertStudent(vo);
		System.out.println(num + "개의 레코드 추가");
		return "redirect:/student/list.do";
	}

	@RequestMapping(value = "/student/edit.do", method = RequestMethod.GET)
	public String editform(String stuNo, Map modelMap) {
		StudentVo vo = studentService.selectStudent(stuNo);
		modelMap.put("stuVo", vo);
		return "Student/StudentEditForm";
	}

	@RequestMapping(value = "/student/edit.do", method = RequestMethod.POST)
	public String edit(StudentVo vo) {
		
		int num = studentService.updateStudentVo(vo);
		System.out.println(num + "개의 레코드 변경");
		return "redirect:/student/list.do";

	}

	@RequestMapping("/student/del.do")
	public String deleteStudent(String stuNo) {
		int num = studentService.deleteStudent(stuNo);
		System.out.println(num + "명의 회원삭제");
		return "redirect:/student/list.do";
	}
}
