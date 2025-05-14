package net.reconhalcyon.hawaiinei.item.custom;

import net.minecraft.world.item.Item;

public class BaseFishItem extends Item {
    protected String fishBiome = "generic";
    protected String fishRarity = "common";
    protected boolean spearCatchable = true;

    public BaseFishItem(Item.Properties properties) {
        super(properties);
    }

    public BaseFishItem fishBiome(String biome) {
        this.fishBiome = biome;
        return this;
    }

    public BaseFishItem fishRarity(String rarity) {
        this.fishRarity = rarity;
        return this;
    }

    public BaseFishItem spearCatchable(boolean value) {
        this.spearCatchable = value;
        return this;
    }

    public String getFishBiome() {
        return fishBiome;
    }

    public String getFishRarity() {
        return fishRarity;
    }

    public boolean isSpearCatchable() {
        return spearCatchable;
    }
}