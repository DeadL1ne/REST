package com.example.SingerService.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "singer")
public class Singer {

    @Id
    @GeneratedValue(generator = "singer_generator")
    @SequenceGenerator(
            name = "singer_generator",
            sequenceName = "singer_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    private String groupname;

    private String country;

    @Temporal(TemporalType.DATE)
    private Date startdate;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Album> albums = new HashSet<Album>();


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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
