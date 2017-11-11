package shift.mceconomy3.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shift.mceconomy3.MCEconomy3;

@SideOnly(Side.CLIENT)
public class GuiButtonMerchant extends GuiButton {
    public static final ResourceLocation optionsBackground = new ResourceLocation(MCEconomy3.MODID,
            "textures/guis/villager.png");
    /**
     * If true, then next page button will face to right, if false then next page button will face to left.
     */
    private final boolean mirrored;

    public GuiButtonMerchant(int par1, int par2, int par3, boolean par4) {
        super(par1, par2, par3, 12, 19, "");
        this.mirrored = par4;

    }

    /**
     * Draws this button to the screen.
     */
    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3, float partialTicks) {
        if (this.visible) {
            par1Minecraft.getTextureManager().bindTexture(this.optionsBackground);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = par2 >= this.x && par3 >= this.y && par2 < this.x + this.width
                    && par3 < this.y + this.height;
            int k = 0;
            int l = 176;

            if (!this.enabled) {
                l += this.width * 2;
            } else if (flag) {
                l += this.width;
            }

            if (!this.mirrored) {
                k += this.height;
            }

            this.drawTexturedModalRect(this.x, this.y, l, k, this.width, this.height);
        }
    }
}
