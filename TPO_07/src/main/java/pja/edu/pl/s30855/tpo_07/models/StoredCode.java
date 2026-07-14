package pja.edu.pl.s30855.tpo_07.models;


import java.io.Serializable;
import java.time.LocalDateTime;


public class StoredCode implements Serializable {
    private String id;
    private String original;
    private String formatted;
    private LocalDateTime expiresAt;

    public StoredCode(String id, String original, String formatted, LocalDateTime expiresAt) {
        this.id = id;
        this.original = original;
        this.formatted = formatted;
        this.expiresAt = expiresAt;
    }

    public String getId() { return id; }
    public String getOriginal() { return original; }
    public String getFormatted() { return formatted; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
}
