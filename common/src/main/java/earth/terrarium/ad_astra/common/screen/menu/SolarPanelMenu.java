package earth.terrarium.ad_astra.common.screen.menu;

import earth.terrarium.ad_astra.common.block.machine.entity.SolarPanelBlockEntity;
import earth.terrarium.ad_astra.common.networking.NetworkHandling;
import earth.terrarium.ad_astra.common.networking.packet.server.MachineInfoPacket;
import earth.terrarium.ad_astra.common.registry.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class SolarPanelMenu extends AbstractMachineMenu<SolarPanelBlockEntity> {

    public SolarPanelMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (SolarPanelBlockEntity) inventory.player.level.getBlockEntity(buf.readBlockPos()));
    }

    public SolarPanelMenu(int syncId, Inventory inventory, SolarPanelBlockEntity entity) {
        super(ModMenus.SOLAR_PANEL_SCREEN_HANDLER.get(), syncId, inventory, entity);
    }

    @Override
    public int getPlayerInventoryOffset() {
        return 62;
    }

    @Override
    public void syncClientScreen() {
        NetworkHandling.CHANNEL.sendToPlayer(new MachineInfoPacket(machine.getEnergyStorage().getStoredEnergy(), List.of()), this.player);
    }
}