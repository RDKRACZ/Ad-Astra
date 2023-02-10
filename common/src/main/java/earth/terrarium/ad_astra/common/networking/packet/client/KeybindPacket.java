package earth.terrarium.ad_astra.common.networking.packet.client;

import com.teamresourceful.resourcefullib.common.networking.base.Packet;
import com.teamresourceful.resourcefullib.common.networking.base.PacketContext;
import com.teamresourceful.resourcefullib.common.networking.base.PacketHandler;
import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.util.ModKeyBindings;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record KeybindPacket(Keybind keybind, boolean pressed) implements Packet<KeybindPacket> {

    public static final ResourceLocation ID = new ResourceLocation(AdAstra.MOD_ID, "keybind_packet");
    public static final Handler HANDLER = new Handler();

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public PacketHandler<KeybindPacket> getHandler() {
        return HANDLER;
    }

    public enum Keybind {
        JUMP, SPRINT, FORWARD, BACK, LEFT, RIGHT
    }

    private static class Handler implements PacketHandler<KeybindPacket> {
        @Override
        public void encode(KeybindPacket packet, FriendlyByteBuf buf) {
            buf.writeEnum(packet.keybind);
            buf.writeBoolean(packet.pressed);
        }

        @Override
        public KeybindPacket decode(FriendlyByteBuf buf) {
            return new KeybindPacket(buf.readEnum(Keybind.class), buf.readBoolean());
        }

        @Override
        public PacketContext handle(KeybindPacket packet) {
            return (player, level) -> ModKeyBindings.pressedKeyOnServer(player.getUUID(), packet.keybind, packet.pressed());
        }
    }
}
