package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.entity.ai.sensing.ArthropodSpecificSensor;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NPSensors {

    public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, NerantaPs.MOD_ID);
    public static final RegistryObject<SensorType<ArthropodSpecificSensor>> ARTHROPOD_REPELLENT = register("arthropod_repellent", ArthropodSpecificSensor::new);

    private static <U extends Sensor<?>> RegistryObject<SensorType<U>> register(String name, Supplier<U> factory) {
        return SENSOR_TYPES.register(name, () -> new SensorType<>(factory));
    }

}
