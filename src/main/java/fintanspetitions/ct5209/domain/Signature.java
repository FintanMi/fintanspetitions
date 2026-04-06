package fintanspetitions.ct5209.domain;

import java.util.UUID;
import java.time.LocalDateTime;

public class Signature {
    private UUID id;
    private String name;
    private String email;
    private LocalDateTime signedAt;

    public Signature() {
        this.id = UUID.randomUUID();
        this.signedAt = LocalDateTime.now();
    }

    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }
}
