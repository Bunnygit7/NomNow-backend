package com.amvb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant_menus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantMenuEntity {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantMenuId;
    @Column(name = "item_name")
    private String menuItem;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "item_img_url")
    private String menuItemImgUrl;
    @Column(name = "menu_type")
    private String menuType;
    @Column(name = "price")
    private Double price;
}
