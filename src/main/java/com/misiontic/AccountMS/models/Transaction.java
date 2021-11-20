package com.misiontic.AccountMS.models;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String id;
    private String usernameOrigin;
    private String usernameDestiny;
    private Integer value;
    private Date date;

    public Transaction(String id, String usernameOrigin, String usernameDestiny, Date date) {
        this.id = id;
        this.usernameOrigin = usernameOrigin;
        this.usernameDestiny = usernameDestiny;
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public String getUsernameOrigin() {
        return usernameOrigin;
    }
    public void setUsernameOrigin(String usernameOrigin) {
        this.usernameOrigin = usernameOrigin;
    }
    public String getUsernameDestiny() {
        return usernameDestiny;
    }
    public void setUsernameDestiny(String usernameDestiny) {
        this.usernameDestiny = usernameDestiny;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
