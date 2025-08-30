package io.github.KevinMoonglow.lunar_origins.power;

import io.github.KevinMoonglow.lunar_origins.Lunar_origins;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.util.modifier.Modifier;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import io.github.eggohito.eggolib.data.EggolibDataTypes;
import io.github.eggohito.eggolib.power.ModifyBreathingPower;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class LunarOriginsPowers {
    public static final PowerFactory<?> CRAWLING = new PowerFactory<>(
            new Identifier(Lunar_origins.MOD_ID, "crawling"),
            new SerializableData(),
            data -> ((powerPowerType, livingEntity) -> new CrawlingPower(powerPowerType, livingEntity))
        ).allowCondition();
    public static PowerFactory<?> modifyBreathingAlias;

    public static void register() {
        Registry.register(ApoliRegistries.POWER_FACTORY, CRAWLING.getSerializerId(), CRAWLING);

        modifyBreathingAlias = new PowerFactory<ModifyBreathingPower>(
                new Identifier(Lunar_origins.MOD_ID, "modify_breathing"),
                new SerializableData()
                        .add("breathable_block_condition", ApoliDataTypes.BLOCK_CONDITION)
                        .add("breathing_status_effect", SerializableDataTypes.STATUS_EFFECT, null)
                        .add("breathing_status_effects", SerializableDataTypes.STATUS_EFFECTS, null)
                        .add("gain_air_modifier", Modifier.DATA_TYPE, null)
                        .add("gain_air_modifiers", Modifier.LIST_TYPE, null)
                        .add("gain_air_interval", EggolibDataTypes.POSITIVE_INT, null)
                        .add("lose_air_modifier", Modifier.DATA_TYPE, null)
                        .add("lose_air_modifiers", Modifier.LIST_TYPE, null)
                        .add("lose_air_interval", EggolibDataTypes.POSITIVE_INT, null)
                        .add("damage_source", ApoliDataTypes.DAMAGE_SOURCE_DESCRIPTION, null)
                        .add("damage_type", SerializableDataTypes.DAMAGE_TYPE, DamageTypes.DROWN)
                        .add("damage_modifier", Modifier.DATA_TYPE, null)
                        .add("damage_modifiers", Modifier.LIST_TYPE, null)
                        .add("damage_interval", EggolibDataTypes.POSITIVE_INT, null)
                        .add("particle", SerializableDataTypes.PARTICLE_EFFECT_OR_TYPE, null)
                        .add("ignore_respiration", SerializableDataTypes.BOOLEAN, false)
                        .add("priority", SerializableDataTypes.INT, 0),
                data -> ((p, e) ->
                        new ModifyBreathingPower(p, e,
                                data.get("breathable_block_condition"),
                                data.get("breathing_status_effect"),
                                data.get("breathing_status_effects"),
                                data.get("gain_air_modifier"),
                                data.get("gain_air_modifiers"),
                                data.get("gain_air_interval"),
                                data.get("lose_air_modifier"),
                                data.get("lose_air_modifiers"),
                                data.get("lose_air_interval"),
                                data.get("damage_source_description"),
                                data.get("damage_type"),
                                data.get("damage_modifier"),
                                data.get("damage_modifiers"),
                                data.get("damage_interval"),
                                data.get("particle"),
                                data.get("ignore_respiration"),
                                data.get("priority")
                        ))
        ).allowCondition();

        Registry.register(ApoliRegistries.POWER_FACTORY, new Identifier(Lunar_origins.MOD_ID, "modify_breathing"),
                ModifyBreathingPower.getFactory());

    }
}
