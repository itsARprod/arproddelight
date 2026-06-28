package com.arprod.arproddelight.item.template;

import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.List;

public final class ItemTooltipHelper {
    private ItemTooltipHelper() {
    }

    public static void addCreateDescription(Item item, List<Component> tooltip) {
        ItemDescription description = ItemDescription.create(item, FontHelper.Palette.STANDARD_CREATE);

        if (description != null) {
            tooltip.addAll(description.getCurrentLines());
        }
    }
}
