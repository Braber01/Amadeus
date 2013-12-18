package braber01.amadeus;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;

/*
 * Amadeus adds Decroitive organs to Minecraft
 * Copyright (C) <2013>  <Ben Raber>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

@Mod(modid="AmadeusModID",name="Amadeus",version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class Amadeus {
	
	public static Item organPipe;
	public static Item organManual;
	public static Item organPedal;
	public static Item plastic;
	public static Block organ;
	public static Item manualKey;
	
	//Instance of the mod
	@Instance(value ="AmadeusModID")
	public static Amadeus instance;
	
	@SidedProxy(clientSide="braber01.amadeus.client.ClientProxy",
			serverSide="braber01.amadeus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//stub Method
		//2171 unused Item Id to Start items
		plastic = new Plastic(2171).setTextureName("amadeus:plastic2");
		organManual = new OrganManual(2172).setTextureName("amadeus:organManual");
		organPipe = new OrganPipe(2173).setTextureName("amadeus:organPipe");
		organPedal = new OrganPedal(2174);
		manualKey = new ManualKey(2175).setTextureName("amadeus:key");
		organ = new Organ(2176,Material.ground).setHardness(0.5f).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("organ").setCreativeTab(CreativeTabs.tabBlock);
		//LanguageRegistry.instance().
		
		
		//func_111206_d for items
		//func_111022_d for blocks
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		/*
		 * ItemStack unknownItemStack = new ItemStack(1, 3, 0);
		 * This is a stack of 3 of the block with id 1.
		 * Possibly dirt? It's better to try getting a reference to the item
		 * or block first. Again, all vanilla items can be found in 
		 * net.minecraft.block.Block and net.minecraft.item.Item.
		 */
		GameRegistry.registerBlock(organ, "organ");
		MinecraftForge.setBlockHarvestLevel(organ, "pickaxe", 1);
		LanguageRegistry.addName(organ, "Organ");
		LanguageRegistry.addName(plastic, "Plastic Pellets");
		LanguageRegistry.addName(organManual, "Organ Manual");
		LanguageRegistry.addName(organPipe, "Organ Pipe");
		LanguageRegistry.addName(organPedal,"Organ Pedal");
		LanguageRegistry.addName(manualKey,"Manual Key");
		
	
		ItemStack ingotIron = new ItemStack(Item.ingotIron); // For crafting the pipes
		ItemStack noteBlock = new ItemStack(25,1,0); // used in crafting ALL the things
		ItemStack plankStack = new ItemStack(Block.planks); // used for the pedals
		ItemStack slimballStack = new ItemStack(Item.slimeBall); //used to craft plastic to craft the keys
		ItemStack plasticStack = new ItemStack(plastic);
		ItemStack manualKeyStack = new ItemStack(manualKey);
		ItemStack organManualStack = new ItemStack(organManual);
		ItemStack organPipeStack = new ItemStack(organPipe);
		
		
		
		GameRegistry.addSmelting(Item.slimeBall.itemID, plasticStack, 0.1f);
		//GameRegistry.addShapelessRecipe(manualKeyStack, plasticStack,plasticStack,plasticStack,plasticStack,plasticStack,plasticStack);
		GameRegistry.addShapedRecipe(manualKeyStack,new Object[]{"x x","xyx","x x",'x',plasticStack,'y',noteBlock});
		GameRegistry.addShapelessRecipe(organManualStack, manualKey,manualKey,manualKey);
		//GameRegistry.addRecipe(String row1, [String row2[, String row3]] char itemType1, ItemStack itemStackType1[, ... char itemTypeN, ItemStack itemStackTypeN]);
		
		GameRegistry.addShapedRecipe(organPipeStack, new Object[]{"x x","xyx","x x",'x',ingotIron,'y',noteBlock});
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//stub method
		
	}
	
	
}
