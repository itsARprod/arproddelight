
package com.arprod.arproddelight.item;
import com.arprod.arproddelight.init.ArproddelightModItems;
import com.arprod.arproddelight.init.ArproddelightModPackageStyles;
import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.box.PackageEntity;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.box.PackageStyles;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import com.simibubi.create.AllItems;
public class PizzaBoxItem extends PackageItem {
	public PizzaBoxItem() {
		super(new Properties(), new PackageStyles.PackageStyle("pizza", 16, 3, 23f, false));
	}

    @Override
    public String getDescriptionId() {
        return "item.arproddelight.pizza_box";
    }

    @Override
    public Entity createEntity(Level world, Entity location, ItemStack itemstack) {
        return PackageEntity.fromDroppedItem(world, location, new ItemStack(AllItems.SCHEMATIC.get()));
    }
}
