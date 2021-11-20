package com.learning.spring.learningspring.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name Should Have at least 2 characters")
    private String name;

    @Past
    private Date birthdate;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Post> posts;


}
