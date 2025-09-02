package io.github.KevinMoonglow.lunar_origins.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LunarOriginsCreativeTabs {
    public static final ItemGroup LUNAR_ORIGINS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LunarOriginsItems.LUNAR_BOOK))
            .displayName(Text.translatable("itemGroup.lunar_origins.lunar_origins"))
            .entries((context, entries) -> {
                entries.add(LunarOriginsItems.BOWL_SEALANT);
                entries.add(LunarOriginsItems.BOWL_SUPER_SEALANT);
                entries.add(LunarOriginsItems.KELP_CARROT);
                entries.add(LunarOriginsItems.GNAP_GLASSES);
                entries.add(LunarOriginsItems.GLASS_BOWL);
                entries.add(LunarOriginsItems.AMETHYST_BOWL);
                entries.add(LunarOriginsItems.DIVING_HELMET);
                entries.add(LunarOriginsItems.FISH_BOWL);
                entries.add(LunarOriginsItems.GOGGLES);
                entries.add(LunarOriginsItems.AQUA_GUMMY);
                entries.add(LunarOriginsItems.GLIMMERING_AQUA_GUMMY);
                entries.add(LunarOriginsItems.LUNA_GLASSES);
            })
            .build();
    public static final ItemGroup LUNAR_ORIGINS_INGREDIENT_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LunarOriginsItems.GLASSES_LENS))
            .displayName(Text.translatable("itemGroup.lunar_origins.lunar_origins_ingredients"))
            .entries((context, entries) -> {
                entries.add(LunarOriginsItems.GLASSES_ARM);
                entries.add(LunarOriginsItems.GLASSES_ARM_RED);
                entries.add(LunarOriginsItems.GLASSES_FRAME);
                entries.add(LunarOriginsItems.GLASSES_FRAME_RED);
                entries.add(LunarOriginsItems.GLASSES_HINGE);
                entries.add(LunarOriginsItems.HINGE_PART);
                entries.add(LunarOriginsItems.HINGE_PIN);
                entries.add(LunarOriginsItems.HINGE_SPRING);
                entries.add(LunarOriginsItems.GLASSES_LENS);
                entries.add(LunarOriginsItems.WIRE_COIL);
                entries.add(LunarOriginsItems.CRUDE_LENS);
                entries.add(LunarOriginsItems.LENS_CAST);
                entries.add(LunarOriginsItems.UNFOCUSED_LENS);
                entries.add(LunarOriginsItems.INCOMPLETE_CAST);
                entries.add(LunarOriginsItems.INCOMPLETE_LENS);
                entries.add(LunarOriginsItems.INCOMPLETE_FRAME);
                entries.add(LunarOriginsItems.INCOMPLETE_HINGE);
            })
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("lunar_origins", "lunar_origins"), LunarOriginsCreativeTabs.LUNAR_ORIGINS_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier("lunar_origins", "lunar_origins_ingredients"), LunarOriginsCreativeTabs.LUNAR_ORIGINS_INGREDIENT_GROUP);
    }

}
