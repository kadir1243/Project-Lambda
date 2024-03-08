package melonslise.lambda.common.network;

import melonslise.lambda.LambdaCore;
import melonslise.lambda.common.network.message.client.ClientMessageReload;
import melonslise.lambda.common.network.message.client.ClientMessageUseItem;
import melonslise.lambda.common.network.message.client.ClientMessageUseTile;
import melonslise.lambda.common.network.message.client.MessageBarnacle;
import melonslise.lambda.common.network.message.client.MessageGluonBeam;
import melonslise.lambda.common.network.message.client.MessageHeadcrabZombie;
import melonslise.lambda.common.network.message.client.MessageHoundeye;
import melonslise.lambda.common.network.message.client.MessagePower;
import melonslise.lambda.common.network.message.client.MessageSound;
import melonslise.lambda.common.network.message.client.MessageTauBeam;
import melonslise.lambda.common.network.message.client.MessageTauParticles;
import melonslise.lambda.common.network.message.client.MessageVortigaunt;
import melonslise.lambda.common.network.message.client.MessageVortigauntTarget;
import melonslise.lambda.common.network.message.server.MessageActivateTile;
import melonslise.lambda.common.network.message.server.ServerMessageReload;
import melonslise.lambda.common.network.message.server.ServerMessageUseEntity;
import melonslise.lambda.common.network.message.server.ServerMessageUseItem;
import melonslise.lambda.common.network.message.server.ServerMessageUseTile;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.neoforged.api.distmarker.Dist;

public class LambdaNetworks
{
	public static SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(LambdaCore.ID);

	private LambdaNetworks() {};

	public static void registerMessages()
	{
		int id = -1;
		network.registerMessage(ServerMessageUseItem.Handler.class, ServerMessageUseItem.class, ++id, Dist.SERVER);
		network.registerMessage(ServerMessageUseTile.Handler.class, ServerMessageUseTile.class, ++id, Dist.SERVER);
		network.registerMessage(ServerMessageUseEntity.Handler.class, ServerMessageUseEntity.class, ++id, Dist.SERVER);
		network.registerMessage(ServerMessageReload.Handler.class, ServerMessageReload.class, ++id, Dist.SERVER);

		network.registerMessage(ClientMessageUseItem.Handler.class, ClientMessageUseItem.class, ++id, Dist.CLIENT);
		network.registerMessage(ClientMessageUseTile.Handler.class, ClientMessageUseTile.class, ++id, Dist.CLIENT);
		network.registerMessage(ClientMessageReload.Handler.class, ClientMessageReload.class, ++id, Dist.CLIENT);

		network.registerMessage(MessageActivateTile.Handler.class, MessageActivateTile.class, ++id, Dist.SERVER);

		network.registerMessage(MessageHeadcrabZombie.Handler.class, MessageHeadcrabZombie.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageVortigaunt.Handler.class, MessageVortigaunt.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageVortigauntTarget.Handler.class, MessageVortigauntTarget.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageHoundeye.Handler.class, MessageHoundeye.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageBarnacle.Handler.class, MessageBarnacle.class, ++id, Dist.CLIENT);
		network.registerMessage(MessagePower.Handler.class, MessagePower.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageSound.Handler.class, MessageSound.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageTauBeam.Handler.class, MessageTauBeam.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageTauParticles.Handler.class, MessageTauParticles.class, ++id, Dist.CLIENT);
		network.registerMessage(MessageGluonBeam.Handler.class, MessageGluonBeam.class, ++id, Dist.CLIENT);
	}
}