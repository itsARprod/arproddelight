
package com.arprod.arproddelight.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import com.arprod.arproddelight.init.ArproddelightModBlocks;

public class BananaxeItem extends PickaxeItem {
	public BananaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 16;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ArproddelightModBlocks.BANANA_PEEL.get()));
			}
		}, 1, -3f, new Item.Properties());
	}
}
