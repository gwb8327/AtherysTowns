package com.atherys.towns.persistence;

import com.atherys.core.database.mongo.MorphiaDatabaseManager;
import com.atherys.towns.AtherysTowns;
import com.atherys.towns.model.Resident;

import java.util.Optional;
import java.util.UUID;

public class ResidentManager extends MorphiaDatabaseManager<Resident> {

    public ResidentManager() {
        super(AtherysTowns.getDatabase(), AtherysTowns.getLogger(), Resident.class);
    }

    public Resident getOrCreate(UUID player) {
        return get(player).orElseGet(() -> {
            Resident resident = new Resident(player);
            save(resident);
            return resident;
        });
    }
}