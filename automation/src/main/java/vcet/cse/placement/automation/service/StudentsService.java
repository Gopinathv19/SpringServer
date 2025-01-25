package vcet.cse.placement.automation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vcet.cse.placement.automation.Model.Students;
import vcet.cse.placement.automation.repo.StudentsDatabaseCollector;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@CrossOrigin
@Service
public class StudentsService {
    @Autowired
    private StudentsDatabaseCollector studentsDB;
    
    public List<Students> getStudents() {
        return studentsDB.findAll();
    }

    public void addStudents(Students students) {
        studentsDB.save(students);
    }

    public List<Students> getStudentsWithLeetcode() {
        return studentsDB.findAll();   
    }

    public Students getStudentWithLeetcode(Long universityNo) {
        return studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    public Map<String, Object> getEligibility() {
        Map<String, Object> eligibility = new HashMap<>();
        eligibility.put("eligible",189);
        eligibility.put("notEligible",10);
        return eligibility;
    }
    public Map<String, Object> getGenderScore() {
        Map<String, Object> genderScore = new HashMap<>();
        genderScore.put("boys", 189);
        genderScore.put("girls", 10);
        System.out.println("Gender Score Data: " + genderScore);
        return genderScore;
    }
         
    @Transactional
    public void updateLeetcode(Long universityNo, Students leetcodeUpdate) {
        Students student = studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        student.setLeetcodeUsername(leetcodeUpdate.getLeetcodeUsername());
        student.setEasyProblemsSolved(leetcodeUpdate.getEasyProblemsSolved());
        student.setMediumProblemsSolved(leetcodeUpdate.getMediumProblemsSolved());
        student.setHardProblemsSolved(leetcodeUpdate.getHardProblemsSolved());
         
        student.setLeetcodeScore(leetcodeUpdate.getLeetcodeScore());
        student.setEntryMonth(LocalDate.now().withDayOfMonth(1));
        
        studentsDB.save(student);
    }

    @Transactional
    public void updateAptitudeScores(Long universityNo, Students aptiUpdate) {
        Students student = studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        student.setAptiTest1Score(aptiUpdate.getAptiTest1Score());
        student.setAptiTest2Score(aptiUpdate.getAptiTest2Score());
        student.setAptiTest3Score(aptiUpdate.getAptiTest3Score());
        
        studentsDB.save(student);
    }

    @Transactional
    public void updateTechAptitudeScores(Long universityNo, Students techAptiUpdate) {
        Students student = studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        student.setTechAptiTest1Score(techAptiUpdate.getTechAptiTest1Score());
        student.setTechAptiTest2Score(techAptiUpdate.getTechAptiTest2Score());
        student.setTechAptiTest3Score(techAptiUpdate.getTechAptiTest3Score());
        
        studentsDB.save(student);
    }

    @Transactional
    public void updateProgrammingScores(Long universityNo, Students progUpdate) {
        Students student = studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        student.setProgrammingTest1Score(progUpdate.getProgrammingTest1Score());
        student.setProgrammingTest2Score(progUpdate.getProgrammingTest2Score());
        student.setProgrammingTest3Score(progUpdate.getProgrammingTest3Score());
        
        studentsDB.save(student);
    }

    public Students getStudentByUniversityNo(Long universityNo) {
        return studentsDB.findById(universityNo)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Map<String, Object> getStudentLeetcodeData(Long universityNo) {
        Students student = getStudentByUniversityNo(universityNo);
        Map<String, Object> leetcodeData = new HashMap<>();
        
        leetcodeData.put("universityNo", student.getUniversityNo());
        leetcodeData.put("name", student.getName());
        leetcodeData.put("username", student.getLeetcodeUsername());
        leetcodeData.put("easyProblemsSolved", student.getEasyProblemsSolved());
        leetcodeData.put("mediumProblemsSolved", student.getMediumProblemsSolved());
        leetcodeData.put("hardProblemsSolved", student.getHardProblemsSolved());
         
        leetcodeData.put("leetcodeScore", student.getLeetcodeScore());
        
        return leetcodeData;
    }

    public Map<String, Object> getStudentAptitudeData(Long universityNo) {
        Students student = getStudentByUniversityNo(universityNo);
        Map<String, Object> aptitudeData = new HashMap<>();
        
        aptitudeData.put("universityNo", student.getUniversityNo());
        aptitudeData.put("name", student.getName());
        aptitudeData.put("aptiTest1Score", student.getAptiTest1Score());
        aptitudeData.put("aptiTest2Score", student.getAptiTest2Score());
        aptitudeData.put("aptiTest3Score", student.getAptiTest3Score());
        
        return aptitudeData;
    }

    public Map<String, Object> getStudentTechnicalData(Long universityNo) {
        Students student = getStudentByUniversityNo(universityNo);
        Map<String, Object> technicalData = new HashMap<>();
        
        technicalData.put("universityNo", student.getUniversityNo());
        technicalData.put("name", student.getName());
        technicalData.put("techAptiTest1Score", student.getTechAptiTest1Score());
        technicalData.put("techAptiTest2Score", student.getTechAptiTest2Score());
        technicalData.put("techAptiTest3Score", student.getTechAptiTest3Score());
        
        return technicalData;
    }

    public Map<String, Object> getStudentProgrammingData(Long universityNo) {
        Students student = getStudentByUniversityNo(universityNo);
        Map<String, Object> programmingData = new HashMap<>();
        
        programmingData.put("universityNo", student.getUniversityNo());
        programmingData.put("name", student.getName());
        programmingData.put("programmingTest1Score", student.getProgrammingTest1Score());
        programmingData.put("programmingTest2Score", student.getProgrammingTest2Score());
        programmingData.put("programmingTest3Score", student.getProgrammingTest3Score());
        
        return programmingData;
    }

    public Map<String, Object> getChartData() {
        Map<String, Object> chartData = new HashMap<>();
        
        // Donut chart data (Leetcode difficulty distribution)
        List<Integer> donutData = Arrays.asList(40, 35, 25);  // Easy, Medium, Hard percentages
        
        // Bar chart data (Aptitude performance)
        List<Integer> barData = Arrays.asList(75, 82, 68);  // Verbal, Logical, Numerical scores
        
        // Line chart data (Weekly performance)
        Map<String, List<Integer>> lineData = new HashMap<>();
        lineData.put("leetcode", Arrays.asList(65, 70, 75, 80, 85, 90));  // Weekly LeetCode scores
        lineData.put("aptitude", Arrays.asList(60, 65, 75, 80, 85, 88));  // Weekly Aptitude scores
        lineData.put("overall", Arrays.asList(62, 68, 75, 80, 85, 89));   // Weekly Overall scores
        
        // Combine all data
        chartData.put("donutData", donutData);
        chartData.put("barData", barData);
        chartData.put("lineData", lineData);
        
        return chartData;
    }
        public List<Students> searchStudents(String query) {
            if (query == null || query.trim().isEmpty()) {
                return Collections.emptyList();
            }
            return studentsDB.searchStudents(query.trim());

        }

        public ArrayList<Map<String,Object>> getToppers(){
            ArrayList<Map<String,Object>> toppers= new ArrayList<>();
            Map<String,Object> apptitudeTopper = new HashMap<>();
            apptitudeTopper.put("name","Gopinath");
            apptitudeTopper.put("title","leetcode Topper");
            apptitudeTopper.put("univNo","913122104038");
            apptitudeTopper.put("greets","Congratulations Gopinath");
            Map<String,Object> leetcodeTopper=new HashMap<>();
            leetcodeTopper.put("name","nivetha");
            leetcodeTopper.put("title","Apptitude Topper");
            leetcodeTopper.put("univNo","91346236");
            leetcodeTopper.put("greets","Contratulations Nivetha");
            toppers.add(apptitudeTopper);
            toppers.add(leetcodeTopper);
            return toppers;
            }

    public List<Map<String, Object>> getAllAptitudeScores() {
        List<Map<String, Object>> scores = studentsDB.findAllAptitudeScores();
        
        // Calculate total and average for each student
        scores.forEach(score -> {
            Double test1 = (Double) score.get("test1");
            Double test2 = (Double) score.get("test2");
            Double test3 = (Double) score.get("test3");
            score.put("totalScore", test1 + test2 + test3);
        });
        
        return scores;
    }

    public List<Map<String, Object>> getAllLeetcodeScores() {
        List<Map<String, Object>> scores = studentsDB.findAllLeetcodeScores();
        
        // Add percentage calculations
        scores.forEach(score -> {
            Integer easy = (Integer) score.get("easy");
            Integer medium = (Integer) score.get("medium");
            Integer hard = (Integer) score.get("hard");
            score.put("easy",easy);
            score.put("medium",medium);
            score.put("hard",hard);
        });
        
        return scores;
    }
}

