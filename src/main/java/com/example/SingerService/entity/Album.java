package com.example.SingerService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(generator = "album_generator")
    @SequenceGenerator(
            name = "album_generator",
            sequenceName = "album_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date releasedate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "singer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Singer singer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
