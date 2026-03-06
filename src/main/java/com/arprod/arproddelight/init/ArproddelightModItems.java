/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import com.arprod.arproddelight.item.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.arprod.arproddelight.ArproddelightMod;

public class ArproddelightModItems {
    public static final DeferredRegister<Item> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArproddelightMod.MODID);

    public static final RegistryObject<Item> CUT_POTATOES = REGISTRY.register("cut_potatoes", BasicItem::new);
    public static final RegistryObject<Item> FRIED_CUT_POTATOES = REGISTRY.register("fried_cut_potatoes", FriedCutPotatoesItem::new);
    public static final RegistryObject<Item> MELTED_CHEESE_BUCKET = REGISTRY.register("melted_cheese_bucket", MeltedCheeseItem::new);
    public static final RegistryObject<Item> CHEESE = REGISTRY.register("cheese", CheeseItem::new);
    public static final RegistryObject<Item> CHEESE_BLOCK = block(ArproddelightModBlocks.CHEESE_BLOCK);
    public static final RegistryObject<Item> GRILLED_CHEESE_SANDWICH = REGISTRY.register("grilled_cheese_sandwich", GrilledCheeseSandwichItem::new);
    public static final RegistryObject<Item> CHEESEBURGER = REGISTRY.register("cheeseburger", CheeseburgerItem::new);
    public static final RegistryObject<Item> MARGHERITA_PIZZA = block(ArproddelightModBlocks.MARGHERITA_PIZZA);
    public static final RegistryObject<Item> UNFINISHED_PIZZA = REGISTRY.register("unfinished_pizza", UnfinishedPizzaItem::new);
    public static final RegistryObject<Item> SALAMI = REGISTRY.register("salami", SalamiItem::new);
    public static final RegistryObject<Item> SALAMI_PIZZA = block(ArproddelightModBlocks.SALAMI_PIZZA);
    public static final RegistryObject<Item> BOSCAIOLA_PIZZA = block(ArproddelightModBlocks.BOSCAIOLA_PIZZA);
    public static final RegistryObject<Item> MAC_N_CHEESE = REGISTRY.register("mac_n_cheese", MacNCheeseItem::new);
    public static final RegistryObject<Item> TONIR = block(ArproddelightModBlocks.TONIR);
    public static final RegistryObject<Item> LAVASH = REGISTRY.register("lavash", LavashItem::new);
    public static final RegistryObject<Item> DOUBLE_HAMBURGER = REGISTRY.register("double_hamburger", DoubleHamburgerItem::new);
    public static final RegistryObject<Item> CHEESE_AND_TOMATO_DURUM = REGISTRY.register("cheese_and_tomato_durum", CheeseAndTomatoDurumItem::new);
    public static final RegistryObject<Item> UZBEK_RICE = REGISTRY.register("uzbek_rice", UzbekRiceItem::new);
    //public static final RegistryObject<Item> CREAM_BUCKET = REGISTRY.register("cream_bucket", CreamItem::new);
    public static final RegistryObject<Item> ICE_CREAM_CONE = REGISTRY.register("ice_cream_cone", IceCreamConeItem::new);
    public static final RegistryObject<Item> ICE_CREAM_CREAM = REGISTRY.register("ice_cream_cream", IceCreamItem::new);
    public static final RegistryObject<Item> ICE_CREAM_CHOCOLATE = REGISTRY.register("ice_cream_chocolate", IceCreamChocolateItem::new);
    public static final RegistryObject<Item> RAW_BEEF_LAHMAJO = REGISTRY.register("raw_beef_lahmajo", RawBeefLahmajoItem::new);
    public static final RegistryObject<Item> BEEF_LAHMAJO = REGISTRY.register("beef_lahmajo", BeefLahmajoItem::new);
    public static final RegistryObject<Item> ICE_CREAM_HONEY = REGISTRY.register("ice_cream_honey", IceCreamHoneyItem::new);
    public static final RegistryObject<Item> BANANA_PEEL = block(ArproddelightModBlocks.BANANA_PEEL);
    public static final RegistryObject<Item> BANANA = REGISTRY.register("banana", BananaItem::new);
    public static final RegistryObject<Item> GRATER = REGISTRY.register("grater", GraterItem::new);
    public static final RegistryObject<Item> GRATED_CHEESE = REGISTRY.register("grated_cheese", BasicItem::new);
    public static final RegistryObject<Item> CHERRY = REGISTRY.register("cherry", CherryItem::new);
    public static final RegistryObject<Item> WILD_COFFEA = block(ArproddelightModBlocks.WILD_COFFEA);
    public static final RegistryObject<Item> COFFEE_BERRY = REGISTRY.register("coffee_berry", CoffeeBerryItem::new);
    public static final RegistryObject<Item> COFFEE_BEAN  = block(ArproddelightModBlocks.COFFEE_BEAN);
    public static final RegistryObject<Item> RAW_CLAY_CUP = REGISTRY.register("raw_clay_cup", BasicItem::new);
    public static final RegistryObject<Item> CLAY_CUP = REGISTRY.register("clay_cup", BasicItem::new);
    public static final RegistryObject<Item> COFFEE_CUP = REGISTRY.register("coffee_cup", CoffeeCupItem::new);
    public static final RegistryObject<Item> LATTE_CUP = REGISTRY.register("latte_cup", LatteCupItem::new);
    public static final RegistryObject<Item> BANANAXE = REGISTRY.register("bananaxe", BananaxeItem::new);

    public static final RegistryObject<Item> BANANA_CRATE = REGISTRY.register("banana_crate", () -> new BananaCrateItem(ArproddelightModBlocks.BANANA_CRATE.get()));
    public static final RegistryObject<Item> CHERRY_CRATE = block(ArproddelightModBlocks.CHERRY_CRATE);
    public static final RegistryObject<Item> PEAR_CRATE = block(ArproddelightModBlocks.PEAR_CRATE);
    public static final RegistryObject<Item> COFFEE_BERRY_CRATE = block(ArproddelightModBlocks.COFFEE_BERRY_CRATE);
    public static final RegistryObject<Item> COTTON_CRATE = block(ArproddelightModBlocks.COTTON_CRATE);
    public static final RegistryObject<Item> MINT_CRATE = block(ArproddelightModBlocks.MINT_CRATE);

    public static final RegistryObject<Item> CANDY_CANE = REGISTRY.register("candy_cane", CandyCaneItem::new);
    public static final RegistryObject<Item> CANDY_SPEAR = REGISTRY.register("candy_spear", CandySpearItem::new);
    public static final RegistryObject<Item> CANDY_CANE_BLOCK = block(ArproddelightModBlocks.CANDY_CANE_BLOCK);
    public static final RegistryObject<Item> RED_BAUBLE = REGISTRY.register("red_bauble", BasicItem::new);
    public static final RegistryObject<Item> BLUE_BAUBLE = REGISTRY.register("blue_bauble", BasicItem::new);
    public static final RegistryObject<Item> YELLOW_BAUBLE = REGISTRY.register("yellow_bauble", BasicItem::new);
    public static final RegistryObject<Item> SPRUCE_LEAVES_RED_BAUBLE = block(ArproddelightModBlocks.SPRUCE_LEAVES_RED_BAUBLE);
    public static final RegistryObject<Item> SPRUCE_LEAVES_BLUE_BAUBLE = block(ArproddelightModBlocks.SPRUCE_LEAVES_BLUE_BAUBLE);
    public static final RegistryObject<Item> SPRUCE_LEAVES_YELLOW_BAUBLE = block(ArproddelightModBlocks.SPRUCE_LEAVES_YELLOW_BAUBLE);
    public static final RegistryObject<Item> KHINKALI = REGISTRY.register("khinkali", KhinkaliItem::new);
    public static final RegistryObject<Item> CHEWING_GUM = REGISTRY.register("chewing_gum", ChewingGumItem::new);
    public static final RegistryObject<Item> WILD_MINT = block(ArproddelightModBlocks.WILD_MINT);
    public static final RegistryObject<Item> MINT = REGISTRY.register("mint", BasicItem::new);
    public static final RegistryObject<Item> MARSHMALLOW = REGISTRY.register("marshmallow", MarshmallowItem::new);
    public static final RegistryObject<Item> MARSHMALLOW_ON_STICK = REGISTRY.register("marshmallow_on_stick", MarshmallowOnStickItem::new);
    public static final RegistryObject<Item> COOKED_MARSHMALLOW_ON_STICK = REGISTRY.register("cooked_marshmallow_on_stick", CookedMarshmallowOnStickItem::new);
    public static final RegistryObject<Item> BURNT_MARSHMALLOW_ON_STICK = REGISTRY.register("burnt_marshmallow_on_stick", BurntMarshmallowOnStickItem::new);
    public static final RegistryObject<Item> CHEVON = REGISTRY.register("chevon", RawChevonItem::new);
    public static final RegistryObject<Item> COOKED_CHEVON = REGISTRY.register("cooked_chevon", CookedChevonItem::new);
    public static final RegistryObject<Item> SMORE = REGISTRY.register("smore", SmoreItem::new);
    public static final RegistryObject<Item> PEAR = REGISTRY.register("pear", PearItem::new);
    public static final RegistryObject<Item> GOLDEN_PEAR = REGISTRY.register("golden_pear", GoldenPearItem::new);
    public static final RegistryObject<Item> AXOLOTL_GILLS = REGISTRY.register("axolotl_gills", AxolotlGillsItem::new);
    public static final RegistryObject<Item> AXOLOTL_HAT_HELMET = REGISTRY.register("axolotl_hat_helmet", AxolotlHatItem.Helmet::new);
    //public static final RegistryObject<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", FriedDragonEggItem::new);
