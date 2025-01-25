package vcet.cse.placement.automation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vcet.cse.placement.automation.Model.Students;
import vcet.cse.placement.automation.service.StudentsService;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cse")
public class HomeController {
    
    @Autowired
    private StudentsService studentsService;
    
    @GetMapping("/students")
    public List<Students> getStudents() {
        return studentsService.getStudents();
    }

    @PostMapping("/students")
    public void addStudents(@RequestBody Students students) {
        studentsService.addStudents(students);
    }

    @PostMapping("/leetcodeUpdate/{universityNo}")
    public void updateLeetcode(
            @RequestBody Students leetcodeUpdate,
            @PathVariable Long universityNo) {
        studentsService.updateLeetcode(universityNo, leetcodeUpdate);
    }

    @PostMapping("/aptiUpdate/{universityNo}")
    public void updateAptitudeScores(
            @RequestBody Students aptiUpdate,
            @PathVariable Long universityNo) {
        studentsService.updateAptitudeScores(universityNo, aptiUpdate);
    }

    @PostMapping("/techAptiUpdate/{universityNo}")
    public void updateTechAptitudeScores(
            @RequestBody Students techAptiUpdate,
            @PathVariable Long universityNo) {
        studentsService.updateTechAptitudeScores(universityNo, techAptiUpdate);
    }

    @PostMapping("/progUpdate/{universityNo}")
    public void updateProgrammingScores(
            @RequestBody Students progUpdate,
            @PathVariable Long universityNo) {
        studentsService.updateProgrammingScores(universityNo, progUpdate);
    }

    @GetMapping("/student/{universityNo}")
    public Students getStudentByUniversityNo(@PathVariable Long universityNo) {
        return studentsService.getStudentByUniversityNo(universityNo);
    }

    @GetMapping("/student/{universityNo}/leetcode")
    public Map<String, Object> getStudentLeetcodeData(@PathVariable Long universityNo) {
        return studentsService.getStudentLeetcodeData(universityNo);
    }

    @GetMapping("/student/{universityNo}/aptitude")
    public Map<String, Object> getStudentAptitudeData(@PathVariable Long universityNo) {
        return studentsService.getStudentAptitudeData(universityNo);
    }

    @GetMapping("/student/{universityNo}/technical")
    public Map<String, Object> getStudentTechnicalData(@PathVariable Long universityNo) {
        return studentsService.getStudentTechnicalData(universityNo);
    }

    @GetMapping("/student/{universityNo}/programming")
    public Map<String, Object> getStudentProgrammingData(@PathVariable Long universityNo) {
        return studentsService.getStudentProgrammingData(universityNo);
    }
    @GetMapping("/students/eligibility")
    public Map<String, Object> getEligibility() {
        return studentsService.getEligibility();
    }
    @GetMapping("/students/genderScore")
    public Map<String, Object> getGenderScore() {
        return studentsService.getGenderScore();
    }
    @GetMapping("/students/charts")
    public Map<String, Object> getChartData() {
        return studentsService.getChartData();
    }
    @GetMapping("/search")
    public List<Students> searchStudents(@RequestParam("q") String query) {
        return studentsService.searchStudents(query);
    }
    @GetMapping("/toppers")
    public ArrayList<Map<String,Object>> getToppers(){
        return studentsService.getToppers();
    }
 

    @GetMapping("/students/scores/apptitude")
    public List<Map<String, Object>> getAllStudentScores() {
        return studentsService.getAllAptitudeScores();
    }
    @GetMapping("/students/scores/leetcode")
    public List<Map<String, Object>> getAllLeetcodeScores() {
        return studentsService.getAllLeetcodeScores();
    }
}