package net.reconhalcyon.hawaiinei.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class FishingSpearItem extends Item {
    public FishingSpearItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!world.isClientSide && !player.getCooldowns().isOnCooldown(this)) {
            BlockHitResult blockHit = Item.getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY);
            BlockPos pos = blockHit.getBlockPos();

                if (world.getBlockState(pos).getFluidState().is(FluidTags.WATER)) {

                    // Catch the beef
                    ItemStack beef = new ItemStack(Items.BEEF);
                    if (!player.getInventory().add(beef)) {
                        player.drop(beef, false);
                    }

                    if (world instanceof ServerLevel serverLevel) {
                        itemStack.hurtAndBreak(15, serverLevel, player,
                                (brokenItem) -> player.onEquippedItemBroken(brokenItem,
                                        hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND));
                    }

                    player.getCooldowns().addCooldown(this, 100);

                    world.playSound(null, pos, SoundEvents.FISHING_BOBBER_SPLASH, SoundSource.PLAYERS, 1.0F, 1.2F);
                }
            }

        return InteractionResultHolder.success(itemStack);
    }
}
