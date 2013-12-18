package braber01.amadeus;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

//Block?

public class OrganPedal extends Item{
	public OrganPedal(int id){
		super(id);
		maxStackSize=16;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("organ_pedal");
	}

}
