
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.registry;

import com.arprod.arproddelight.block.*;
import com.arprod.arproddelight.block.grower.CinnamonTreeGrower;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import com.arprod.arproddelight.ArproddelightMod;

import java.util.function.Supplier;

public class ArproddelightModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ArproddelightMod.MODID);
	public static final RegistryObject<Block> MELTED_CHEESE = REGISTRY.register("melted_cheese", MeltedCheeseBlock::new);
	public static final RegistryObject<Block> CHEESE_BLOCK = REGISTRY.register("cheese_block", CheeseBlockBlock::new);
	public static final RegistryObject<Block> MARGHERITA_PIZZA = REGISTRY.register("margherita_pizza", MargheritaPizzaBlock::new);
	public static final RegistryObject<Block> SALAMI_PIZZA = REGISTRY.register("salami_pizza", SalamiPizzaBlock::new);
	public static final RegistryObject<Block> BOSCAIOLA_PIZZA = REGISTRY.register("boscaiola_pizza", BoscaiolaPizzaBlock::new);
	public static final RegistryObject<Block> TONIR = REGISTRY.register("tonir", TonirBlock::new);
	public static final RegistryObject<Block> WILD_COFFEA = REGISTRY.register("wild_coffea", WildCoffeaBlock::new);
	//CRATES
	public static final RegistryObject<Block> BANANA_CRATE = REGISTRY.register("banana_crate", crate());
	public static final RegistryObject<Block> MINT_CRATE = REGISTRY.register("mint_crate", crate());
	public static final RegistryObject<Block> COFFEE_BERRY_CRATE = REGISTRY.register("coffee_berry_crate", crate());
	public static final RegistryObject<Block> PEAR_CRATE = REGISTRY.register("pear_crate", crate());
	public static final RegistryObject<Block> CHERRY_CRATE = REGISTRY.register("cherry_crate", crate());
	public static final RegistryObject<Block> COTTON_CRATE = REGISTRY.register("cotton_crate", crate());
	public static final RegistryObject<Block> COFFEE_BEAN_BAG = REGISTRY.register("coffee_bean_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

	public static final RegistryObject<Block> CANDY_CANE_BLOCK = REGISTRY.register("candy_cane_block", CandyCaneBlockBlock::new);
	public static final RegistryObject<Block> BANANA_PEEL = REGISTRY.register("banana_peel", BananaPeelBlock::new);
	public static final RegistryObject<Block> WILD_MINT = REGISTRY.register("wild_mint", WildMintBlock::new);
    public static final RegistryObject<Block> GELATIN_BLOCK = REGISTRY.register("gelatin_block", GelatinBlockBlock::new);
    public static final RegistryObject<Block> MINT_SEEDS = REGISTRY.register("mint_seeds", MintSeedsBlock::new);
    public static final RegistryObject<Block> COTTON_SEEDS = REGISTRY.register("cotton_seeds", CottonSeedsBlock::new);
    public static final RegistryObject<Block> WILD_COTTON = REGISTRY.register("wild_cotton", WildCottonBlock::new);
	public static final RegistryObject<Block> COFFEE_BEAN = REGISTRY.register("coffee_bean", CoffeeBeanBlock::new);
	public static final RegistryObject<Block> FRYING_BASKET = REGISTRY.register("frying_basket", FryingBasketBlock::new);
	public static final RegistryObject<Block> SUNFLOWER_OIL = REGISTRY.register("sunflower_oil", SunflowerOilBlock::new);
	public static final RegistryObject<Block> CINNAMON_LOG = REGISTRY.register("cinnamon_log", CinnamonLogBlock::new);
	public static final RegistryObject<Block> CINNAMON_WOOD = REGISTRY.register("cinnamon_wood", CinnamonLogBlock::new);
	public static final RegistryObject<Block> CINNAMON_LEAVES =  REGISTRY.register("cinnamon_leaves", () -> new LeavesBlock((BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES))));
	public static final RegistryObject<Block> CINNAMON_SAPLING =  REGISTRY.register("cinnamon_sapling", () -> new SaplingBlock(new CinnamonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_SAPLING)));

	static Supplier<Block> crate(){
		return () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	}
}

//Blocks