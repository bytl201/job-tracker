package com.tenzing.job_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    private JobRepository repository;

    // show all applications
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("jobs", repository.findByCompanyContainingIgnoreCase(search));
        } else {
            model.addAttribute("jobs", repository.findAllByOrderByDateAppliedDesc());
        }
        model.addAttribute("search", search);
        model.addAttribute("totalCount", repository.count());
        model.addAttribute("appliedCount", repository.countByStatus("Applied"));
        model.addAttribute("interviewCount", repository.countByStatus("Interview"));
        model.addAttribute("offerCount", repository.countByStatus("Offer"));
        model.addAttribute("rejectedCount", repository.countByStatus("Rejected"));
        return "index";
    }

    // show add form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("job", new JobApplication());
        return "add";
    }

    // save new application
    @PostMapping("/add")
    public String addJob(@ModelAttribute JobApplication job) {
        repository.save(job);
        return "redirect:/";
    }

    // delete application
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    // show edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("job", repository.findById(id).orElseThrow());
        return "edit";
    }

    // save edited application
    @PostMapping("/edit/{id}")
    public String editJob(@PathVariable Long id, @ModelAttribute JobApplication job) {
        job.setId(id);
        repository.save(job);
        return "redirect:/";
    }
}