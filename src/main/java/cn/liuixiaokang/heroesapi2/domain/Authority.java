package cn.liuixiaokang.heroesapi2.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "AUTHORITY")
public class Authority implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true, length = 50)
    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    private List<User> users;
}
