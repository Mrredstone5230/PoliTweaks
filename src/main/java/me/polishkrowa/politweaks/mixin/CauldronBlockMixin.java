package me.polishkrowa.politweaks.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CauldronBlock.class)
public class CauldronBlockMixin {

    @Inject(method = "canFillWithPrecipitation", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextFloat()F",ordinal = 1), cancellable = true)
    private static void injected(World world, Biome.Precipitation precipitation, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

}
