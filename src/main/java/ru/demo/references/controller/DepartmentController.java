package ru.demo.references.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demo.references.model.Department;
import ru.demo.references.model.Employee;
import ru.demo.references.service.DepartmentService;
import ru.demo.references.service.EmployeeService;

@Controller
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping({"/departments"})
    public String index(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "departments/departments";
    }

    @GetMapping("/createDepartment")
    public String viewCreateAccident(Model model) {
        //model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "departments/createDepartment";
    }

    @PostMapping("/saveDepartment")
    public String save(@ModelAttribute Department department, Model model, HttpServletRequest httpServletRequest) {
        //String[] ids = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ids));
        departmentService.create(department);
        model.addAttribute("message");
        return "redirect:/departments/departments";
    }

    @PostMapping("/deleteDepartment")
    public String delete(@RequestParam("id") int id) {
        departmentService.delete(id);
        return "redirect:/departments/departments";
    }

    @GetMapping("/formUpdateDepartment")
    public String update(@RequestParam("id") int id, Model model) {
        var departmentOptional = departmentService.findById(id);
        if (departmentOptional.isEmpty()) {
            model.addAttribute("message", "Заявка с указанным идентификатором не найдена");
            return "errors/404";
        }
        model.addAttribute("department", departmentService.findById(id).get());
        //model.addAttribute("types", accidentTypeService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "departments/updateDepartment";
    }

    @PostMapping("/updateDepartment")
    public String update(@ModelAttribute Department department, Model model, HttpServletRequest httpServletRequest) {
        String[] ds = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ds));
        var isUpdated = departmentService.update(department);
        if (!isUpdated) {
            model.addAttribute("message", "Обновление не выполнено");
            return "errors/404";
        }
        return "redirect:/departments/departments";
    }
}



