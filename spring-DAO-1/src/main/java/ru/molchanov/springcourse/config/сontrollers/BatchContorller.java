package ru.molchanov.springcourse.config.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.molchanov.springcourse.config.DAO.PersonDAO;

@Controller
@RequestMapping("/test-batch-update")
public class BatchContorller {
    private final PersonDAO personDAO;

    @Autowired
    public BatchContorller(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index() {
        return "batch/index";
    }
    @GetMapping("/without")
    public String withoutBatch() {
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }
    @GetMapping("/with")
    public String withBatch() {
        personDAO.testBatchUpdate();
        return "redirect:/people";
}
}
