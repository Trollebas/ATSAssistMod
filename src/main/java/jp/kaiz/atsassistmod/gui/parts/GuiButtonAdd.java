package jp.kaiz.atsassistmod.gui.parts;

import jp.kaiz.atsassistmod.gui.GuiTextureManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public class GuiButtonAdd extends GuiButton {

    public GuiButtonAdd(int id, int xPos, int yPos) {
        super(id, xPos, yPos, 18, 18, "");
    }

    @Override
    public void drawButton(Minecraft mc, int x, int y) {
        if (this.visible) {
            GL11.glPushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            switch (this.getHoverState(this.field_146123_n)) {
                case 1:
                    GL11.glTranslatef(this.xPosition, this.yPosition, 1.0F);
                    GL11.glScalef((35 / 2f) / 256F, (35 / 2f) / 256F, 1.0F);
                    break;
                case 2:
                    GL11.glTranslatef(this.xPosition + 0.875F, this.yPosition + 0.875F, 1.0F);
                    GL11.glScalef((35 / 2f) / 256F * 0.9F, (35 / 2f) / 256F * 0.9F, 1.0F);
                    break;
                default:
                    return;
            }
            this.field_146123_n = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            mc.getTextureManager().bindTexture(GuiTextureManager.AddButton.texture);
            this.drawTexturedModalRect(0, 0, 0, 0, 256, 256);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glPopMatrix();
            this.mouseDragged(mc, x, y);
        }
    }
}
