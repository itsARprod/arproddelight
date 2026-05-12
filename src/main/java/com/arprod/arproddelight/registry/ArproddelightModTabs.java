
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.registry;

import com.arprod.arproddelight.ArproddelightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.arprod.arproddelight.registry.ArproddelightModItems.*;

@SuppressWarnings("unused")
public class ArproddelightModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArproddelightMod.MODID);
    public static final RegistryObject<CreativeModeTab> ARPRODDELIGHT = REGISTRY.register("arproddelight",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.arproddelight.a_rprods_delight")).icon(() -> new ItemStack(CHEESE.get())).displayItems((parameters, tabData) -> java.util.List.of(
                                    //blocks
                                    TONIR.get(),
                                    FRYING_BASKET.get(),
                                    GRATER.get(),
                                    MUSIC_DISC_HIGH.get(),
                                    //crates
                                    APPLE_CRATE.get(),
                                    BANANA_CRATE.get(),
                                    CHERRY_CRATE.get(),
                                    PEAR_CRATE.get(),
                                    COFFEE_BERRY_CRATE.get(),
                                    MINT_CRATE.get(),
                                    COTTON_CRATE.get(),
                                    COFFEE_BEAN_BAG.get(),

                                    CHEESE_BLOCK.get(),
                                    CANDY_CANE_BLOCK.get(),
                                    GELATIN_BLOCK.get(),
                                    CINNAMON_SAPLING.get(),
                                    CINNAMON_LOG.get(),
                                    CINNAMON_WOOD.get(),
                                    CINNAMON_LEAVES.get(),
                                    MELTED_CHEESE_BUCKET.get(),
                                    SUNFLOWER_OIL_BUCKET.get(),
                                    SUNFLOWER_OIL_BOTTLE.get(),
                                    WILD_COFFEA.get(),
                                    WILD_MINT.get(),
                                    WILD_COTTON.get(),
                                    BANANA_PEEL.get(),
                                    BANANAXE.get(),
                                    //fruits n veggies
                                    COFFEE_BERRY.get(),
                                    MINT.get(),
                                    COTTON.get(),
                                    BANANA.get(),
                                    CHERRY.get(),
                                    PEAR.get(),
                                    GOLDEN_PEAR.get(),
                                    //seeds
                                    MINT_SEEDS.get(),
                                    COTTON_SEEDS.get(),
                                    COFFEE_BEAN.get(),
                                    //ingredients
                                    CUT_POTATOES.get(),
                                    FRIED_CUT_POTATOES.get(),
                                    BOILED_POTATO.get(),
                                    MASHED_POTATO.get(),
                                    MOLD.get(),
                                    CHEESE.get(),
                                    GRATED_CHEESE.get(),
                                    MAYONNAISE_JAR.get(),
                                    GELATIN.get(),
                                    CINNAMON_BARK.get(),
                                    CINNAMON.get(),
                                    CINNAMON_POWDER.get(),
                                    BOILED_EGG.get(),
                                    CHEVON.get(),
                                    COOKED_CHEVON.get(),
                                    //simple meals
                                    BATTERED_COD.get(),
                                    FRIED_CHICKEN.get(),
                                    LAVASH.get(),
                                    RAW_BEEF_LAHMAJO.get(),
                                    BEEF_LAHMAJO.get(),
                                    GRILLED_CHEESE_SANDWICH.get(),
                                    CHEESEBURGER.get(),
                                    DOUBLE_HAMBURGER.get(),
                                    CHEESE_AND_TOMATO_DURUM.get(),
                                    KHINKALI.get(),
                                    POTATO_SALAD.get(),
                                    UZBEK_RICE.get(),
                                    DEVILED_EGGS.get(),
                                    MAC_N_CHEESE.get(),
                                    FISH_AND_CHIPS.get(),
                                    //somewhat complicated meals
                                    MARGHERITA_PIZZA.get(),
                                    MARGHERITA_PIZZA_SLICE.get(),
                                    SALAMI_PIZZA.get(),
                                    SALAMI_PIZZA_SLICE.get(),
                                    BOSCAIOLA_PIZZA.get(),
                                    BOSCAIOLA_PIZZA_SLICE.get(),
                                    //sweets
                                    ICE_CREAM_CONE.get(),
                                    ICE_CREAM_CREAM.get(),
                                    ICE_CREAM_CHOCOLATE.get(),
                                    ICE_CREAM_HONEY.get(),
                                    ICE_CREAM_CINNAMON.get(),
                                    CINNAMON_ROLL.get(),
                                    RAW_CLAY_CUP.get(),
                                    CLAY_CUP.get(),
                                    COFFEE_CUP.get(),
                                    LATTE_CUP.get(),
                                    CANDY_CANE.get(),
                                    CANDY_SPEAR.get(),
                                    CHEWING_GUM.get(),
                                    MARSHMALLOW.get(),
                                    SMORE.get(),
                                    MARSHMALLOW_ON_STICK.get(),
                                    COOKED_MARSHMALLOW_ON_STICK.get(),
                                    BURNT_MARSHMALLOW_ON_STICK.get(),
                                    BERRY_TEA.get())
                            .forEach(tabData::accept))
                    .build());
}
