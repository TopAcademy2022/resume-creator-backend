package resume.creator.backend.top.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resume")
public class ResumeController {
    @PostMapping
    public String PostResume(Object resume, Object user) {
        if (resume.toString() == "User") {
            return "success";
        }

        return "failed";
    }
}
