package com.coracoesnumero;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CoracoesNumero.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class HudHandler {

    @SubscribeEvent
    public static void onOverlay(RenderGuiOverlayEvent.Pre event) {
        if (!event.getOverlay().id().equals(VanillaGuiOverlay.PLAYER_HEALTH.id())) return;

        // some com os coracoes vanilla
        event.setCanceled(true);

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.options.hideGui) return;
        if (mc.gameMode == null || !mc.gameMode.canHurtPlayer()) return; // criativo/espectador

        float hearts = player.getHealth() / 2.0F;
        float absorption = player.getAbsorptionAmount() / 2.0F;

        String text = fmt(hearts);
        if (absorption > 0) text += " +" + fmt(absorption);

        GuiGraphics g = event.getGuiGraphics();
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();

        // mesma posicao onde ficava a fileira de coracoes (acima da hotbar, lado esquerdo)
        int x = width / 2 - 91;
        int y = height - 39;
        g.drawString(mc.font, text, x, y, 0xFF5555, true);
    }

    private static String fmt(float v) {
        return (v == Math.floor(v)) ? String.valueOf((int) v) : String.format("%.1f", v);
    }
}
