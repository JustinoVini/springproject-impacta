package br.com.impacta.treinamentos.springproject.controller;

import br.com.impacta.treinamentos.springproject.entity.Student;
import br.com.impacta.treinamentos.springproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author vinicius
 *
 * @Controller
 *
 * Esta camada é responsável por processar a entrada do usuário e retornar
 * a resposta correta ao usuário
 */
@Controller
@RequestMapping("/students/")
public class StudentController {

    private final StudentRepository studentRepository;

    /**
     * @autowired annotation utilizada para injeção da dependencia no contrutor.
     * @param studentRepository
     */
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * @GetMapping A anotação @GetMapping é uma versão especializada da anotação
     * @RequestMapping que atua como um atalho para @RequestMapping(method = RequestMethod. GET)
     * @PostMapping O @PostMapping é uma versão especializada da anotação
     * @RequestMapping que atua como um atalho para @RequestMapping(method = RequestMethod.
     * @param student
     * @return add-student o mesmo adiciona um estudante no sistema.
     */
    @GetMapping("signup")
    public String showSignForm(Student student){
        return "add-student";
    }

    /*
     * Método abaixo TODO explicar
     */
    @GetMapping("list")
    public String showUpdateForm(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    /*
     * Método abaixo TODO explicar
     */
    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-student";
        }

        studentRepository.save(student);
        return "redirect:list";
    }

    /*
     * Método abaixo TODO explicar
     */
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de estudante inválido!:" + id));
                model.addAttribute("student", student);
                return "update-student";
    }

    /*
    * Método abaixo TODO explicar
    */
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-student";
        }

        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    /*
     * Método abaixo TODO explicar
     */

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Id de estudante inválido!:" + id));
                studentRepository.delete(student);
                model.addAttribute("students", studentRepository.findAll());
                return "index";
    }
}
