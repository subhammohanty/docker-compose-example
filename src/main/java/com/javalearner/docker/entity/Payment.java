package com.javalearner.docker.entity;

import com.javalearner.docker.dto.UPIMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;
    private String user;
    private double amount;
    private String sourceAc;
    private String destAc;
    @Enumerated(EnumType.STRING)
    private UPIMode upiMode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSourceAc() {
        return sourceAc;
    }

    public void setSourceAc(String sourceAc) {
        this.sourceAc = sourceAc;
    }

    public String getDestAc() {
        return destAc;
    }

    public void setDestAc(String destAc) {
        this.destAc = destAc;
    }

    public UPIMode getUpiMode() {
        return upiMode;
    }

    public void setUpiMode(UPIMode upiMode) {
        this.upiMode = upiMode;
    }
}
