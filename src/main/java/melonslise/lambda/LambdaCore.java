package melonslise.lambda;

import com.mojang.logging.LogUtils;
import melonslise.lambda.client.proxy.ClientProxy;
import melonslise.lambda.common.capability.LambdaCapabilities;
import melonslise.lambda.common.loot.LambdaLoot;
import melonslise.lambda.common.network.LambdaNetworks;
import melonslise.lambda.common.proxy.ACommonProxy;
import melonslise.lambda.common.tileentity.LambdaTileEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(LambdaCore.ID)
public class LambdaCore {
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String ID = "lambda", NAME = "Project Lambda", VERSION = "0.0.2", GAMEVERSIONS = "1.12.2";

	public static ACommonProxy proxy;

	private void commonSetup(final FMLCommonSetupEvent event) {
		LambdaLoot.register();
		LambdaCapabilities.register();
		LambdaTileEntities.register();
		LambdaNetworks.registerMessages();
	}

	// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents
	{
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			proxy = new ClientProxy();
			proxy.registerRenderers();
			proxy.registerKeyBindings();
			proxy.attachLayers();
		}
	}
}