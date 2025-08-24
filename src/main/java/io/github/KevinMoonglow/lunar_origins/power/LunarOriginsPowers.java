package io.github.KevinMoonglow.lunar_origins.power;

import io.github.KevinMoonglow.lunar_origins.Lunar_origins;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.eggohito.eggolib.Eggolib;
import io.github.eggohito.eggolib.power.ModifyBreathingPower;
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

        PowerFactory<?> modifyBreathing = ApoliRegistries.POWER_FACTORY.get(Eggolib.identifier("modify_breathing"));
        if(modifyBreathing != null) {
            SerializableData serializableData = modifyBreathing.getSerializableData().copy();

            modifyBreathingAlias = new PowerFactory<ModifyBreathingPower>(
                    new Identifier(Lunar_origins.MOD_ID, "modify_breathing"),
                    serializableData,
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
        else {
            Lunar_origins.LOGGER.warn("Couldn't register alias lunar_origins:modify_breathing. Is Eggolib working?");
        }
    }
}
