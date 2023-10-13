package com.example.webprofile.model.entity;

import com.google.gson.Gson;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
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

@Entity(name = "groupEntity")
@Table(name = "group_tbl")
@Named
@Dependent
@NamedQueries({
        @NamedQuery(name = "Group.FindByParentId", query = "select oo from groupEntity oo where oo.parent.id=:parentId"),
        @NamedQuery(name = "Group.FindParents", query = "select oo from groupEntity oo where oo.parent.id is null")
})
public class Group extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[A-Za-z0-9]{3,30}$", message = "Invalid group title")
    @Column(name = "g_title", length = 30)
    private String title;

    @ManyToOne
    @JoinColumn(name = "g_parent_id")
    private Group parent;

    @Override
    public String toString() {

        return new Gson().toJson(this);
    }
}
