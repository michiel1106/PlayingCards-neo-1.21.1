package com.ombremoon.playingcards.entity.data;


import com.mojang.serialization.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.core.registries.*;
import net.minecraft.network.codec.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.*;

import java.util.*;

public class CardComponents {

    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(
            Registries.DATA_COMPONENT_TYPE,
            "playingcards"
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> CARD_SKIN = REGISTRAR.registerComponentType(
            "card_skin",
            builder -> builder
                    .persistent(Codec.BYTE)
                    .networkSynchronized(ByteBufCodecs.BYTE)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> CARD_COVERED = REGISTRAR.registerComponentType(
            "card_covered",
            builder -> builder
                    .persistent(Codec.BOOL)
                    .networkSynchronized(ByteBufCodecs.BOOL)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> CARD_DECK_UUID = REGISTRAR.registerComponentType(
            "card_deck_uuid",
            builder -> builder
                    .persistent(UUIDUtil.CODEC)
                    .networkSynchronized(UUIDUtil.STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> OWNER_NAME = REGISTRAR.registerComponentType(
            "card_owner_name",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );


    /**
     * Helper methods for ItemStacks
     */
    public static byte getSkin(ItemStack stack) {
        return stack.getOrDefault(CARD_SKIN.value(), (byte) 0);
    }

    public static void setSkin(ItemStack stack, byte skinID) {
        stack.set(CARD_SKIN.value(), skinID);
    }


    public static String getOwnerName(ItemStack stack) {
        return stack.getOrDefault(OWNER_NAME.value(), "empty");
    }

    public static void setOwnerName(ItemStack stack, String ownerName) {
        stack.set(OWNER_NAME.value(), ownerName);
    }

    public static boolean isCovered(ItemStack stack) {
        return stack.getOrDefault(CARD_COVERED.value(), true);
    }

    public static void setCovered(ItemStack stack, boolean covered) {
        stack.set(CARD_COVERED.value(), covered);
    }

    public static UUID getDeckUUID(ItemStack stack) {
        return stack.getOrDefault(CARD_DECK_UUID.value(), UUID.randomUUID());
    }

    public static void setDeckUUID(ItemStack stack, UUID deckUUID) {
        stack.set(CARD_DECK_UUID.value(), deckUUID);
    }
}
