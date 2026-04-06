package fintanspetitions.ct5209.model;

import java.time.LocalDate;
import java.util.UUID;

import fintanspetitions.ct5209.domain.Signature;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private UUID id;
    private String title;
    private String description;
    private String author;
    private String category;
    private LocalDate createdAt;
    private List<Signature> signatures;

    public Petition() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDate.now();
        this.signatures = new ArrayList<>();
    }

    public Petition(String title, String description, String author, String category) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = category;
    }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }

    public int signatureCount() {
        return signatures.size();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }
    
    public int getSignatureCount() { return this.signatures != null ? this.signatures.size() : 0; }
}
