package at.feldim2425.moreoverlays;

import at.feldim2425.moreoverlays.config.ConfigHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreOverlays.MOD_ID)
public class MoreOverlays {

	public static final String MOD_ID = "moreoverlays";
	public static final String NAME = "MoreOverlays";
	public static final String VERSION = "1.14";
	public static final String UPDATE_JSON = "https://raw.githubusercontent.com/feldim2425/Mod_Update-JSONs/master/MoreOverlays.json";


	@SidedProxy(clientSide = "at.feldim2425.moreoverlays.Proxy")
	public static Proxy proxy;

	public static Logger logger = LogManager.getLogger(NAME);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event);
		if (proxy != null)
			proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		if (proxy != null)
			proxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (proxy != null)
			proxy.postInit();
	}
}
