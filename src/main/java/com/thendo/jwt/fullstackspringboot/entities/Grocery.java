package com.thendo.jwt.fullstackspringboot.entities;

import com.thendo.jwt.fullstackspringboot.models.dto.GroceryList;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Builder
@Table(name = "grocery")
public class Grocery {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @Column(name = "numOfItems")
    private int numItems;

    @Column(name = "category")
    private GroceryList category;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @CreationTimestamp
    @Column(name = "createDate")
    private LocalDateTime creationTimeStamp;

//    @Column(name = "total")
//    private int total;

//    public Integer setItemTotal() {
//        this.total = this.numItems * this.amount;
//        return this.total;
//    }

}
