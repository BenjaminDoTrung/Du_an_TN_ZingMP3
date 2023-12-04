package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class MailStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contentEmail;
    private String receiptEmail;

    public MailStructure(String title, String contentEmail, String receiptEmail) {
        this.title = title;
        this.contentEmail = contentEmail;
        this.receiptEmail = receiptEmail;
    }

    public MailStructure() {

    }
}
