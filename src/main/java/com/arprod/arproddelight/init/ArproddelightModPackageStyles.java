package com.arprod.arproddelight.init;

import com.simibubi.create.content.logistics.box.PackageStyles;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;

public class ArproddelightModPackageStyles {

    public static final PackageStyles.PackageStyle PIZZA =
            new PackageStyles.PackageStyle("pizza", 16, 3, 23f, false);

    private static final ResourceLocation PIZZA_TAG_ID =
            ResourceLocation.fromNamespaceAndPath("forge", "pizza");

    /**
     * Called by your custom PackageItem override
     */
    public static PackageStyles.PackageStyle getStyle(ItemStack box) {
        if (containsMostlyPizza(box)) {
            return PIZZA;
        }
        return null;
    }

    private static boolean containsMostlyPizza(ItemStack box) {
        CompoundTag tag = box.getTag();
        if (tag == null || !tag.contains("Items"))
            return false;

        ListTag items = tag.getList("Items", Tag.TAG_COMPOUND);

        int pizzaCount = 0;
        int otherCount = 0;

        for (int i = 0; i < items.size(); i++) {
            CompoundTag stackTag = items.getCompound(i);
            ItemStack stack = ItemStack.of(stackTag);

            if (stack.is(ItemTags.create(PIZZA_TAG_ID))) {
                pizzaCount += stack.getCount();
            } else {
                otherCount += stack.getCount();
            }
        }

        return pizzaCount > otherCount && pizzaCount > 0;
    }
}