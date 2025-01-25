package vcet.cse.placement.automation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Students {
    
    @Id
    @NotNull
    @Column(name = "university_no", unique = true)
    private Long universityNo;

    @NotNull
    @Column(name = "class_name")
    private String className;

    @NotNull
    @Column(name = "roll_no", unique = true)
    private String rollNo;

    @NotNull
    private String name;

    @NotNull
    private String gender;

    // Leet code data  
    private String leetcodeUsername;
    
    @Column(name = "entry_month")
    private LocalDate entryMonth;

    @Column(name = "easy_solved")
    private Integer easyProblemsSolved = 0;

    @Column(name = "medium_solved")
    private Integer mediumProblemsSolved = 0;

    @Column(name = "hard_solved")
    private Integer hardProblemsSolved = 0;

 

    @Column(name = "leetcode_score")
    private Double leetcodeScore = 0.0;

    // Aptitude Test Scores
    @Column(name = "apti_test1")
    private Double aptiTest1Score = 0.0;

    @Column(name = "apti_test2")
    private Double aptiTest2Score = 0.0;

    @Column(name = "apti_test3")
    private Double aptiTest3Score = 0.0;

    // Technical Aptitude Test Scores
    @Column(name = "tech_apti_test1")
    private Double techAptiTest1Score = 0.0;

    @Column(name = "tech_apti_test2")
    private Double techAptiTest2Score = 0.0;

    @Column(name = "tech_apti_test3")
    private Double techAptiTest3Score = 0.0;

    // Programming Test Scores
    @Column(name = "prog_test1")
    private Double programmingTest1Score = 0.0;

    @Column(name = "prog_test2")
    private Double programmingTest2Score = 0.0;

    @Column(name = "prog_test3")
    private Double programmingTest3Score = 0.0;

    // Constructors
    public Students() {
        this.entryMonth = LocalDate.now().withDayOfMonth(1);
    }

    public Students(Long universityNo, String className, String rollNo, String name, String gender) {
        this.universityNo = universityNo;
        this.className = className;
        this.rollNo = rollNo;
        this.name = name;
        this.gender = gender;
        this.entryMonth = LocalDate.now().withDayOfMonth(1);
    }

    // Getters and Setters for all fields
    public Long getUniversityNo() {
        return universityNo;
    }

    public void setUniversityNo(Long universityNo) {
        this.universityNo = universityNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLeetcodeUsername() {
        return leetcodeUsername;
    }

    public void setLeetcodeUsername(String leetcodeUsername) {
        this.leetcodeUsername = leetcodeUsername;
    }

    public LocalDate getEntryMonth() {
        return entryMonth;
    }

    public void setEntryMonth(LocalDate entryMonth) {
        this.entryMonth = entryMonth;
    }

    public Integer getEasyProblemsSolved() {
        return easyProblemsSolved;
    }

    public void setEasyProblemsSolved(Integer easyProblemsSolved) {
        this.easyProblemsSolved = easyProblemsSolved;
    }

    public Integer getMediumProblemsSolved() {
        return mediumProblemsSolved;
    }

    public void setMediumProblemsSolved(Integer mediumProblemsSolved) {
        this.mediumProblemsSolved = mediumProblemsSolved;
    }

    public Integer getHardProblemsSolved() {
        return hardProblemsSolved;
    }

    public void setHardProblemsSolved(Integer hardProblemsSolved) {
        this.hardProblemsSolved = hardProblemsSolved;
    }

 

    public Double getLeetcodeScore() {
        return leetcodeScore;
    }

    public void setLeetcodeScore(Double leetcodeScore) {
        this.leetcodeScore = leetcodeScore;
    }

    public Double getAptiTest1Score() {
        return aptiTest1Score;
    }

    public void setAptiTest1Score(Double aptiTest1Score) {
        this.aptiTest1Score = aptiTest1Score;
    }

    public Double getAptiTest2Score() {
        return aptiTest2Score;
    }

    public void setAptiTest2Score(Double aptiTest2Score) {
        this.aptiTest2Score = aptiTest2Score;
    }

    public Double getAptiTest3Score() {
        return aptiTest3Score;
    }

    public void setAptiTest3Score(Double aptiTest3Score) {
        this.aptiTest3Score = aptiTest3Score;
    }

    public Double getTechAptiTest1Score() {
        return techAptiTest1Score;
    }

    public void setTechAptiTest1Score(Double techAptiTest1Score) {
        this.techAptiTest1Score = techAptiTest1Score;
    }

    public Double getTechAptiTest2Score() {
        return techAptiTest2Score;
    }

    public void setTechAptiTest2Score(Double techAptiTest2Score) {
        this.techAptiTest2Score = techAptiTest2Score;
    }

    public Double getTechAptiTest3Score() {
        return techAptiTest3Score;
    }

    public void setTechAptiTest3Score(Double techAptiTest3Score) {
        this.techAptiTest3Score = techAptiTest3Score;
    }

    public Double getProgrammingTest1Score() {
        return programmingTest1Score;
    }

    public void setProgrammingTest1Score(Double programmingTest1Score) {
        this.programmingTest1Score = programmingTest1Score;
    }

    public Double getProgrammingTest2Score() {
        return programmingTest2Score;
    }

    public void setProgrammingTest2Score(Double programmingTest2Score) {
        this.programmingTest2Score = programmingTest2Score;
    }

    public Double getProgrammingTest3Score() {
        return programmingTest3Score;
    }

    public void setProgrammingTest3Score(Double programmingTest3Score) {
        this.programmingTest3Score = programmingTest3Score;
    }
}