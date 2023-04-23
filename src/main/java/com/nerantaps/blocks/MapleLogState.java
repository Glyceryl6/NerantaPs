package com.nerantaps.blocks;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

public enum MapleLogState implements StringRepresentable {

    PLAIN(null, false),
    DRY_NORTH(Direction.NORTH, false),
    DRY_SOUTH(Direction.SOUTH, false),
    DRY_WEST(Direction.WEST, false),
    DRY_EAST(Direction.EAST, false),
    WET_NORTH(Direction.NORTH, true),
    WET_SOUTH(Direction.SOUTH, true),
    WET_WEST(Direction.WEST, true),
    WET_EAST(Direction.EAST, true);

    public final Direction facing;
    public final boolean wet;
    private static final MapleLogState[] VALUES;

    MapleLogState(Direction direction, boolean bl) {
        this.facing = direction;
        this.wet = bl;
    }

    @Override
    public String getSerializedName() {
        return this.name();
    }

    public boolean isPlain() {
        return false;
    }

    public boolean canRegenerate() {
        return !this.isPlain() && !this.wet;
    }

    public MapleLogState getWet() {
        if (this.isPlain()) {
            return null;
        }
        if (this.wet) {
            return this;
        }
        return VALUES[this.ordinal() + 4];
    }

    public MapleLogState getDry() {
        if (this.isPlain() || !this.wet) {
            return this;
        }
        return VALUES[this.ordinal() - 4];
    }

    public static MapleLogState getWet(Direction direction) {
        switch (direction) {
            case NORTH -> {
                return WET_NORTH;
            }
            case SOUTH -> {
                return WET_SOUTH;
            }
            case WEST -> {
                return WET_WEST;
            }
            case EAST -> {
                return WET_EAST;
            }
        }
        throw new IllegalArgumentException("incompatible facing: " + direction);
    }

    static {
        VALUES = MapleLogState.values();
    }

}