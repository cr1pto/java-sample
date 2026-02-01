package com.cr1pto.sample.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 600)
    private String name;
    private Date storeNumber;
    private ManagerType managerType;
    private boolean canOpenStore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Date storeNumber) {
        this.storeNumber = storeNumber;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public boolean isCanOpenStore() {
        return canOpenStore;
    }

    public void setCanOpenStore(boolean canOpenStore) {
        this.canOpenStore = canOpenStore;
    }
}
