package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.*;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaRedwoodTaigaHills;
import rtg.world.biome.deco.*;
import rtg.world.biome.deco.collection.DecoCollectionMegaTaiga;
import rtg.world.gen.surface.vanilla.SurfaceVanillaRedwoodTaigaHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaRedwoodTaigaHills;

public class RealisticBiomeVanillaRedwoodTaigaHills extends RealisticBiomeVanillaBase {

    public static Biome biome = Biomes.MUTATED_REDWOOD_TAIGA_HILLS;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeVanillaRedwoodTaigaHills(BiomeConfig config) {

        super(config, biome, river,
            new TerrainVanillaRedwoodTaigaHills(),
            new SurfaceVanillaRedwoodTaigaHills(config, Blocks.GRASS.getDefaultState(), Blocks.DIRT.getDefaultState(), 0.2f)
        );

        this.noLakes = true;

        DecoBoulder decoBoulder = new DecoBoulder();
        decoBoulder.boulderBlock = Blocks.MOSSY_COBBLESTONE.getDefaultState();
        decoBoulder.chance = 16;
        decoBoulder.maxY = 95;
        decoBoulder.strengthFactor = 3f;
        this.addDeco(decoBoulder);

        this.addDecoCollection(new DecoCollectionMegaTaiga());

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.distribution.noiseDivisor = 100f;
        decoFallenTree.distribution.noiseFactor = 6f;
        decoFallenTree.distribution.noiseAddend = 0.8f;
        decoFallenTree.logCondition = DecoFallenTree.LogCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
        decoFallenTree.logConditionNoise = 0f;
        decoFallenTree.logConditionChance = 6;
        decoFallenTree.logBlock = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        decoFallenTree.leavesBlock = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE);
        decoFallenTree.minSize = 3;
        decoFallenTree.maxSize = 6;
        this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigVanillaRedwoodTaigaHills.decorationLogsId));

        DecoShrub decoShrub = new DecoShrub();
        decoShrub.maxY = 100;
        decoShrub.strengthFactor = 2f;
        decoShrub.chance = 10;
        this.addDeco(decoShrub);

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        decoBaseBiomeDecorations.equalsZeroChance = 3;
        this.addDeco(decoBaseBiomeDecorations);

        DecoMushrooms decoMushrooms = new DecoMushrooms();
        decoMushrooms.maxY = 90;
        decoMushrooms.randomType = rtg.world.biome.deco.DecoMushrooms.RandomType.X_DIVIDED_BY_STRENGTH;
        decoMushrooms.randomFloat = 3f;
        this.addDeco(decoMushrooms);

        DecoPumpkin decoPumpkin = new DecoPumpkin();
        decoPumpkin.maxY = 90;
        decoPumpkin.randomType = rtg.world.biome.deco.DecoPumpkin.RandomType.X_DIVIDED_BY_STRENGTH;
        decoPumpkin.randomFloat = 20f;
        this.addDeco(decoPumpkin);

        DecoGrass decoGrass = new DecoGrass();
        decoGrass.maxY = 128;
        decoGrass.strengthFactor = 10f;
        this.addDeco(decoGrass);
    }
}
