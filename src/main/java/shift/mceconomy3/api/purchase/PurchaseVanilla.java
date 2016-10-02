package shift.mceconomy3.api.purchase;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@PurchaseItems
public class PurchaseVanilla {

    @PurchaseItems.EventHandler
    public void registerPurchaseItems(IPurchaseRegistry registry) {

        //建築 Block
        registry.addPurchaseItem(new ItemStack(Blocks.STONE), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 1), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 2), 4);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 3), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 4), 4);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 5), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE, 1, 6), 4);
        registry.addPurchaseItem(new ItemStack(Blocks.GRASS), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.DIRT), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.DIRT, 1, 2), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.DIRT, 1, 1), 6);
        registry.addPurchaseItem(new ItemStack(Blocks.COBBLESTONE), 0);

        for (int i = 0; i < 6; i++) {
            registry.addPurchaseItem(new ItemStack(Blocks.PLANKS, 1, i), 4);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.BEDROCK), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.SAND), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.SAND, 1, 1), 4);//赤砂
        registry.addPurchaseItem(new ItemStack(Blocks.GRAVEL), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.GOLD_ORE), 2000);
        registry.addPurchaseItem(new ItemStack(Blocks.IRON_ORE), 100);
        registry.addPurchaseItem(new ItemStack(Blocks.COAL_ORE), 70);
        for (int i = 0; i < 6; i++) {
            registry.addPurchaseItem(new ItemStack(Blocks.LOG, 1, i), 10);
        }
        for (int i = 0; i < 2; i++) {
            registry.addPurchaseItem(new ItemStack(Blocks.LOG2, 1, i), 10);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.SPONGE), 50);
        registry.addPurchaseItem(new ItemStack(Blocks.SPONGE, 1, 1), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.GLASS), 30);
        registry.addPurchaseItem(new ItemStack(Blocks.LAPIS_ORE), 1200);
        registry.addPurchaseItem(new ItemStack(Blocks.LAPIS_BLOCK), 2000);
        registry.addPurchaseItem(new ItemStack(Blocks.SANDSTONE), 8);
        for (int i = 1; i < 3; i++) {
            registry.addPurchaseItem(new ItemStack(Blocks.SANDSTONE, 1, i), 16);
        }
        for (int i = 0; i < 16; i++) {
            registry.addPurchaseItem(new ItemStack(Blocks.WOOL, 1, i), 60);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.GOLD_BLOCK), 36000);
        registry.addPurchaseItem(new ItemStack(Blocks.IRON_BLOCK), 4500);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 0), 2);//焼石
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 1), 8);//砂岩
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 3), 0);//石
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 4), 200);//レンガ
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 5), 12);//石レンガ
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 6), 50);//ネザーレンガ
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_STONE_SLAB, 1, 7), 1200);//水晶
        //ハーフ
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 0), 1);//焼石
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 1), 4);//砂岩
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 3), 0);//石
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 4), 100);//レンガ
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 5), 5);//石レンガ
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 6), 25);//ネザーレンガ
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB, 1, 7), 600);//水晶
        //
        registry.addPurchaseItem(new ItemStack(Blocks.BRICK_BLOCK), 200);
        registry.addPurchaseItem(new ItemStack(Blocks.BOOKSHELF), 510);
        registry.addPurchaseItem(new ItemStack(Blocks.MOSSY_COBBLESTONE), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.OBSIDIAN), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.OAK_STAIRS), 10);//オークの階段
        registry.addPurchaseItem(new ItemStack(Blocks.DIAMOND_ORE), 8000);
        registry.addPurchaseItem(new ItemStack(Blocks.DIAMOND_BLOCK), 90000);
        registry.addPurchaseItem(new ItemStack(Blocks.WHEAT), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.FARMLAND), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_STAIRS), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.REDSTONE_ORE), 50);
        registry.addPurchaseItem(new ItemStack(Blocks.LIT_REDSTONE_ORE), -1);//光っているレッドストーン
        registry.addPurchaseItem(new ItemStack(Blocks.ICE), 65);
        registry.addPurchaseItem(new ItemStack(Blocks.SNOW), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.CLAY), 120);
        registry.addPurchaseItem(new ItemStack(Blocks.PUMPKIN), 90);
        registry.addPurchaseItem(new ItemStack(Blocks.NETHERRACK), 0);
        registry.addPurchaseItem(new ItemStack(Blocks.SOUL_SAND), 2);
        registry.addPurchaseItem(new ItemStack(Blocks.GLOWSTONE), 400);
        registry.addPurchaseItem(new ItemStack(Blocks.PORTAL), -1);//ポータル
        registry.addPurchaseItem(new ItemStack(Blocks.LIT_PUMPKIN), 120);
        registry.addPurchaseItem(new ItemStack(Blocks.STONEBRICK), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.STONEBRICK, 1, 1), 8);
        registry.addPurchaseItem(new ItemStack(Blocks.STONEBRICK, 1, 2), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.STONEBRICK, 1, 3), 14);
        registry.addPurchaseItem(new ItemStack(Blocks.MELON_BLOCK), 95);
        registry.addPurchaseItem(new ItemStack(Blocks.PUMPKIN_STEM), -1);//根
        registry.addPurchaseItem(new ItemStack(Blocks.MELON_STEM), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.BRICK_STAIRS), 210);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_BRICK_STAIRS), 12);
        registry.addPurchaseItem(new ItemStack(Blocks.MYCELIUM), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.NETHER_BRICK), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.NETHER_BRICK_STAIRS), 12);
        registry.addPurchaseItem(new ItemStack(Blocks.NETHER_WART), -1);//ブロック状態のネザーウォート
        registry.addPurchaseItem(new ItemStack(Blocks.END_STONE), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.DRAGON_EGG), -1);
        for (int I = 0; I < 6; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_WOODEN_SLAB, 1, I), 4);
        }
        for (int I = 0; I < 6; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.WOODEN_SLAB, 1, I), 2);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.SANDSTONE_STAIRS), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.EMERALD_ORE), 1500);
        registry.addPurchaseItem(new ItemStack(Blocks.EMERALD_BLOCK), 2700);
        registry.addPurchaseItem(new ItemStack(Blocks.SPRUCE_STAIRS), 10);//まつの階段
        registry.addPurchaseItem(new ItemStack(Blocks.BIRCH_STAIRS), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.JUNGLE_STAIRS), 10);
        for (int I = 0; I < 2; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.COBBLESTONE_WALL, 1, I), 2);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.QUARTZ_ORE), 280);
        registry.addPurchaseItem(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), 1200);
        registry.addPurchaseItem(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1), 1280);
        registry.addPurchaseItem(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 2), 1280);
        registry.addPurchaseItem(new ItemStack(Blocks.QUARTZ_STAIRS), 1400);
        for (int I = 0; I < 16; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, I), 130);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.HAY_BLOCK), 450);
        registry.addPurchaseItem(new ItemStack(Blocks.HARDENED_CLAY), 130);
        registry.addPurchaseItem(new ItemStack(Blocks.COAL_BLOCK), 450);
        registry.addPurchaseItem(new ItemStack(Blocks.PACKED_ICE), 100);
        registry.addPurchaseItem(new ItemStack(Blocks.ACACIA_STAIRS), 10);//階段
        registry.addPurchaseItem(new ItemStack(Blocks.DARK_OAK_STAIRS), 10);
        for (int I = 0; I < 16; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.STAINED_GLASS, 1, I), 35);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.PRISMARINE), 20);//海
        registry.addPurchaseItem(new ItemStack(Blocks.PRISMARINE, 1, 1), 45);
        registry.addPurchaseItem(new ItemStack(Blocks.PRISMARINE, 1, 2), 42);
        registry.addPurchaseItem(new ItemStack(Blocks.SEA_LANTERN, 1, 0), 120);
        registry.addPurchaseItem(new ItemStack(Blocks.RED_SANDSTONE, 1, 0), 32);//砂
        registry.addPurchaseItem(new ItemStack(Blocks.RED_SANDSTONE, 1, 1), 54);//砂
        registry.addPurchaseItem(new ItemStack(Blocks.RED_SANDSTONE, 1, 2), 54);//砂
        registry.addPurchaseItem(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 1, 0), 30);//砂
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_SLAB2, 1, 0), 8);//砂
        registry.addPurchaseItem(new ItemStack(Blocks.PURPUR_BLOCK, 1, 0), 5);//パァー
        registry.addPurchaseItem(new ItemStack(Blocks.PURPUR_PILLAR, 1, 0), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.PURPUR_STAIRS, 1, 0), 6);
        registry.addPurchaseItem(new ItemStack(Blocks.PURPUR_SLAB, 1, 0), 2);
        registry.addPurchaseItem(new ItemStack(Blocks.END_BRICKS, 1, 0), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.BEETROOTS, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.GRASS_PATH, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.FROSTED_ICE, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.field_189877_df, 1, 0), 20);//マグマ
        registry.addPurchaseItem(new ItemStack(Blocks.field_189878_dg, 1, 0), 100);//ネザー
        registry.addPurchaseItem(new ItemStack(Blocks.field_189879_dh, 1, 0), 38);
        registry.addPurchaseItem(new ItemStack(Blocks.field_189880_di, 1, 0), 100);//骨

        //建築 ITEM

        //装飾 BLOCK
        for (int I = 0; I < 6; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.SAPLING, 1, I), 2);
        }
        for (int I = 0; I < 6; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.LEAVES, 1, I), 3);
        }
        for (int I = 0; I < 2; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.LEAVES2, 1, I), 3);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.BED), -1);//ブロック状態のベッド
        registry.addPurchaseItem(new ItemStack(Blocks.WEB), 40);
        for (int I = 0; I < 3; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.TALLGRASS, 1, I), 1);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.YELLOW_FLOWER), 20);
        for (int I = 0; I < 9; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.RED_FLOWER, 1, I), 20);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.BROWN_MUSHROOM), 15);
        registry.addPurchaseItem(new ItemStack(Blocks.RED_MUSHROOM), 15);
        registry.addPurchaseItem(new ItemStack(Blocks.TORCH), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.FIRE), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.MOB_SPAWNER), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.CHEST), 50);
        registry.addPurchaseItem(new ItemStack(Blocks.CRAFTING_TABLE), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.FURNACE), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.LIT_FURNACE), -1);//火のついたカマド
        registry.addPurchaseItem(new ItemStack(Blocks.STANDING_SIGN), -1);//看板
        registry.addPurchaseItem(new ItemStack(Blocks.LADDER), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.WALL_SIGN), -1);//壁看板
        registry.addPurchaseItem(new ItemStack(Blocks.SNOW_LAYER), -1);//浅い雪
        registry.addPurchaseItem(new ItemStack(Blocks.CACTUS), 60);
        registry.addPurchaseItem(new ItemStack(Blocks.REEDS), -1);//ブロックのサトウキビ
        registry.addPurchaseItem(new ItemStack(Blocks.JUKEBOX), 10250);
        registry.addPurchaseItem(new ItemStack(Blocks.OAK_FENCE), 8);//フェンス
        registry.addPurchaseItem(new ItemStack(Blocks.SPRUCE_FENCE), 8);
        registry.addPurchaseItem(new ItemStack(Blocks.BIRCH_FENCE), 8);
        registry.addPurchaseItem(new ItemStack(Blocks.JUNGLE_FENCE), 8);
        registry.addPurchaseItem(new ItemStack(Blocks.DARK_OAK_FENCE), 8);
        registry.addPurchaseItem(new ItemStack(Blocks.ACACIA_FENCE), 8);
        for (int I = 0; I < 6; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.MONSTER_EGG, 1, I), -1);//シルバーFISH
        }
        registry.addPurchaseItem(new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.RED_MUSHROOM_BLOCK), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.IRON_BARS), 190);
        registry.addPurchaseItem(new ItemStack(Blocks.GLASS_PANE), 12);
        registry.addPurchaseItem(new ItemStack(Blocks.VINE), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.WATERLILY), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.NETHER_BRICK_FENCE), 12);
        registry.addPurchaseItem(new ItemStack(Blocks.ENCHANTING_TABLE), 22000);
        registry.addPurchaseItem(new ItemStack(Blocks.END_PORTAL), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.END_PORTAL_FRAME), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.ENDER_CHEST), 150);
        registry.addPurchaseItem(new ItemStack(Blocks.FLOWER_POT), -1);//植木鉢
        registry.addPurchaseItem(new ItemStack(Blocks.SKULL), -1);//頭
        registry.addPurchaseItem(new ItemStack(Blocks.ANVIL, 1, 0), 16000);
        registry.addPurchaseItem(new ItemStack(Blocks.ANVIL, 1, 1), -1);//少し壊れた金床
        registry.addPurchaseItem(new ItemStack(Blocks.ANVIL, 1, 2), -1);//壊れた金床
        registry.addPurchaseItem(new ItemStack(Blocks.TRAPPED_CHEST), 520);
        for (int I = 0; I < 16; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.CARPET, 1, I), 60);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 0), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 1), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 2), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 3), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 4), 20);
        registry.addPurchaseItem(new ItemStack(Blocks.DOUBLE_PLANT, 1, 5), 20);
        for (int I = 0; I < 16; I++) {
            registry.addPurchaseItem(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, I), 18);
        }
        registry.addPurchaseItem(new ItemStack(Blocks.STANDING_BANNER, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.WALL_BANNER, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.END_ROD, 1, 0), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.CHORUS_PLANT, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.CHORUS_FLOWER, 1, 0), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.field_189881_dj, 1, 0), -1);//ストラクチャー
        registry.addPurchaseItem(new ItemStack(Blocks.STRUCTURE_BLOCK, 1, 0), -1);
        //装飾 ITEM
        registry.addPurchaseItem(new ItemStack(Items.PAINTING), 20);
        registry.addPurchaseItem(new ItemStack(Items.SIGN), 24);
        registry.addPurchaseItem(new ItemStack(Items.BED), 200);
        registry.addPurchaseItem(new ItemStack(Items.ITEM_FRAME), 60);
        registry.addPurchaseItem(new ItemStack(Items.FLOWER_POT), 150);
        registry.addPurchaseItem(new ItemStack(Items.SKULL), 50);
        registry.addPurchaseItem(new ItemStack(Items.SKULL, 1, 1), 50);
        registry.addPurchaseItem(new ItemStack(Items.SKULL, 1, 2), 50);
        registry.addPurchaseItem(new ItemStack(Items.SKULL, 1, 3), 50);
        registry.addPurchaseItem(new ItemStack(Items.SKULL, 1, 4), 50);
        registry.addPurchaseItem(new ItemStack(Items.SKULL, 1, 5), 15000);
        registry.addPurchaseItem(new ItemStack(Items.ARMOR_STAND, 1, 0), 30);
        registry.addPurchaseItem(new ItemStack(Items.BANNER, 1, OreDictionary.WILDCARD_VALUE), 400);
        registry.addPurchaseItem(new ItemStack(Items.END_CRYSTAL, 1, 0), -1);

        //レッドストーン BLOCK
        registry.addPurchaseItem(new ItemStack(Blocks.DISPENSER), 200);
        registry.addPurchaseItem(new ItemStack(Blocks.NOTEBLOCK), 120);
        registry.addPurchaseItem(new ItemStack(Blocks.STICKY_PISTON), 800);
        registry.addPurchaseItem(new ItemStack(Blocks.PISTON), 700);
        registry.addPurchaseItem(new ItemStack(Blocks.PISTON_HEAD), -1);//ピストンの先
        registry.addPurchaseItem(new ItemStack(Blocks.PISTON_EXTENSION), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.TNT), 80);
        registry.addPurchaseItem(new ItemStack(Blocks.REDSTONE_WIRE), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.OAK_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.SPRUCE_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.BIRCH_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.JUNGLE_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.ACACIA_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.DARK_OAK_DOOR), -1);//木のドア
        registry.addPurchaseItem(new ItemStack(Blocks.LEVER), 55);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_PRESSURE_PLATE), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.IRON_DOOR), -1);//鉄のドア
        registry.addPurchaseItem(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE), 10);
        registry.addPurchaseItem(new ItemStack(Blocks.UNLIT_REDSTONE_TORCH), -1);//消えているレッドストーンTOUCH
        registry.addPurchaseItem(new ItemStack(Blocks.REDSTONE_TORCH), 45);
        registry.addPurchaseItem(new ItemStack(Blocks.STONE_BUTTON), 1);
        registry.addPurchaseItem(new ItemStack(Blocks.UNPOWERED_REPEATER), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.POWERED_REPEATER), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.TRAPDOOR), 15);
        registry.addPurchaseItem(new ItemStack(Blocks.IRON_TRAPDOOR), 1200);
        registry.addPurchaseItem(new ItemStack(Blocks.OAK_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.SPRUCE_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.BIRCH_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.JUNGLE_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.DARK_OAK_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.ACACIA_FENCE_GATE), 10);//フェンスゲート
        registry.addPurchaseItem(new ItemStack(Blocks.REDSTONE_LAMP), 1500);
        registry.addPurchaseItem(new ItemStack(Blocks.LIT_REDSTONE_LAMP), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.TRIPWIRE_HOOK), 250);
        registry.addPurchaseItem(new ItemStack(Blocks.TRIPWIRE), -1);//糸
        registry.addPurchaseItem(new ItemStack(Blocks.COMMAND_BLOCK), -1);//コマンドブロック
        registry.addPurchaseItem(new ItemStack(Blocks.WOODEN_BUTTON), 5);
        registry.addPurchaseItem(new ItemStack(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), 8000);
        registry.addPurchaseItem(new ItemStack(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), 1000);
        registry.addPurchaseItem(new ItemStack(Blocks.UNPOWERED_COMPARATOR), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.POWERED_COMPARATOR), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.DAYLIGHT_DETECTOR), 1000);
        registry.addPurchaseItem(new ItemStack(Blocks.REDSTONE_BLOCK), 360);
        registry.addPurchaseItem(new ItemStack(Blocks.HOPPER), 2600);
        registry.addPurchaseItem(new ItemStack(Blocks.DROPPER), 50);
        registry.addPurchaseItem(new ItemStack(Blocks.REPEATING_COMMAND_BLOCK), -1);
        registry.addPurchaseItem(new ItemStack(Blocks.CHAIN_COMMAND_BLOCK), -1);
        //レッドストーン ITEM
        registry.addPurchaseItem(new ItemStack(Items.OAK_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.SPRUCE_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.BIRCH_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.JUNGLE_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.ACACIA_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.DARK_OAK_DOOR), 28);
        registry.addPurchaseItem(new ItemStack(Items.IRON_DOOR), 2800);
        registry.addPurchaseItem(new ItemStack(Items.REDSTONE), 40);
        registry.addPurchaseItem(new ItemStack(Items.REPEATER), 150);
        registry.addPurchaseItem(new ItemStack(Items.COMPARATOR), 210);

        //移動 BLOCK
        registry.addPurchaseItem(new ItemStack(Blocks.GOLDEN_RAIL), 4100);
        registry.addPurchaseItem(new ItemStack(Blocks.DETECTOR_RAIL), 600);
        registry.addPurchaseItem(new ItemStack(Blocks.RAIL), 250);
        registry.addPurchaseItem(new ItemStack(Blocks.ACTIVATOR_RAIL), 600);
        //移動 ITEM
        registry.addPurchaseItem(new ItemStack(Items.MINECART), 800);
        registry.addPurchaseItem(new ItemStack(Items.SADDLE), 40);
        registry.addPurchaseItem(new ItemStack(Items.BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.SPRUCE_BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.BIRCH_BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.JUNGLE_BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.ACACIA_BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.DARK_OAK_BOAT), 30);
        registry.addPurchaseItem(new ItemStack(Items.CHEST_MINECART), 830);
        registry.addPurchaseItem(new ItemStack(Items.FURNACE_MINECART), 820);
        registry.addPurchaseItem(new ItemStack(Items.CARROT_ON_A_STICK), 26);
        registry.addPurchaseItem(new ItemStack(Items.TNT_MINECART), 800);
        registry.addPurchaseItem(new ItemStack(Items.HOPPER_MINECART), 980);
        registry.addPurchaseItem(new ItemStack(Items.COMMAND_BLOCK_MINECART), -1);
        registry.addPurchaseItem(new ItemStack(Items.ELYTRA), 600);

        //その他 BLOCK
        registry.addPurchaseItem(new ItemStack(Blocks.BEACON), 9000);
        //その他 ITEM
        registry.addPurchaseItem(new ItemStack(Items.BUCKET), 150);
        registry.addPurchaseItem(new ItemStack(Items.WATER_BUCKET), 150);
        registry.addPurchaseItem(new ItemStack(Items.LAVA_BUCKET), 200);
        registry.addPurchaseItem(new ItemStack(Items.SNOWBALL), 0);
        registry.addPurchaseItem(new ItemStack(Items.MILK_BUCKET), 600);
        registry.addPurchaseItem(new ItemStack(Items.PAPER), 10);
        registry.addPurchaseItem(new ItemStack(Items.BOOK), 150);
        registry.addPurchaseItem(new ItemStack(Items.SLIME_BALL), 1);
        registry.addPurchaseItem(new ItemStack(Items.BONE), 1);
        registry.addPurchaseItem(new ItemStack(Items.FILLED_MAP), 1);
        registry.addPurchaseItem(new ItemStack(Items.ENDER_PEARL), 20);
        registry.addPurchaseItem(new ItemStack(Items.ENDER_EYE), 20);
        registry.addPurchaseItem(new ItemStack(Items.SPAWN_EGG, 1, OreDictionary.WILDCARD_VALUE), -1);
        registry.addPurchaseItem(new ItemStack(Items.EXPERIENCE_BOTTLE), 150);
        registry.addPurchaseItem(new ItemStack(Items.FIRE_CHARGE), 50);
        registry.addPurchaseItem(new ItemStack(Items.WRITABLE_BOOK), 180);
        registry.addPurchaseItem(new ItemStack(Items.WRITTEN_BOOK), -1);
        registry.addPurchaseItem(new ItemStack(Items.MAP), 10);
        registry.addPurchaseItem(new ItemStack(Items.FIREWORKS, 1, OreDictionary.WILDCARD_VALUE), 10);
        registry.addPurchaseItem(new ItemStack(Items.FIREWORK_CHARGE, 1, OreDictionary.WILDCARD_VALUE), 10);
        registry.addPurchaseItem(new ItemStack(Items.IRON_HORSE_ARMOR), 1000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_HORSE_ARMOR), 10000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_HORSE_ARMOR), 20000);
        registry.addPurchaseItem("record", 500);
        registry.addPurchaseItem(new ItemStack(Items.RECORD_11), -1);

        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_13), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_CAT), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_BLOCKS), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_CHIRP), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_FAR), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_MALL), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_MELLOHI), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_STAL), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_STRAD), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_WARD), 500);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_11), -1);
        //        registry.addPurchaseItem(new ItemStack(Items.RECORD_WAIT), 500);

        //食べ物 BLOCK
        registry.addPurchaseItem(new ItemStack(Blocks.CAKE), -1);//ブロックのケーキ
        registry.addPurchaseItem(new ItemStack(Blocks.COCOA), -1);//ブロック状態のカカオ
        registry.addPurchaseItem(new ItemStack(Blocks.CARROTS), -1);//にんじん
        registry.addPurchaseItem(new ItemStack(Blocks.POTATOES), -1);//じゃがいも

        //食べ物 ITEM
        registry.addPurchaseItem(new ItemStack(Items.APPLE), 20);
        registry.addPurchaseItem(new ItemStack(Items.MUSHROOM_STEW), 50);
        registry.addPurchaseItem(new ItemStack(Items.PORKCHOP), 20);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_PORKCHOP), 28);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_APPLE, 1, 0), 4000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_APPLE, 1, 1), 36000);
        registry.addPurchaseItem(new ItemStack(Items.FISH, 1, 0), 62);
        registry.addPurchaseItem(new ItemStack(Items.FISH, 1, 1), 272);//さけ
        registry.addPurchaseItem(new ItemStack(Items.FISH, 1, 2), 160);//くまのみ
        registry.addPurchaseItem(new ItemStack(Items.FISH, 1, 3), 104);//ふぐ
        registry.addPurchaseItem(new ItemStack(Items.COOKED_FISH, 1, 0), 70);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_FISH, 1, 1), 296);
        registry.addPurchaseItem(new ItemStack(Items.CAKE), 640);
        registry.addPurchaseItem(new ItemStack(Items.COOKIE), 22);
        registry.addPurchaseItem(new ItemStack(Items.MELON), 8);
        registry.addPurchaseItem(new ItemStack(Items.BEEF), 90);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_BEEF), 100);
        registry.addPurchaseItem(new ItemStack(Items.CHICKEN), 40);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_CHICKEN), 50);
        registry.addPurchaseItem(new ItemStack(Items.ROTTEN_FLESH), 0);
        registry.addPurchaseItem(new ItemStack(Items.SPIDER_EYE), 1);
        registry.addPurchaseItem(new ItemStack(Items.CARROT), 53);
        registry.addPurchaseItem(new ItemStack(Items.POTATO), 42);
        registry.addPurchaseItem(new ItemStack(Items.BAKED_POTATO), 50);
        registry.addPurchaseItem(new ItemStack(Items.POISONOUS_POTATO), 0);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_CARROT), 650);
        registry.addPurchaseItem(new ItemStack(Items.PUMPKIN_PIE), 128);
        registry.addPurchaseItem(new ItemStack(Items.RABBIT), 24);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_RABBIT), 36);
        registry.addPurchaseItem(new ItemStack(Items.RABBIT_STEW), 188);
        registry.addPurchaseItem(new ItemStack(Items.MUTTON), 50);
        registry.addPurchaseItem(new ItemStack(Items.COOKED_MUTTON), 60);
        registry.addPurchaseItem(new ItemStack(Items.BEETROOT), 40);
        registry.addPurchaseItem(new ItemStack(Items.BEETROOT_SOUP), 30);

        //道具 素材の金属の1/10
        registry.addPurchaseItem(new ItemStack(Items.IRON_SHOVEL), 50);
        registry.addPurchaseItem(new ItemStack(Items.IRON_PICKAXE), 150);
        registry.addPurchaseItem(new ItemStack(Items.IRON_AXE), 150);
        registry.addPurchaseItem(new ItemStack(Items.FLINT_AND_STEEL), 50);
        registry.addPurchaseItem(new ItemStack(Items.WOODEN_SHOVEL), 1);
        registry.addPurchaseItem(new ItemStack(Items.WOODEN_PICKAXE), 1);
        registry.addPurchaseItem(new ItemStack(Items.WOODEN_AXE), 1);
        registry.addPurchaseItem(new ItemStack(Items.STONE_SHOVEL), 2);
        registry.addPurchaseItem(new ItemStack(Items.STONE_PICKAXE), 2);
        registry.addPurchaseItem(new ItemStack(Items.STONE_AXE), 2);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_SHOVEL), 1000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_PICKAXE), 3000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_AXE), 3000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_SHOVEL), 400);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_PICKAXE), 1200);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_AXE), 1200);
        registry.addPurchaseItem(new ItemStack(Items.WOODEN_HOE), 1);
        registry.addPurchaseItem(new ItemStack(Items.STONE_HOE), 2);
        registry.addPurchaseItem(new ItemStack(Items.IRON_HOE), 100);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_HOE), 2000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_HOE), 800);
        registry.addPurchaseItem(new ItemStack(Items.COMPASS), 2100);
        registry.addPurchaseItem(new ItemStack(Items.FISHING_ROD), 30);
        registry.addPurchaseItem(new ItemStack(Items.CLOCK), 15000);
        registry.addPurchaseItem(new ItemStack(Items.SHEARS), 500);
        registry.addPurchaseItem(new ItemStack(Items.LEAD), 30);
        registry.addPurchaseItem(new ItemStack(Items.NAME_TAG), 60);

        //戦闘
        registry.addPurchaseItem(new ItemStack(Items.BOW), 20);
        registry.addPurchaseItem(new ItemStack(Items.ARROW), 1);
        registry.addPurchaseItem(new ItemStack(Items.IRON_SWORD), 100);
        registry.addPurchaseItem(new ItemStack(Items.WOODEN_SWORD), 1);
        registry.addPurchaseItem(new ItemStack(Items.STONE_SWORD), 2);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_SWORD), 2000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_SWORD), 800);
        registry.addPurchaseItem(new ItemStack(Items.LEATHER_HELMET), 250);//革は素材の値段のまま
        registry.addPurchaseItem(new ItemStack(Items.LEATHER_CHESTPLATE), 400);
        registry.addPurchaseItem(new ItemStack(Items.LEATHER_LEGGINGS), 350);
        registry.addPurchaseItem(new ItemStack(Items.LEATHER_BOOTS), 200);
        registry.addPurchaseItem(new ItemStack(Items.CHAINMAIL_HELMET), -1);//MODで入手できるようにする場合は価格を設定する
        registry.addPurchaseItem(new ItemStack(Items.CHAINMAIL_CHESTPLATE), -1);
        registry.addPurchaseItem(new ItemStack(Items.CHAINMAIL_LEGGINGS), -1);
        registry.addPurchaseItem(new ItemStack(Items.CHAINMAIL_BOOTS), -1);
        registry.addPurchaseItem(new ItemStack(Items.IRON_HELMET), 250);
        registry.addPurchaseItem(new ItemStack(Items.IRON_CHESTPLATE), 400);
        registry.addPurchaseItem(new ItemStack(Items.IRON_LEGGINGS), 350);
        registry.addPurchaseItem(new ItemStack(Items.IRON_BOOTS), 200);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_HELMET), 5000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_CHESTPLATE), 8000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_LEGGINGS), 7000);
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND_BOOTS), 4000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_HELMET), 2000);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_CHESTPLATE), 6400);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_LEGGINGS), 5600);
        registry.addPurchaseItem(new ItemStack(Items.GOLDEN_BOOTS), 3200);
        registry.addPurchaseItem(new ItemStack(Items.ENCHANTED_BOOK), 30);
        registry.addPurchaseItem(new ItemStack(Items.SHIELD), 600);

        //ポーション BLOCK
        registry.addPurchaseItem(new ItemStack(Blocks.BREWING_STAND), -1);//ブロック状態のスタンド
        registry.addPurchaseItem(new ItemStack(Blocks.CAULDRON), -1);//ブロック状態の釜
        //ポーション ITEM
        registry.addPurchaseItem(new ItemStack(Items.GHAST_TEAR), 5);
        registry.addPurchaseItem(new ItemStack(Items.POTIONITEM), 1);//ポーションはまた今度
        registry.addPurchaseItem(new ItemStack(Items.GLASS_BOTTLE), 10);
        registry.addPurchaseItem(new ItemStack(Items.FERMENTED_SPIDER_EYE), 1);
        registry.addPurchaseItem(new ItemStack(Items.BLAZE_POWDER), 2);
        registry.addPurchaseItem(new ItemStack(Items.MAGMA_CREAM), 5);
        registry.addPurchaseItem(new ItemStack(Items.BREWING_STAND), 50);
        registry.addPurchaseItem(new ItemStack(Items.CAULDRON), 50);
        registry.addPurchaseItem(new ItemStack(Items.BREWING_STAND), 3500);
        registry.addPurchaseItem(new ItemStack(Items.SPECKLED_MELON), 650);
        registry.addPurchaseItem(new ItemStack(Items.RABBIT_FOOT), 320);

        //材料
        registry.addPurchaseItem(new ItemStack(Items.COAL, 1, 0), 50);
        registry.addPurchaseItem(new ItemStack(Items.COAL, 1, 1), 10);//木炭
        registry.addPurchaseItem(new ItemStack(Items.DIAMOND), 10000);
        registry.addPurchaseItem(new ItemStack(Items.IRON_INGOT), 500);
        registry.addPurchaseItem(new ItemStack(Items.GOLD_INGOT), 4000);
        registry.addPurchaseItem(new ItemStack(Items.STICK), 2);
        registry.addPurchaseItem(new ItemStack(Items.BOWL), 3);
        registry.addPurchaseItem(new ItemStack(Items.STRING), 4);
        registry.addPurchaseItem(new ItemStack(Items.FEATHER), 1);
        registry.addPurchaseItem(new ItemStack(Items.GUNPOWDER), 4);
        registry.addPurchaseItem(new ItemStack(Items.WHEAT_SEEDS), 1);
        registry.addPurchaseItem(new ItemStack(Items.WHEAT), 50);
        registry.addPurchaseItem(new ItemStack(Items.BREAD), 80);
        registry.addPurchaseItem(new ItemStack(Items.FLINT), 3);
        registry.addPurchaseItem(new ItemStack(Items.LEATHER), 50);
        registry.addPurchaseItem(new ItemStack(Items.BRICK), 50);
        registry.addPurchaseItem(new ItemStack(Items.CLAY_BALL), 30);
        registry.addPurchaseItem(new ItemStack(Items.REEDS), 10);
        registry.addPurchaseItem(new ItemStack(Items.EGG), 20);
        registry.addPurchaseItem(new ItemStack(Items.GLOWSTONE_DUST), 100);
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 0), 30);//染料 イカスミ
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 1), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 2), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 3), 40);//染料 カカオ
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 4), 220);//染料 ラピス
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 5), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 6), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 7), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 8), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 9), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 10), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 11), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 12), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 13), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 14), 5);//染料
        registry.addPurchaseItem(new ItemStack(Items.DYE, 1, 15), 10);//染料 骨粉
        registry.addPurchaseItem(new ItemStack(Items.SUGAR), 10);
        registry.addPurchaseItem(new ItemStack(Items.PUMPKIN_SEEDS), 2);
        registry.addPurchaseItem(new ItemStack(Items.MELON_SEEDS), 2);
        registry.addPurchaseItem(new ItemStack(Items.BLAZE_ROD), 10);
        registry.addPurchaseItem(new ItemStack(Items.GOLD_NUGGET), 440);
        registry.addPurchaseItem(new ItemStack(Items.NETHER_WART), 10);
        registry.addPurchaseItem(new ItemStack(Items.EMERALD), 300);
        registry.addPurchaseItem(new ItemStack(Items.NETHER_STAR), 8000);
        registry.addPurchaseItem(new ItemStack(Items.NETHERBRICK), 20);
        registry.addPurchaseItem(new ItemStack(Items.QUARTZ), 300);
        registry.addPurchaseItem(new ItemStack(Items.PRISMARINE_SHARD), 5);
        registry.addPurchaseItem(new ItemStack(Items.PRISMARINE_CRYSTALS), 20);
        registry.addPurchaseItem(new ItemStack(Items.RABBIT_HIDE), 10);
        registry.addPurchaseItem(new ItemStack(Items.CHORUS_FRUIT), 4);
        registry.addPurchaseItem(new ItemStack(Items.CHORUS_FRUIT_POPPED), 1);
        registry.addPurchaseItem(new ItemStack(Items.BEETROOT_SEEDS), 2);

    }

}
