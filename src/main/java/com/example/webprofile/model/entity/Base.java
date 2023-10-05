package com.example.webprofile.model.entity;

import com.google.gson.Gson;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@MappedSuperclass
public class Base implements Serializable {
//    @OneToMany
//    @JsonbTransient
//    private List<Attachment> attachmentList;

    @Column(length = 1)
    @JsonbTransient
    private boolean deleted;

//    @Version
//    @Column(name = "b_version_id", length = 1)
//    @JsonbTransient
//    private long versionId;


//    public List<Attachment> addAttachment(Attachment attachment) {
//        attachmentList.add(attachment);
//        return attachmentList;
//    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
