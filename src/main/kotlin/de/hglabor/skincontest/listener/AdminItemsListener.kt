package de.hglabor.skincontest.listener

import de.hglabor.skincontest.config.Config
import de.hglabor.skincontest.config.Config.PREFIX
import de.hglabor.skincontest.extension.PlayerExtensions
import de.hglabor.skincontest.extension.PlayerExtensions.getStatus
import de.hglabor.skincontest.extension.PlayerExtensions.setStatus
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerInteractEvent

object AdminItemsListener {
    init {
        listen<PlayerInteractEvent> { event ->
            if (event.item == null) {
                return@listen
            }
            val item = event.item!!
            when {
                item.isSimilar(Config.teleportWaitingPlayers) -> {
                    onlinePlayers
                        .asSequence()
                        .filter { it.gameMode === GameMode.ADVENTURE }
                        .filter { it.getStatus() === PlayerExtensions.Status.WAITING }
                        .take(5)
                        .forEach {
                            broadcast("$PREFIX${KColors.BLUE} ${it.name} ${KColors.GREEN}wurde teleportiert!")
                            it.teleport(Config.catwalkLoc)
                            it.setStatus(PlayerExtensions.Status.CATWALK)
                        }
                }
                item.isSimilar(Config.teleportNextPlayers) -> {
                    onlinePlayers
                        .filter { it.gameMode === GameMode.ADVENTURE }
                        .filter { it.getStatus() === PlayerExtensions.Status.NEXT }
                        .forEach {
                            it.teleport(Config.waitingLoc)
                            it.setStatus(PlayerExtensions.Status.WAITING)
                        }
                }
                item.isSimilar(Config.chatToggleItem) -> {
                    Config.isChat = !Config.isChat
                    when {
                        Config.isChat -> broadcast("${KColors.GREEN}Chat wurde angeschaltet ihr ;) Mäuse :3")
                        else -> broadcast("${KColors.RED}Chat wurde ausgeschaltet ihr frechen ;) Mäuse :3")
                    }
                }
            }
        }
    }
}
