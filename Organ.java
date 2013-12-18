package braber01.amadeus;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


//TODO: Re-write using Block instead of item.

public class Organ extends Block{
	public Organ(int id,Material material){
		super(id,material);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("Organ");
		//setTextureName("amadeus:Organ");
	}
}
