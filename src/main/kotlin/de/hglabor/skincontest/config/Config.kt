package de.hglabor.skincontest.config

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag

object Config {
    lateinit var waitingLoc: Location
    lateinit var nextLoc: Location
    lateinit var eliminatedLoc: Location
    lateinit var catwalkLoc: Location
    const val nextRoundKey = "nextRound"
    const val eliminationKey = "eliminated"
    val PREFIX = "${KColors.YELLOW}[SkinContest]"

    val nextRoundBow = itemStack(Material.BOW) {
        addEnchantment(Enchantment.ARROW_DAMAGE, 5)
        meta {
            name = "${KColors.GREEN}Next Round"
            isUnbreakable = true
            flag(ItemFlag.HIDE_UNBREAKABLE)
        }
    }
    val eliminationBow = itemStack(Material.BOW) {
        addEnchantment(Enchantment.ARROW_DAMAGE, 5)
        meta {
            name = "${KColors.RED}Eliminate"
            isUnbreakable = true
            flag(ItemFlag.HIDE_UNBREAKABLE)
        }
    }
    val teleportWaitingPlayers = itemStack(Material.GREEN_CONCRETE) {
        meta {
            name = "${KColors.GREEN}Teleport waiting players"
        }
    }
    val teleportNextPlayers = itemStack(Material.YELLOW_CONCRETE) {
        meta {
            name = "${KColors.GREEN}Teleport next players to waiting room"
        }
    }
}
