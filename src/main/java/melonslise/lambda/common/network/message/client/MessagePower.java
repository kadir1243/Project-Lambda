package melonslise.lambda.common.network.message.client;

import io.netty.buffer.ByteBuf;
import melonslise.lambda.utility.LambdaUtilities;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.ICustomConfigurationTask;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePower implements ICustomConfigurationTask
{
	private float power;

	public MessagePower() {};

	public MessagePower(float power)
	{
		this.power = power;
	}

	@Override
	public void fromBytes(ByteBuf buffer)
	{
		this.power = buffer.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buffer)
	{
		buffer.writeFloat(this.power);
	}



	public static class Handler implements IMessageHandler<MessagePower, ICustomConfigurationTask>
	{
		@Override
		public ICustomConfigurationTask onMessage(MessagePower message, MessageContext context)
		{
			Minecraft mc = Minecraft.getMinecraft();
			Runnable action = new Runnable()
			{
				@Override
				public void run()
				{
					LambdaUtilities.getPower(mc.player).set(message.power);
				}
			};
			mc.addScheduledTask(action);
			return null;
		}
	}
}