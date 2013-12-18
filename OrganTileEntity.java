package braber01.amadeus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class OrganTileEntity extends TileEntity{
	
	public boolean isUseableByPlayer(EntityPlayer entityplayer){
		return true;
	}
	
}
