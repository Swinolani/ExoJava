package com.swino.salut.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    private String title;
    private String description;
    private boolean completed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
