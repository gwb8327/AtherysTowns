package com.atherys.towns.model;

import com.atherys.core.db.SpongeIdentifiable;
import com.atherys.towns.api.Actor;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Nonnull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Resident implements SpongeIdentifiable, Actor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "town_id")
    private Town town;

    @Nonnull
    @Override
    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
