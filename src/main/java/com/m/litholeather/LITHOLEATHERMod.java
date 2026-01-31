package com.m.litholeather;

import com.m.litholeather.event.FishEventListen;
import net.fabricmc.api.ModInitializer;

import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LITHOLEATHERMod implements ModInitializer {
    public static final String LithoLeatherNameSpace = "litholeather";
    public static final Logger LOGGER = LogManager.getLogger(LithoLeatherNameSpace);

    @Override
    public void onInitialize() {

        LOGGER.info("Initializing Litho-Leather System...");

        ModResourceManager.addResourcePackDomain(LithoLeatherNameSpace);
        MITEEvents.MITE_EVENT_BUS.register(new FishEventListen());
        
        LOGGER.info("Litho-Leather System initialized successfully!");
    }
}
