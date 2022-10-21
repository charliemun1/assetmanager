package com.charliemun.assetmanager.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "honeySequence")
    @Column(name = "id")
    protected Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number")
    private String number;

    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description",columnDefinition="TEXT")
    private String description;

    private BigDecimal currentValuation;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
