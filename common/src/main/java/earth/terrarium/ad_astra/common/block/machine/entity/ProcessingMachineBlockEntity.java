package earth.terrarium.ad_astra.common.block.machine.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ProcessingMachineBlockEntity extends AbstractMachineBlockEntity {

    protected int cookTime;
    protected int cookTimeTotal;

    protected ItemStack inputStack = ItemStack.EMPTY;
    protected ItemStack outputStack = ItemStack.EMPTY;

    public ProcessingMachineBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeTotal = nbt.getInt("CookTimeTotal");
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putInt("CookTime", this.cookTime);
        nbt.putInt("CookTimeTotal", this.cookTimeTotal);
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getCookTimeTotal() {
        return this.cookTimeTotal;
    }

    public void finishCooking() {
        if (!this.outputStack.isEmpty()) {
            int size = this.outputStack.getCount() + this.getItem(1).getCount();
            this.setItem(1, new ItemStack(this.outputStack.getItem(), size));
        }
        this.stopCooking();
    }

    public void stopCooking() {
        this.cookTime = 0;
        this.cookTimeTotal = 0;
        this.outputStack = ItemStack.EMPTY;
        this.inputStack = ItemStack.EMPTY;
        this.setChanged();
    }
}