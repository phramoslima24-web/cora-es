package br.addons.narutoto.hud.client;

import br.addons.narutoto.hud.NarutotoHudNumerica;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NarutotoHudNumerica.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class HealthNumberOverlay {
    private HealthNumberOverlay() {}

    @SubscribeEvent
    public static void onOverlayPre(RenderGuiOverlayEvent.Pre event) {
        // Esconde a camada de armadura vanilla (ícones acima da barra de vida).
        if (event.getOverlay() == VanillaGuiOverlay.ARMOR_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }

        // Substitui somente os corações pela indicação numérica.
        if (event.getOverlay() != VanillaGuiOverlay.PLAYER_HEALTH.type()) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui) {
            return;
        }

        event.setCanceled(true);

        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        int current = Math.max(0, (int) Math.ceil(health));
        int maximum = Math.max(1, (int) Math.ceil(maxHealth));

        String value = current + "/" + maximum;
        int color = health <= maxHealth * 0.25F
                ? ChatFormatting.RED.getColor()
                : 0xFFFFFF;

        GuiGraphics graphics = event.getGuiGraphics();
        int x = 10;
        int y = event.getWindow().getGuiScaledHeight() - 39;
        graphics.drawString(minecraft.font, value, x, y, color, true);
    }
}
