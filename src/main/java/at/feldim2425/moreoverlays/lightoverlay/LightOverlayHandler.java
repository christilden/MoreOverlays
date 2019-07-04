package at.feldim2425.moreoverlays.lightoverlay;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class LightOverlayHandler {

	private static boolean enabled = false;

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new LightOverlayHandler());
	}

	public static boolean isEnabled() {
		return enabled;
	}

	public static void setEnabled(boolean enabled) {
		LightOverlayHandler.enabled = enabled;
	}

	public static void toggleMode() {
		enabled = !enabled;
		if (!enabled) {
			LightOverlayRenderer.clearCache();
		}
	}

	@SubscribeEvent
	public void renderWorldLastEvent(RenderWorldLastEvent event) {
		if (enabled) {
			LightOverlayRenderer.renderOverlays();
		}
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (Minecraft.getInstance().world != null && enabled && event.phase == TickEvent.Phase.END &&
				(Minecraft.getInstance().currentScreen == null || !Minecraft.getInstance().currentScreen.doesGuiPauseGame())) {
			LightOverlayRenderer.refreshCache();
		}

	}
}
