package braber01.amadeus;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

//Fine As an Item
public class ManualKey extends Item{
	public ManualKey(int id){
		super(id);
		maxStackSize=16;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("manual_key");
		setTextureName("amadeus:key");
	}

}