//    public static final RegistryObject<Item> BOXING_GLOVE = REGISTRY.register("boxing_glove", BoxingGloveItem::new);
    public static final RegistryObject<Item> MOLD = REGISTRY.register("mold", MoldItem::new);
    public static final RegistryObject<Item> GELATIN = REGISTRY.register("gelatin", GelatinItem::new);
    public static final RegistryObject<Item> STRAWBERRY = REGISTRY.register("strawberry",
            () -> new BlockItem(ArproddelightModBlocks.STRAWBERRY.get(),
                    new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(2)
                                    .saturationMod(0.3f)
                                    .build())
            )
    );
    public static final RegistryObject<Item> STRAWBERRY_JELLY = REGISTRY.register("strawberry_jelly", StrawberryJellyItem::new);
    public static final RegistryObject<Item> GELATIN_BLOCK = block(ArproddelightModBlocks.GELATIN_BLOCK);
    public static final RegistryObject<Item> STRAWBERRY_JAM = REGISTRY.register("strawberry_jam", StrawberryJamItem::new);
    public static final RegistryObject<Item> MINT_SEEDS = block(ArproddelightModBlocks.MINT_SEEDS);
    public static final RegistryObject<Item> CINNAMON= REGISTRY.register("cinnamon", BasicItem::new);
    public static final RegistryObject<Item> CINNAMON_POWDER= REGISTRY.register("cinnamon_powder", CinnamonPowderItem::new);
    public static final RegistryObject<Item> BERRY_TEA= REGISTRY.register("berry_tea", BerryTeaItem::new);
    public static final RegistryObject<Item> CINNAMON_ROLL= REGISTRY.register("cinnamon_roll", CinnamonRollItem::new);
    public static final RegistryObject<Item> COTTON_SEEDS = block(ArproddelightModBlocks.COTTON_SEEDS);
    public static final RegistryObject<Item> WILD_COTTON = block(ArproddelightModBlocks.WILD_COTTON);
    public static final RegistryObject<Item> COTTON= REGISTRY.register("cotton", BasicItem::new);
    public static final RegistryObject<Item> MARGHERITA_PIZZA_SLICE= REGISTRY.register("margherita_pizza_slice", MargheritaSliceItem::new);
    public static final RegistryObject<Item> SALAMI_PIZZA_SLICE= REGISTRY.register("salami_pizza_slice", SalamiSliceItem::new);
    public static final RegistryObject<Item> BOSCAIOLA_PIZZA_SLICE= REGISTRY.register("boscaiola_pizza_slice", BoscaiolaSliceItem::new);
    public static final RegistryObject<Item> PEPPER= REGISTRY.register("pepper", PepperItem::new);
    public static final RegistryObject<Item> BOILED_EGG= REGISTRY.register("boiled_egg", BoiledEggItem::new);
    public static final RegistryObject<Item> DEVILED_EGGS= REGISTRY.register("deviled_eggs", DeviledEggsItem::new);
    public static final RegistryObject<Item> FRYING_BASKET= block(ArproddelightModBlocks.FRYING_BASKET);
    public static final RegistryObject<Item> SUNFLOWER_OIL_BUCKET= REGISTRY.register("sunflower_oil_bucket", SunflowerOilBucketItem::new);
    public static final RegistryObject<Item> BATTERED_COD= REGISTRY.register("battered_cod", BatteredCodItem::new);
    public static final RegistryObject<Item> FRIED_CHICKEN= REGISTRY.register("fried_chicken", FriedChickenItem::new);
    public static final RegistryObject<Item> STRAWBERRY_CHEESECAKE= block(ArproddelightModBlocks.STRAWBERRY_CHEESECAKE);
    //public static final RegistryObject<Item> PIZZA_BOX= REGISTRY.register("pizza_box", PizzaBoxItem::new);
    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(
                block.getId().getPath(),
                () -> new BlockItem(block.get(), new Item.Properties())
        );
    }
}
