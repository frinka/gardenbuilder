package com.ageofsailgames.gardenbuilder;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gardenbuilder")
public class GardenBuilderMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    private static final DeferredRegister ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "gardenbuilder");
    private static final DeferredRegister  BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "gardenbuilder");

    public static final RegistryObject<Block> OAK_MULCH = BLOCKS.register("oak_mulch", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.GROUND).hardnessAndResistance(0.4F)));
    public static final RegistryObject  OAK_MULCH_ITEM = ITEMS.register("oak_mulch", () -> new BlockItem(OAK_MULCH.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public GardenBuilderMod() {
        MinecraftForge.EVENT_BUS.register(this);

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


}
