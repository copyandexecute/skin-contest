package de.hglabor.skincontest.config

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag

object Config {
    var waitingLoc: Location = Location(Bukkit.getWorld("world"), 0.22, 88.00, 37.40, 540.36F, -1.74F)
    var nextLoc: Location = Location(Bukkit.getWorld("world"), -22.87, 88.00, -4.73, 359.72F, 1.51F)
    var eliminatedLoc: Location = Location(Bukkit.getWorld("world"), 29.53, 88.00, -1.18, 379.34F, -0.23F)
    var catwalkLoc: Location = Location(Bukkit.getWorld("world"), 2.54, 91.00, -11.58, 720.31F, 0.64F)
    const val nextRoundKey = "nextRound"
    const val eliminationKey = "eliminated"
    var isChat = true;
    val PREFIX = "${KColors.YELLOW}[SkinContest]"

    val nextRoundBow = itemStack(Material.BOW) {
        meta {
            name = "${KColors.GREEN}Next Round"
            isUnbreakable = true
            flag(ItemFlag.HIDE_UNBREAKABLE)
        }
    }
    val eliminationBow = itemStack(Material.BOW) {
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
    val chatToggleItem = itemStack(Material.MUSIC_DISC_11) {
        meta {
            name = "${KColors.GREEN}Toggle Chat"
        }
    }
}
