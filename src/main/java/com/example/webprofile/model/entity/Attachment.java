package com.example.webprofile.model.entity;


import com.example.webprofile.model.entity.enums.FileType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name="attachmentEntity")
@Table(name="attachment_tbl")

public class Attachment extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="a_title",length = 30, unique = true)
    @Pattern(regexp = "^[A-Za-z\\s]{2,30}$", message = "Invalid Role")
    private String title;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="a_file_type",length = 30, unique = true)
    @Pattern(regexp = "^[A-Za-z\\s]{2,30}$", message = "Invalid Role")
    private FileType fileType;
}