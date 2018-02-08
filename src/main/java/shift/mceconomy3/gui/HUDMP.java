package shift.mceconomy3.gui;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shift.mceconomy3.Config;
import shift.mceconomy3.EntityPropertieMP;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.event.MPManager;

public class HUDMP {

    public static final ResourceLocation icons = new ResourceLocation("mceconomy3:textures/guis/coin.png");

    public static int top_height = 0;
    public static int left_height = 39;
    public static int right_height = 39;

    public static Minecraft mc = FMLClientHandler.instance().getClient();

    public static boolean AIR = false;

    @SideOnly(Side.CLIENT)
    private static int Cuont = 0;

    @SideOnly(Side.CLIENT)
    public static boolean isRenderer = false;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event) {

        if (event.getType() == ElementType.FOOD && mc.playerController.shouldDrawHUD()) {
            isRenderer = true;
        }

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Post event) {

        int width = event.getResolution().getScaledWidth();
        int height = event.getResolution().getScaledHeight();

        if (!Config.HUD) return;

        if (isRenderer) {

            renderMoney(width, height);
            renderAddMoney(width, height);
            isRenderer = false;

        }

        /*
        if (event.type == ElementType.AIR) {
        	//System.out.println("AIR");

        	if (!AIR) {

        		if (Cuont > 0) {
        			GuiIngameForge.right_height += (left_height - 19);
        		} else {
        			GuiIngameForge.right_height += (left_height - 29);
        		}

        		AIR = true;
        	} else {

        		if (Cuont > 0) {
        			GuiIngameForge.right_height -= (left_height - 19);
        		} else {
        			GuiIngameForge.right_height -= (left_height - 29);
        		}

        	}

        	AIR = false;
        }*/

    }

    public static void renderMoney(int width, int height) {

        mc.mcProfiler.startSection("money");

        GlStateManager.enableBlend();
        bind(icons);

        int air = 0;

        int left = width / 2 + 9;
        int top = height - GuiIngameForge.right_height;//left_height-10+air;
        GuiIngameForge.right_height += 10;

        int money = 0;

        if (mc.player != null) {
            money = MPManager.getEntityPropertieMP(mc.player).getMp();
        }

        //金持ち
        int m = 0;
        if (String.valueOf(money).length() == 8) {
            m = -8;
        } else if (String.valueOf(money).length() == 9) {
            m = -16;
        } else if (String.valueOf(money).length() == 10) {
            m = -24;
        }

        //if (money <= 10000000)
        drawTexturedModalRect(left + m, top, 9, 0, 9, 9);//コイン
        drawTexturedModalRect(left + 65, top, 0, 18, 9, 9);//M
        drawTexturedModalRect(left + 74, top, 9, 18, 9, 9);//P

        left += 56;

        for (int i = 1; i <= String.valueOf(money).length() && i <= 10; i += 1) {
            String s = String.valueOf(money).substring(String.valueOf(money).length() - i, String.valueOf(money).length() - i + 1);
            drawTexturedModalRect(left, top, 9 * Integer.parseInt(s), 9, 9, 9);
            left -= 8;
        }

        //お金持ちの処理
        //        if (money >= 10000000) {
        //
        //            left = width / 2 + 9;
        //            top = height - GuiIngameForge.right_height;//left_height-10+air;
        //            GuiIngameForge.right_height += 10;
        //
        //            drawTexturedModalRect(left, top, 18, 18, 9, 9);
        //            //drawTexturedModalRect(left + 65, top, 0, 18, 9, 9);
        //            //drawTexturedModalRect(left + 74, top, 9, 18, 9, 9);
        //
        //            left += 56;
        //
        //            for (int i = 8; i <= String.valueOf(money).length(); i += 1) {
        //                String s = String.valueOf(money).substring(String.valueOf(money).length() - i, String.valueOf(money).length() - i + 1);
        //                drawTexturedModalRect(left, top, 9 * Integer.parseInt(s), 9, 9, 9);
        //                left -= 8;
        //            }
        //
        //        }

        GlStateManager.disableBlend();
        mc.mcProfiler.endSection();
        bind(Gui.ICONS);

    }

    public static void renderAddMoney(int width, int height) {

        mc.mcProfiler.startSection("addmoney");

        GlStateManager.enableBlend();
        bind(icons);

        int air = -9;

        int left = width / 2 + 9;
        int top = height - GuiIngameForge.right_height;//left_height - 10 + air;

        //int level = ForgeHooks.getTotalArmorValue(mc.player);
        //drawTexturedModalRect(left, top, 9, 0, 9, 9);
        //drawTexturedModalRect(left+65, top, 0, 18, 9, 9);
        //drawTexturedModalRect(left+74, top, 9, 18, 9, 9);
        // drawTexturedModalRect(left+8, top, 9, 0, 9, 9);
        //drawTexturedModalRect(left+16, top, 9, 0, 9, 9);
        //drawTexturedModalRect(left+24, top, 9, 0, 9, 9);

        int moneyD = 0;

        int moneyC = 0;

        boolean p = false;

        EntityPropertieMP pmp = MPManager.getEntityPropertieMP(mc.player);

        if (pmp != null) {

            moneyD = pmp.getMpDisplay();
            moneyC = pmp.getMpCount();

            if (moneyC != 0) {
                Cuont = 210;
                //nbt.setInteger("moneyC", 0);
                pmp.setMpCount(0);
            }

            if (moneyD < 0) {
                moneyD *= -1;
                p = true;
            }

        }

        if (Cuont > 0) {

            int g = 0;
            int m = 0;

            if (String.valueOf(Cuont).length() == 2) {

                if (Integer.parseInt(String.valueOf(Cuont).substring(0, 1)) < 8) {
                    if (p) {
                        m = 10 - (Integer.parseInt(String.valueOf(Cuont).substring(0, 1)) + 2);
                    } else {
                        g = 10 - (Integer.parseInt(String.valueOf(Cuont).substring(0, 1)) + 2);
                    }

                }

            } else if (String.valueOf(Cuont).length() == 1) {

                if (p) {
                    m = 8;
                } else {
                    g = 8;
                }

            }

            left += 56;

            int pm = 0;
            if (p) {
                pm = 9;
            }

            for (int i = 1; i <= String.valueOf(moneyD).length(); i += 1) {
                String s = String.valueOf(moneyD).substring(String.valueOf(moneyD).length() - i, String.valueOf(moneyD).length() - i + 1);
                drawTexturedModalRect(left, top + g, 9 * Integer.parseInt(s), 45 + pm + m, 9, 9 - g - m);
                left -= 8;
            }

            drawTexturedModalRect(left, top + g, 9 * 10, 45 + pm + m, 9, 9 - g - m);

            Cuont -= 4;
            if (Cuont <= 0 && mc.player != null) {
                //NBTTagCompound nbt = mc.player.getEntityData();
                //nbt.setInteger("moneyD",0);
                Cuont = 0;
                pmp.setMpDisplay(0);
            }
            GuiIngameForge.right_height += 10;
        }

        GlStateManager.disableBlend();
        mc.mcProfiler.endSection();
        bind(Gui.ICONS);

    }

    private static void bind(ResourceLocation res) {
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(res);
    }

    /*public static void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
        float zLevel = -90.0F;

        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((par1 + 0), (par2 + par6), zLevel, ((par3 + 0) * f), ((par4 + par6) * f1));
        tessellator.addVertexWithUV((par1 + par5), (par2 + par6), zLevel, ((par3 + par5) * f), ((par4 + par6) * f1));
        tessellator.addVertexWithUV((par1 + par5), (par2 + 0), zLevel, ((par3 + par5) * f), ((par4 + 0) * f1));
        tessellator.addVertexWithUV((par1 + 0), (par2 + 0), zLevel, ((par3 + 0) * f), ((par4 + 0) * f1));
        tessellator.draw();
    }*/

    public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
        float zLevel = -90.0F;

        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double) (x + 0), (double) (y + height), (double) zLevel)
                .tex((double) ((float) (textureX + 0) * f), (double) ((float) (textureY + height) * f1)).endVertex();
        worldrenderer.pos((double) (x + width), (double) (y + height), (double) zLevel)
                .tex((double) ((float) (textureX + width) * f), (double) ((float) (textureY + height) * f1)).endVertex();
        worldrenderer.pos((double) (x + width), (double) (y + 0), (double) zLevel)
                .tex((double) ((float) (textureX + width) * f), (double) ((float) (textureY + 0) * f1)).endVertex();
        worldrenderer.pos((double) (x + 0), (double) (y + 0), (double) zLevel)
                .tex((double) ((float) (textureX + 0) * f), (double) ((float) (textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }

    @SubscribeEvent
    public void onItemTooltipEvent(ItemTooltipEvent event) {

        ItemStack itemStack = event.getItemStack();
        List<String> toolTip = event.getToolTip();

        if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            //toolTip.add("If press Shift , Status is displayed");
            //return;EnumChatFormatting.GOLD+EnumChatFormatting.GOLD
        }

        int i = MCEconomyAPI.getPurchase(itemStack);

        if (i == -1) {
            toolTip.add("    " + "Not for sale");
            return;
        }

        if (i != -2) {
            toolTip.add("    " + String.format("%1$ ,9d", i) + " MP");
        }

    }

    int index = 0;

    //ツールチップ
    @SubscribeEvent
    public void RenderTooltipEvent(RenderTooltipEvent.PostBackground event) {

        index = -1;

        ItemStack item = event.getStack();
        List<String> list = event.getLines();

        if (item == null) return;

        int i = MCEconomyAPI.getPurchase(item);

        if (i == -2) return;

        if(list.size()==0) {
        	index = -1;
        	return;
        }

        for (int j = 0; j < list.size(); j++) {

            if (list.get(j).endsWith(" MP") || list.get(j).endsWith("Not for sale")) {
                index = j;
                //list.set(j, list.get(j).replaceAll("[MCE]", ""));
                break;
            }

        }

    }

    //ツールチップ
    @SubscribeEvent
    public void RenderTooltipEvent(RenderTooltipEvent.PostText event) {

    	if(index==-1)return;

        int x = event.getX() - 1;
        int y = event.getY() + 1;
        ItemStack item = event.getStack();
        List<String> list = event.getLines();

        if(list.size()==1)return;

        if (item == null) return;

        int i = MCEconomyAPI.getPurchase(item);

        if (i == -2) return;

        y += (index * 10);

        bind(icons);

        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        //GlStateManager.scale(1.2f, 1.2f, 1.2f);

        drawTexturedModalRect(x, y, 9, 0, 9, 9);

        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();

    }

}
