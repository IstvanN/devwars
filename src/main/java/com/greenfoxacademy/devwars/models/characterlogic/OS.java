package com.greenfoxacademy.devwars.models.characterlogic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int IQmodifier;

    public OS(String name) {
        this.name = name;
        switch (name) {
            case "Linux": IQmodifier = 5;
            case "Mac": IQmodifier = -5;
        }
    }

    @Override
    public String toString() {
        return "OS " +
                "name=" + name + " ";
    }
}
