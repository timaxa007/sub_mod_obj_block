package sub_mod.obj_block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod (modid = ModBlockObj.MODID, name = ModBlockObj.MODNAME, version = ModBlockObj.VERSION)

public class ModBlockObj {

	public static final String MODID = "sub_mod_obj_block";
	public static final String MODNAME = "SM_OB";
	public static final String VERSION = "0.1a";

	@Instance(ModBlockObj.MODID) public static ModBlockObj instance;
	@SidedProxy(modId = ModBlockObj.MODID, clientSide = "sub_mod.obj_block.ProxyClient", serverSide = "sub_mod.obj_block.ProxyCommon")
	public static ProxyCommon proxy;

	public static Block block_obj;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		block_obj = new BlockObj();
		GameRegistry.registerBlock(block_obj, "block_obj");

		GameRegistry.registerTileEntity(TileEntityObj.class, "TileEntityObj");

		proxy.preInit();

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}