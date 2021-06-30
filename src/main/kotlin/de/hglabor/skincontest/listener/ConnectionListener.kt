package de.hglabor.skincontest.listener

import de.hglabor.skincontest.Manager
import de.hglabor.skincontest.config.Config
import de.hglabor.skincontest.extension.PlayerExtensions.isAlive
import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerJoinEvent

object ConnectionListener {
    init {
        listen<PlayerJoinEvent> {
            it.player.gameMode = GameMode.ADVENTURE

            if (!Manager.hasStarted) {
                it.player.teleport(Config.waitingLoc)
            } else {
                if (it.player.isAlive()) {
                    it.player.teleport(Config.nextLoc)
                } else {
                    it.player.teleport(Config.eliminatedLoc)
                }
            }
        }
    }
}
