package com.Silver2040.OtherUtilities;

import com.Silver2040.OtherUtilities.init.ItemInit;
import com.Silver2040.OtherUtilities.items.BaseBow;
import com.Silver2040.OtherUtilities.items.DiamondBow;
import com.Silver2040.OtherUtilities.util.RegistryHandler;
import com.Silver2040.OtherUtilities.world.gen.OreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(OreGen::generateOre);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemModelsProperties.func_239418_a_(RegistryHandler.Diamond_Bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(RegistryHandler.Diamond_Bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(RegistryHandler.Iron_Bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(RegistryHandler.Iron_Bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(RegistryHandler.Gold_Bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(RegistryHandler.Gold_Bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(RegistryHandler.Netherite_Bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(RegistryHandler.Netherite_Bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

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
            return new ItemStack(RegistryHandler.Caliber_Block.get());
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
