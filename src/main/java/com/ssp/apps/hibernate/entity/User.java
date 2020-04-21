package com.ssp.apps.hibernate.entity;

import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_dtl")
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = {"socialProfiles"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_SEQ")
    private Integer id;

    private String name;

    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "office_landline")),
            @AttributeOverride(name = "mail", column = @Column(name = "office_email"))})
    @Embedded
    private Contact officeContact;

    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "mobile_number")),
            @AttributeOverride(name = "mail", column = @Column(name = "email"))})
    @Embedded
    private Contact personalContact;

    @ElementCollection
    @CollectionTable(name = "social_profiles", joinColumns = @JoinColumn(name = "social_id"))
    private List<String> socialProfiles;


}
