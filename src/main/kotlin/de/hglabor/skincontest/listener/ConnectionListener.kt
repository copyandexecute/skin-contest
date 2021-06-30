package de.hglabor.skincontest.listener

import de.hglabor.skincontest.config.Config
import de.hglabor.skincontest.extension.PlayerExtensions
import de.hglabor.skincontest.extension.PlayerExtensions.getStatus
import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object ConnectionListener {
    init {
        listen<PlayerJoinEvent> {
            it.joinMessage(null)
            it.player.gameMode = GameMode.ADVENTURE
            when (it.player.getStatus()) {
                PlayerExtensions.Status.NEXT -> it.player.teleport(Config.nextLoc)
                PlayerExtensions.Status.ELIMINATED -> it.player.teleport(Config.eliminatedLoc)
                PlayerExtensions.Status.WAITING -> it.player.teleport(Config.waitingLoc)
                PlayerExtensions.Status.CATWALK -> it.player.teleport(Config.catwalkLoc)
            }
        }
        listen<PlayerQuitEvent> {
            it.quitMessage(null)
        }
    }
}
