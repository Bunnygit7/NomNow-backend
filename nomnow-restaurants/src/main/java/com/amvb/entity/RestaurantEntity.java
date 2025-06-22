package com.amvb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurants")
@Builder
public class RestaurantEntity {


    @Id
    @Column(name = "restaurant_id")
    @SequenceGenerator(initialValue = 20101,allocationSize = 1,sequenceName = "restaurantSeq",name = "seq1")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
    private Integer restaurantId;
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Column(name = "rating")
    private String rating;
    @Column(name = "restaurant_image_url")
    private String imgUrl;
    @Column(name = "location")
    private String location;
    @ElementCollection
    @CollectionTable(name = "restaurant_entity_menu_types", joinColumns = @JoinColumn(name="restaurant_id"))
    @Column(name = "menu_type")
    private List<String> menuTypes;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private List<RestaurantMenuEntity> menus;
}
