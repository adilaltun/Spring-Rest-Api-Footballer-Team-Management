package com.works.entities;

import com.works.util.TEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer tid;

    @Column(unique = true)
    private Integer fid;

    private TEnum teamName;

}
