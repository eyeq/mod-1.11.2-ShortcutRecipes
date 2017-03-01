package eyeq.shortcutrecipes;

import eyeq.util.item.crafting.UCraftingManager;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static eyeq.shortcutrecipes.ShortcutRecipes.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class ShortcutRecipes {
    public static final String MOD_ID = "eyeq_shortcutrecipes";

    @Mod.Instance(MOD_ID)
    public static ShortcutRecipes instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addRecipes();
    }

    public static void addRecipes() {
        // plank
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.LADDER, 6), "X X", "XXX", "X X",
                'X', "plankWood"));
        // log
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.STICK, 16), "X", "X",
                'X', "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.CRAFTING_TABLE, 4), "XX", "XX",
                'X', "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.CHEST, 4), "XXX", "X X", "XXX",
                'X', "logWood"));
        for(int i = 0; i < BlockPlanks.EnumType.values().length; ++i) {
            GameRegistry.addRecipe(new ItemStack(Blocks.WOODEN_SLAB, 24, i), "XXX",
                    'X', i < 4 ? new ItemStack(Blocks.LOG, 1, i) : new ItemStack(Blocks.LOG2, 1, i - 4));
        }
        GameRegistry.addRecipe(new ItemStack(Blocks.OAK_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG));
        GameRegistry.addRecipe(new ItemStack(Blocks.SPRUCE_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Blocks.BIRCH_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG, 1, 2));
        GameRegistry.addRecipe(new ItemStack(Blocks.JUNGLE_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Blocks.ACACIA_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG2));
        GameRegistry.addRecipe(new ItemStack(Blocks.DARK_OAK_STAIRS, 16), "X  ", "XX ", "XXX",
                'X', new ItemStack(Blocks.LOG2, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG));
        GameRegistry.addRecipe(new ItemStack(Items.SPRUCE_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Items.BIRCH_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG, 1, 2));
        GameRegistry.addRecipe(new ItemStack(Items.JUNGLE_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Items.ACACIA_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG2));
        GameRegistry.addRecipe(new ItemStack(Items.DARK_OAK_DOOR, 12), "XX", "XX", "XX",
                'X', new ItemStack(Blocks.LOG2, 1, 1));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.TRAPDOOR, 8), "XXX", "XXX",
                'X', "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 4), "XX",
                'X', "logWood"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4), "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BOWL, 16), "X X", " X ",
                'X', "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.LADDER, 24), "X X", "XXX", "X X",
                'X', "logWood"));
        // potion
        ItemStack waterBottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
        GameRegistry.addRecipe(UCraftingManager.getRecipeBottle(waterBottle, Items.WATER_BUCKET));
        waterBottle = waterBottle.copy();
        waterBottle.setCount(2);
        GameRegistry.addRecipe(UCraftingManager.getRecipeBottle(waterBottle, Items.WATER_BUCKET));
        waterBottle = waterBottle.copy();
        waterBottle.setCount(3);
        GameRegistry.addRecipe(UCraftingManager.getRecipeBottle(waterBottle, Items.WATER_BUCKET));
        // extra
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.REDSTONE_LAMP),
                Items.REDSTONE, Items.REDSTONE, Items.REDSTONE, Items.REDSTONE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.BOOK), Items.LEATHER, Items.REEDS, Items.REEDS, Items.REEDS);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GRASS, 2), Blocks.GRASS, Blocks.DIRT);
    }
}
