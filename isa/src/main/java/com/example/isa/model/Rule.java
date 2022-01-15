package com.example.isa.model;

import com.example.isa.repository.RuleRepository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleId;
    private String rule;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "boat_id", referencedColumnName = "id", nullable = true)
    private Set<Boat> boat = new HashSet<Boat>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "mansion_id", referencedColumnName = "id", nullable = true)
    private Set<Mansion> mansions = new HashSet<Mansion>();

    public Rule(){}
    public Rule(String rule){
        this.rule = rule;
    }


    public void addMansion(Mansion newMansion) {mansions.add(newMansion);}
    public void addBoat(Boat newBoat){
        boat.add(newBoat);
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
