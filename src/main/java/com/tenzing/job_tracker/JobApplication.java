package com.tenzing.job_tracker;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String status;
    private LocalDate dateApplied;
    private String notes;
    private String url;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateApplied() { return dateApplied; }
    public void setDateApplied(LocalDate dateApplied) { this.dateApplied = dateApplied; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
