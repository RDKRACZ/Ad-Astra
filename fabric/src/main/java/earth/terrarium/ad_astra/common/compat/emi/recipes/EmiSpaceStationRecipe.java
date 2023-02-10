package earth.terrarium.ad_astra.common.compat.emi.recipes;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import earth.terrarium.ad_astra.common.compat.emi.EmiCategories;
import earth.terrarium.ad_astra.common.recipe.IngredientHolder;
import earth.terrarium.ad_astra.common.recipe.SpaceStationRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EmiSpaceStationRecipe implements EmiRecipe {
	private final ResourceLocation id;
	SpaceStationRecipe recipe;
	private final List<EmiIngredient> input = new ArrayList<>();

	public EmiSpaceStationRecipe(SpaceStationRecipe recipe) {
		this.id = recipe.getId();
		this.recipe = recipe;

		for (IngredientHolder holder : recipe.getHolders()) {
			this.input.add(EmiIngredient.of(holder.ingredient(), holder.count()));
		}
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return EmiCategories.SPACE_STATION_CATEGORY;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public List<EmiIngredient> getInputs() {
		return this.input;
	}

	@Override
	public List<EmiStack> getOutputs() {
		return List.of();
	}

	@Override
	public int getDisplayWidth() {
		return 150;
	}

	@Override
	public int getDisplayHeight() {
		return 51;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		int xOffset = 3;
		int yOffset = 0;

		for (int i = 0; i < 8; i++) {
			if (i < this.input.size()) {
				widgets.addSlot(this.input.get(i), 18 * i + xOffset, 0);
			} else {
				widgets.addSlot(EmiStack.of(ItemStack.EMPTY), 18 * i + xOffset, 0);
			}
		}
	}
}
