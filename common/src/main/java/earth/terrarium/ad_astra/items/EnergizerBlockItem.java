package earth.terrarium.ad_astra.items;

import earth.terrarium.ad_astra.AdAstra;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class EnergizerBlockItem extends MachineBlockItem {
    public EnergizerBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag context) {
        long energy = 0;
        if (stack.hasTag() && stack.getTag().contains("energy")) {
            energy = stack.getTag().getLong("energy");
        }
        tooltip.add(Component.translatable("gauge_text.ad_astra.storage", energy, AdAstra.CONFIG.energizer.maxEnergy).setStyle(Style.EMPTY.withColor(energy > 0 ? ChatFormatting.GREEN : ChatFormatting.RED)));
        super.appendHoverText(stack, level, tooltip, context);
    }
}
