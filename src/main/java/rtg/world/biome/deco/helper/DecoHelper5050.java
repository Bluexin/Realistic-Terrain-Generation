package rtg.world.biome.deco.helper;

import java.util.Random;

import rtg.api.world.RTGWorld;
import rtg.world.biome.deco.DecoBase;
import rtg.world.biome.realistic.RealisticBiomeBase;

/**
 * This deco helper takes two deco objects and generates one of them at random.
 *
 * @author WhichOnesPink
 */
public class DecoHelper5050 extends DecoBase {

    private DecoBase deco1;
    private DecoBase deco2;

    public DecoHelper5050(DecoBase deco1, DecoBase deco2) {

        super();

        if (deco1 instanceof DecoHelper5050 || deco2 instanceof DecoHelper5050) {
            throw new RuntimeException("DecoHelper5050 cannot accept itself as a parameter.");
        }

        this.deco1 = deco1;
        this.deco2 = deco2;
    }

    @Override
    public void generate(RealisticBiomeBase biome, RTGWorld rtgWorld, Random rand, int chunkX, int chunkY, float strength, float river, boolean hasPlacedVillageBlocks) {

        if (this.allowed) {

            if (rand.nextBoolean()) {
                this.deco1.generate(biome, rtgWorld, rand, chunkX, chunkY, strength, river, hasPlacedVillageBlocks);
            }
            else {
                this.deco2.generate(biome, rtgWorld, rand, chunkX, chunkY, strength, river, hasPlacedVillageBlocks);
            }
        }
    }
}
