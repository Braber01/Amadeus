package braber01.amadeus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Plastic extends Item{
	public Plastic(int id){
		super(id);
		maxStackSize=16;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("plastic");
		setTextureName("amadeus:plastic");
		
	}

}
