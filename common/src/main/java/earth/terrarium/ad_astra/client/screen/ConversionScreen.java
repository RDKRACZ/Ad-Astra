package earth.terrarium.ad_astra.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.block.machine.entity.FluidMachineBlockEntity;
import earth.terrarium.ad_astra.common.screen.menu.ConversionMenu;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class ConversionScreen extends AbstractMachineScreen<FluidMachineBlockEntity, ConversionMenu> {

    public static final int INPUT_TANK_LEFT = 42;
    public static final int INPUT_TANK_TOP = 21;
    public static final int OUTPUT_TANK_LEFT = 99;
    public static final int OUTPUT_TANK_TOP = 21;
    public static final int ENERGY_LEFT = 150;
    public static final int ENERGY_TOP = 22;
    private static final ResourceLocation TEXTURE = new ResourceLocation(AdAstra.MOD_ID, "textures/gui/screens/conversion.png");

    public ConversionScreen(ConversionMenu handler, Inventory inventory, Component title) {
        super(handler, inventory, title, TEXTURE);
        this.imageWidth = 177;
        this.imageHeight = 184;
        this.inventoryLabelY = this.imageHeight - 92;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float delta, int mouseX, int mouseY) {

        super.renderBg(poseStack, delta, mouseX, mouseY);

        GuiUtil.drawEnergy(poseStack, this.leftPos + ENERGY_LEFT, this.topPos + ENERGY_TOP, this.menu.getEnergyAmount(), this.machine.getMaxCapacity());
        GuiUtil.drawFluidTank(poseStack, this.leftPos + INPUT_TANK_LEFT, this.topPos + INPUT_TANK_TOP, this.machine.getInputTankCapacity(), this.menu.getFluids().get(0));
        GuiUtil.drawFluidTank(poseStack, this.leftPos + OUTPUT_TANK_LEFT, this.topPos + OUTPUT_TANK_TOP, this.machine.getOutputTankCapacity(), this.menu.getFluids().get(1));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        super.render(poseStack, mouseX, mouseY, delta);

        if (GuiUtil.isHovering(this.getEnergyBounds(), mouseX, mouseY)) {
            GuiUtil.drawEnergyTooltip(this, poseStack, this.menu.getEnergyAmount(), this.machine.getMaxCapacity(), mouseX, mouseY);
        }

        if (GuiUtil.isHovering(this.getInputTankBounds(), mouseX, mouseY)) {
            GuiUtil.drawTankTooltip(this, poseStack, this.menu.getFluids().get(0), this.machine.getInputTankCapacity(), mouseX, mouseY);
        }

        if (GuiUtil.isHovering(this.getOutputTankBounds(), mouseX, mouseY)) {
            GuiUtil.drawTankTooltip(this, poseStack, this.menu.getFluids().get(1), this.machine.getOutputTankCapacity(), mouseX, mouseY);
        }
    }

    public Rectangle getRecipeBounds() {
        return new Rectangle(this.leftPos + 64, this.topPos + 35, 26, 21);
    }

    public Rectangle getInputTankBounds() {
        return GuiUtil.getFluidTankBounds(this.leftPos + INPUT_TANK_LEFT, this.topPos + INPUT_TANK_TOP);
    }

    public Rectangle getOutputTankBounds() {
        return GuiUtil.getFluidTankBounds(this.leftPos + OUTPUT_TANK_LEFT, this.topPos + OUTPUT_TANK_TOP);
    }

    public Rectangle getEnergyBounds() {
        return GuiUtil.getEnergyBounds(this.leftPos + ENERGY_LEFT, this.topPos + ENERGY_TOP);
    }

    @Override
    public int getTextColour() {
        return 0x2C282E;
    }
}