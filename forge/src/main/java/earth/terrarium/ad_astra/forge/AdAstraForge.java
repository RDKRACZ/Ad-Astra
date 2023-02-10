package earth.terrarium.ad_astra.forge;

import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.client.AdAstraClient;
import earth.terrarium.ad_astra.client.forge.AdAstraClientForge;
import earth.terrarium.ad_astra.common.item.AstroduxItem;
import earth.terrarium.ad_astra.common.registry.ModCommands;
import earth.terrarium.ad_astra.common.registry.ModEntityTypes;
import earth.terrarium.ad_astra.common.util.ModKeyBindings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AdAstra.MOD_ID)
public class AdAstraForge {
    public AdAstraForge() {
        AdAstra.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(AdAstraForge::onClientSetup);
        bus.addListener(AdAstraForge::commonSetup);
        bus.addListener(AdAstraForge::onAttributes);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> AdAstraClientForge::init);
        MinecraftForge.EVENT_BUS.addListener(AdAstraForge::onServerReloadListeners);
        MinecraftForge.EVENT_BUS.addListener(AdAstraForge::onRegisterCommands);
        MinecraftForge.EVENT_BUS.addListener(AdAstraForge::onPlayerLogIn);
        MinecraftForge.EVENT_BUS.addListener(AdAstraForge::onPlayerLogOut);
    }

    public static void onServerReloadListeners(AddReloadListenerEvent event) {
        AdAstra.onRegisterReloadListeners((id, listener) -> event.addListener(listener));
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        AdAstra.postInit();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        AdAstraClient.init();
        AdAstraClientForge.postInit();
    }

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        ModCommands.registerCommands(command -> command.accept(event.getDispatcher()));
    }

    public static void onAttributes(EntityAttributeCreationEvent event) {
        ModEntityTypes.registerAttributes((entityType, attribute) -> event.put(entityType.get(), attribute.get().build()));
    }

    public static void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        AstroduxItem.onPlayerJoin(event.getEntity());
    }

    public static void onPlayerLogOut(PlayerEvent.PlayerLoggedOutEvent event) {
        ModKeyBindings.onPlayerQuit(event.getEntity());
    }
}
