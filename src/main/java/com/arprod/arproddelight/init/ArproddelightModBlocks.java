
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import com.arprod.arproddelight.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import com.arprod.arproddelight.ArproddelightMod;

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
	public static final RegistryObject<Block> BANANA_CRATE = REGISTRY.register("banana_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MINT_CRATE = REGISTRY.register("mint_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COFFEE_BERRY_CRATE = REGISTRY.register("coffee_berry_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_CRATE = REGISTRY.register("pear_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CHERRY_CRATE = REGISTRY.register("cherry_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COTTON_CRATE = REGISTRY.register("cotton_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> CANDY_CANE_BLOCK = REGISTRY.register("candy_cane_block", CandyCaneBlockBlock::new);
	public static final RegistryObject<Block> SPRUCE_LEAVES_RED_BAUBLE = REGISTRY.register("spruce_leaves_red_bauble", SprueLeavesRedBaubleBlock::new);
	public static final RegistryObject<Block> SPRUCE_LEAVES_BLUE_BAUBLE = REGISTRY.register("spruce_leaves_blue_bauble", SpruceLeavesBlueBaubleBlock::new);
	public static final RegistryObject<Block> SPRUCE_LEAVES_YELLOW_BAUBLE = REGISTRY.register("spruce_leaves_yellow_bauble", SpruceLeavesYellowBaubleBlock::new);
	public static final RegistryObject<Block> BANANA_PEEL = REGISTRY.register("banana_peel", BananaPeelBlock::new);
	public static final RegistryObject<Block> WILD_MINT = REGISTRY.register("wild_mint", WildMintBlock::new);
    public static final RegistryObject<Block> STRAWBERRY = REGISTRY.register("strawberry", StrawberryBlock::new);
    public static final RegistryObject<Block> GELATIN_BLOCK = REGISTRY.register("gelatin_block", GelatinBlockBlock::new);
    public static final RegistryObject<Block> MINT_SEEDS = REGISTRY.register("mint_seeds", MintSeedsBlock::new);
    public static final RegistryObject<Block> COTTON_SEEDS = REGISTRY.register("cotton_seeds", CottonSeedsBlock::new);
    public static final RegistryObject<Block> WILD_COTTON = REGISTRY.register("wild_cotton", WildCottonBlock::new);
	public static final RegistryObject<Block> COFFEE_BEAN = REGISTRY.register("coffee_bean", CoffeeBeanBlock::new);
	public static final RegistryObject<Block> FRYING_BASKET = REGISTRY.register("frying_basket", FryingBasketBlock::new);
	public static final RegistryObject<Block> SUNFLOWER_OIL = REGISTRY.register("sunflower_oil", SunflowerOilBlock::new);
	public static final RegistryObject<Block> STRAWBERRY_CHEESECAKE = REGISTRY.register("strawberry_cheesecake", StrawberryCheesecakeBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			SprueLeavesRedBaubleBlock.blockColorLoad(event);
			SpruceLeavesBlueBaubleBlock.blockColorLoad(event);
			SpruceLeavesYellowBaubleBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			SprueLeavesRedBaubleBlock.itemColorLoad(event);
			SpruceLeavesBlueBaubleBlock.itemColorLoad(event);
			SpruceLeavesYellowBaubleBlock.itemColorLoad(event);
		}
	}
}
