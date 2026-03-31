
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.arprod.arproddelight.ArproddelightMod;

public class ArproddelightModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArproddelightMod.MODID);
	public static final RegistryObject<CreativeModeTab> ARPRODDELIGHT = REGISTRY.register("arproddelight",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.arproddelight.a_rprods_delight")).icon(() -> new ItemStack(ArproddelightModItems.CHEESE.get())).displayItems((parameters, tabData) -> {
				java.util.List.of(
						//blocks
				ArproddelightModItems.TONIR.get(),
				ArproddelightModItems.FRYING_BASKET.get(),
				ArproddelightModItems.GRATER.get(),
				ArproddelightModItems.MUSIC_DISC_HIGH.get(),
				ArproddelightModItems.BANANA_CRATE.get(),
				ArproddelightModItems.CHERRY_CRATE.get(),
				ArproddelightModItems.PEAR_CRATE.get(),
				ArproddelightModItems.COFFEE_BERRY_CRATE.get(),
				ArproddelightModItems.MINT_CRATE.get(),
				ArproddelightModItems.COTTON_CRATE.get(),
				ArproddelightModItems.COFFEE_BEAN_BAG.get(),

				ArproddelightModItems.CHEESE_BLOCK.get(),
				ArproddelightModItems.CANDY_CANE_BLOCK.get(),
				ArproddelightModItems.GELATIN_BLOCK.get(),
				ArproddelightModItems.MELTED_CHEESE_BUCKET.get(),
				ArproddelightModItems.SUNFLOWER_OIL_BUCKET.get(),
				ArproddelightModItems.SUNFLOWER_OIL_BOTTLE.get(),
				ArproddelightModItems.CUT_POTATOES.get(),
				ArproddelightModItems.FRIED_CUT_POTATOES.get(),
				ArproddelightModItems.BOILED_POTATO.get(),
				ArproddelightModItems.MASHED_POTATO.get(),
				ArproddelightModItems.BANANA_PEEL.get(),
				ArproddelightModItems.BANANAXE.get(),
				ArproddelightModItems.WILD_COFFEA.get(),
				ArproddelightModItems.WILD_MINT.get(),
				ArproddelightModItems.WILD_COTTON.get(),
				ArproddelightModItems.STRAWBERRY.get(),
				ArproddelightModItems.COFFEE_BERRY.get(),
				ArproddelightModItems.MINT.get(),
				ArproddelightModItems.COTTON.get(),
				ArproddelightModItems.COFFEE_BEAN.get(),
				ArproddelightModItems.BANANA.get(),
				ArproddelightModItems.CHERRY.get(),
				ArproddelightModItems.PEAR.get(),
				ArproddelightModItems.GOLDEN_PEAR.get(),
				ArproddelightModItems.MINT_SEEDS.get(),
				ArproddelightModItems.COTTON_SEEDS.get(),
				ArproddelightModItems.CHEESE.get(),
				ArproddelightModItems.GRATED_CHEESE.get(),
				ArproddelightModItems.MOLD.get(),
				ArproddelightModItems.MAYONNAISE_JAR.get(),
				ArproddelightModItems.GRILLED_CHEESE_SANDWICH.get(),
				ArproddelightModItems.CHEESEBURGER.get(),
				ArproddelightModItems.DOUBLE_HAMBURGER.get(),
				ArproddelightModItems.MAC_N_CHEESE.get(),
				ArproddelightModItems.UZBEK_RICE.get(),
				ArproddelightModItems.SALAMI.get(),
				ArproddelightModItems.MARGHERITA_PIZZA.get(),
				ArproddelightModItems.MARGHERITA_PIZZA_SLICE.get(),
				ArproddelightModItems.SALAMI_PIZZA.get(),
				ArproddelightModItems.SALAMI_PIZZA_SLICE.get(),
				ArproddelightModItems.BOSCAIOLA_PIZZA.get(),
				ArproddelightModItems.BOSCAIOLA_PIZZA_SLICE.get(),
				ArproddelightModItems.LAVASH.get(),
				ArproddelightModItems.RAW_BEEF_LAHMAJO.get(),
				ArproddelightModItems.BEEF_LAHMAJO.get(),
				ArproddelightModItems.CHEESE_AND_TOMATO_DURUM.get(),
				ArproddelightModItems.ICE_CREAM_CONE.get(),
				ArproddelightModItems.ICE_CREAM_CREAM.get(),
				ArproddelightModItems.ICE_CREAM_CHOCOLATE.get(),
				ArproddelightModItems.ICE_CREAM_HONEY.get(),


				ArproddelightModItems.RAW_CLAY_CUP.get(),
				ArproddelightModItems.CLAY_CUP.get(),
				ArproddelightModItems.COFFEE_CUP.get(),
				ArproddelightModItems.LATTE_CUP.get(),
				ArproddelightModItems.CANDY_CANE.get(),

				ArproddelightModItems.CANDY_SPEAR.get(),

				ArproddelightModItems.RED_BAUBLE.get(),
				ArproddelightModItems.SPRUCE_LEAVES_RED_BAUBLE.get(),
				ArproddelightModItems.BLUE_BAUBLE.get(),
				ArproddelightModItems.SPRUCE_LEAVES_BLUE_BAUBLE.get(),
				ArproddelightModItems.YELLOW_BAUBLE.get(),
				ArproddelightModItems.SPRUCE_LEAVES_YELLOW_BAUBLE.get(),
				ArproddelightModItems.KHINKALI.get(),
				ArproddelightModItems.CHEWING_GUM.get(),
				ArproddelightModItems.MARSHMALLOW.get(),
				ArproddelightModItems.SMORE.get(),
				ArproddelightModItems.MARSHMALLOW_ON_STICK.get(),
				ArproddelightModItems.COOKED_MARSHMALLOW_ON_STICK.get(),
				ArproddelightModItems.BURNT_MARSHMALLOW_ON_STICK.get(),
				ArproddelightModItems.CHEVON.get(),
				ArproddelightModItems.COOKED_CHEVON.get(),
				ArproddelightModItems.AXOLOTL_GILLS.get(),
				ArproddelightModItems.AXOLOTL_HAT_HELMET.get(),
				//ArproddelightModItems.FRIED_DRAGON_EGG.get(),
				ArproddelightModItems.GELATIN.get(),

				ArproddelightModItems.STRAWBERRY_JELLY.get(),
				ArproddelightModItems.STRAWBERRY_CHEESECAKE.get(),
				ArproddelightModItems.STRAWBERRY_CHEESECAKE_SLICE.get(),
				ArproddelightModItems.STRAWBERRY_JAM.get(),
				ArproddelightModItems.CINNAMON.get(),
				ArproddelightModItems.CINNAMON_POWDER.get(),
				ArproddelightModItems.BERRY_TEA.get(),
				ArproddelightModItems.CINNAMON_ROLL.get(),
				ArproddelightModItems.BOILED_EGG.get(),
				ArproddelightModItems.DEVILED_EGGS.get(),


				ArproddelightModItems.BATTERED_COD.get(),
				ArproddelightModItems.FRIED_CHICKEN.get())
				.forEach(tabData::accept);

			})

					.build());
}
