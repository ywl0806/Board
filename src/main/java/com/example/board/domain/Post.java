package com.example.board.domain;

import com.example.board.validation.Group2;
import com.example.board.validation.Gruop1;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @Column
    @NotNull
    private String id = null;

    @Column
    @NotEmpty(groups = Gruop1.class)
    @Size(min = 1, max = 20, groups = Group2.class)
    private String author = null;

    @Column
    @NotEmpty(groups = Gruop1.class)
    @Size(min = 1, max = 20, groups = Group2.class)
    private String title = null;

    @Column
    @NotEmpty(groups = Gruop1.class)
    @Size(min = 1, max = 1000, groups = Group2.class)
    private String body = null;

    private Date createdDate = null;
    private Date updatedDate = null;
    private boolean deleted = false;


//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }
}
