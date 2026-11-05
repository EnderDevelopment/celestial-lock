package com.enderdevelopment.endersky;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderSky implements ModInitializer {
    public static final String MOD_ID = "endersky";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Ender Sky loaded: the sun and moon are locked to their vanilla movement.");
    }
}
