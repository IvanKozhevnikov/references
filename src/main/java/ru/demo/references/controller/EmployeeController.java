package ru.demo.references.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demo.references.model.Employee;
import ru.demo.references.service.EmployeeService;
import ru.demo.references.service.ReferenceService;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final ReferenceService referenceService;

    //private final AccidentTypeService accidentTypeService;

   // private final RuleService ruleService;

    @GetMapping("/createEmployee")
    public String viewCreateAccident(Model model) {
        //model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "employees/createEmployee";
    }

    @PostMapping("/saveEmployee")
    public String save(@ModelAttribute Employee employee, Model model, HttpServletRequest httpServletRequest) {
        //String[] ids = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ids));
        employeeService.create(employee);
        model.addAttribute("message");
        return "redirect:/index";
    }

    @GetMapping("/formUpdateEmployee")
    public String update(@RequestParam("id") int id, Model model) {
        var employeeOptional = employeeService.findById(id);
        if (employeeOptional.isEmpty()) {
            model.addAttribute("message", "Заявка с указанным идентификатором не найдена");
            return "errors/404";
        }
        model.addAttribute("employee", employeeService.findById(id).get());
        model.addAttribute("types", referenceService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "employees/updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String update(@ModelAttribute Employee employee, Model model, HttpServletRequest httpServletRequest) {
        String[] ds = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ds));
        var isUpdated = employeeService.update(employee);
        if (!isUpdated) {
            model.addAttribute("message", "Обновление не выполнено");
            return "errors/404";
        }
        return "redirect:/index";
    }
}


