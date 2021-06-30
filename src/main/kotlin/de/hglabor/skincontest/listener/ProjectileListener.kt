package de.hglabor.skincontest.listener

import de.hglabor.skincontest.Manager
import de.hglabor.skincontest.config.Config
import de.hglabor.skincontest.extension.PlayerExtensions
import de.hglabor.skincontest.extension.PlayerExtensions.setStatus
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import org.bukkit.entity.Player
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.metadata.FixedMetadataValue

object ProjectileListener {
    init {
        listen<ProjectileLaunchEvent> {
            val shooter = it.entity.shooter
            if (shooter is Player) {
                when {
                    shooter.inventory.itemInMainHand.isSimilar(Config.nextRoundBow) -> {
                        it.entity.setMetadata(Config.nextRoundKey, FixedMetadataValue(Manager, null))
                    }
                    shooter.inventory.itemInMainHand.isSimilar(Config.eliminationBow) -> {
                        it.entity.setMetadata(Config.eliminationKey, FixedMetadataValue(Manager, null))
                    }
                }
            }
        }
        listen<ProjectileHitEvent> {
            if (it.hitEntity != null && it.hitEntity is Player) {
                val player = it.hitEntity as Player
                when {
                    it.entity.hasMetadata(Config.nextRoundKey) -> {
                        player.setStatus(PlayerExtensions.Status.NEXT)
                        player.teleport(Config.nextLoc)
                        broadcast("${Config.PREFIX} ${KColors.BLUE} ${player.name} ${KColors.GREEN}ist in der nächsten Runde :3!")
                        it.isCancelled = true
                    }
                    it.entity.hasMetadata(Config.eliminationKey) -> {
                        player.setStatus(PlayerExtensions.Status.ELIMINATED)
                        broadcast("${Config.PREFIX} ${KColors.BLUE} ${player.name} ${KColors.RED}ist ausgeschieden :/!")
                        player.teleport(Config.eliminatedLoc)
                        it.isCancelled = true
                    }
                }
            }
        }
    }
}
