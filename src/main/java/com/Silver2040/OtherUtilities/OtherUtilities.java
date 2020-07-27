package com.Silver2040.OtherUtilities;

import com.Silver2040.OtherUtilities.init.ItemInit;
import com.Silver2040.OtherUtilities.init.ItemPropertyOverrides;
import com.Silver2040.OtherUtilities.init.BlockInit;
import com.Silver2040.OtherUtilities.world.gen.OreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("otherutilities")
public class OtherUtilities {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "otherutilities";
    public static OtherUtilities instance;
    public OtherUtilities() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.init(modEventBus);
        BlockInit.init(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;


        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(OreGen::generateOre);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemPropertyOverrides.doStuff();

    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event){

    }
   @SubscribeEvent
    public void loadCompleteEvent(FMLLoadCompleteEvent event){
       // OreGen.generateOre();
    }



    public static final ItemGroup TAB = new ItemGroup("OtherUtilitiesTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.caliber.get());
        }
    };

    /*
    public static class OtherUtilitiesItemGroup extends ItemGroup{
       // public static final OtherUtilitiesItemGroup instance = new OtherUtilitiesItemGroup(ItemGroup.GROUPS.length, "otherutilitiestab")
        private OtherUtilitiesItemGroup(int index, String label){
            super(index, label);

        }
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.caliber);
        }
    } */
}
