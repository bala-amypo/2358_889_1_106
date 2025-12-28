package com.example.demo.entity;

public class Location {
    private Long id;
    private String locationName;
    private String region;
    
    public Location() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
    
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}

// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "locations")
// public class Location {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(unique = true, nullable = false)
//     private String locationName;
    
//     @Column(nullable = false)
//     private String region;

//     public Location() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public String getLocationName() { return locationName; }
//     public void setLocationName(String locationName) { this.locationName = locationName; }
    
//     public String getRegion() { return region; }
//     public void setRegion(String region) { this.region = region; }
// }