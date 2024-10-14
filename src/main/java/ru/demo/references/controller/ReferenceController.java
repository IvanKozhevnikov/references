package ru.demo.references.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demo.references.model.Reference;
import ru.demo.references.service.ReferenceService;

@Controller
@AllArgsConstructor
@RequestMapping("/references")
public class ReferenceController {

    private final ReferenceService referenceService;


    @GetMapping({"/references"})
    public String index(Model model) {
        model.addAttribute("references", referenceService.findAll());
        return "references/references";
    }

    @GetMapping("/createReference")
    public String viewCreateAccident(Model model) {
        //model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("references", referenceService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "references/createReference";
    }

    @PostMapping("/saveReference")
    public String save(@ModelAttribute Reference reference, Model model, HttpServletRequest httpServletRequest) {
        //String[] ids = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ids));
        referenceService.create(reference);
        model.addAttribute("message");
        return "redirect:/references/references";
    }

    @PostMapping("/deleteReference")
    public String delete(@RequestParam("id") int id) {
        referenceService.delete(id);
        return "redirect:/references/references";
    }

    @GetMapping("/formUpdateReference")
    public String update(@RequestParam("id") int id, Model model) {
        var referenceOptional = referenceService.findById(id);
        if (referenceOptional.isEmpty()) {
            model.addAttribute("message", "Заявка с указанным идентификатором не найдена");
            return "errors/404";
        }
        model.addAttribute("reference", referenceService.findById(id).get());
        //model.addAttribute("types", accidentTypeService.findAll());
        //model.addAttribute("rules", ruleService.findAll());
        return "references/updateReference";
    }

    @PostMapping("/updateReference")
    public String update(@ModelAttribute Reference reference, Model model, HttpServletRequest httpServletRequest) {
        String[] ds = httpServletRequest.getParameterValues("rIds");
        //employee.setRules(ruleService.findByIds(ds));
        var isUpdated = referenceService.update(reference);
        if (!isUpdated) {
            model.addAttribute("message", "Обновление не выполнено");
            return "errors/404";
        }
        return "redirect:/references/references";
    }
}




