package melonslise.lambda.common.creativetab;

import melonslise.lambda.LambdaCore;
import melonslise.lambda.common.entity.LambdaEntities;
import melonslise.lambda.common.item.LambdaItems;
import melonslise.lambda.utility.LambdaUtilities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class CreativeTabLambda extends CreativeTabs
{
	public CreativeTabLambda()
	{
		super(LambdaCore.ID);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(LambdaItems.weapon_crowbar);
	}

	@OnlyIn(Dist.CLIENT)
	public void displayAllRelevantItems(NonNullList<ItemStack> stacks)
	{
		super.displayAllRelevantItems(stacks);
		stacks.add(LambdaUtilities.createEgg(LambdaEntities.headcrab.getRegistryName()));
		stacks.add(LambdaUtilities.createEgg(LambdaEntities.zombie.getRegistryName()));
		stacks.add(LambdaUtilities.createEgg(LambdaEntities.vortigaunt.getRegistryName()));
		stacks.add(LambdaUtilities.createEgg(LambdaEntities.houndeye.getRegistryName()));
		stacks.add(LambdaUtilities.createEgg(LambdaEntities.barnacle.getRegistryName()));
	}
}