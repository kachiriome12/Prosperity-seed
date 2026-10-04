package com.prosperityseed;

import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTextures;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Plugin carregado pelo Mystical Agriculture (ele procura a anotação
 * @MysticalAgriculturePlugin). A classe precisa ser public e ter construtor sem argumentos.
 */
@MysticalAgriculturePlugin
public class ProsperityOrePlugin implements IMysticalAgriculturePlugin {

    private static final ResourceLocation PROSPERITY_ORE =
            new ResourceLocation("mysticalagriculture", "prosperity_ore");

    private static final int COLOR = 0x5CE0C8;

    public ProsperityOrePlugin() {
    }

    @Override
    public void onRegisterCrops(ICropRegistry registry) {
        // Tier 1 = cresce em fazenda de Inferium. Troque por CropTier.TWO, THREE... para exigir fazenda melhor.
        var crop = new Crop(
                new ResourceLocation(ProsperitySeedMod.MOD_ID, "prosperity_ore"),
                CropTier.ONE,
                CropType.RESOURCE,
                new CropTextures(CropTextures.FLOWER_ROCK_BLANK, CropTextures.ESSENCE_ROCK_BLANK),
                LazyIngredient.item("mysticalagriculture:prosperity_shard")
        );

        // Cor só da flor e da semente. A cor da essência fica de fora de propósito:
        // o "drop" aqui é o bloco de minério de verdade e ele não pode ser pintado.
        crop.setFlowerColor(COLOR);
        crop.setSeedColor(COLOR);

        // O que a plantação dropa na colheita: o minério (e não uma essência).
        // "false" = não registrar um item novo, usar o item que já existe.
        crop.setEssenceItem(() -> ForgeRegistries.ITEMS.getValue(PROSPERITY_ORE), false);

        // Receitas automáticas desligadas: a reprocessadora devolveria minério
        // (duplicação infinita) e a receita da semente é a do arquivo JSON do mod.
        crop.getRecipeConfig().setSeedCraftingRecipeEnabled(false);
        crop.getRecipeConfig().setSeedInfusionRecipeEnabled(false);
        crop.getRecipeConfig().setSeedReprocessorRecipeEnabled(false);

        registry.register(crop);
    }
}
