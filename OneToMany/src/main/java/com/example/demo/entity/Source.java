package com.example.demo.entity;


import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="source")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id", nullable = false)
    private Long id;

    @Column(name="filename", length = 500)
    private String filename;

    @Lob
    @Column(name="pdf", columnDefinition = "LONGBLOB")
    private byte[] pdf;

    @Lob
    @Column(name="doc", columnDefinition = "LONGBLOB")
    private byte[] doc;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name="username")
    private Account account;

    public Source() {
    }

    public Source(Long id, String filename, byte[] pdf, byte[] doc, boolean status, Account account) {
        this.id = id;
        this.filename = filename;
        this.pdf = pdf;
        this.doc = doc;
        this.status = status;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public byte[] getDoc() {
        return doc;
    }

    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", pdf=" + Arrays.toString(pdf) +
                ", doc=" + Arrays.toString(doc) +
                ", status=" + status +
                '}';
    }
}
