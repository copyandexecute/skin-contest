package de.hglabor.skincontest.command

import de.hglabor.skincontest.config.Config
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.PlayerCommandExecutor

object SkinContestCommand {
    init {
        CommandAPICommand("skincontest")
            .withPermission("hglabor.admin")
            .executesPlayer(PlayerCommandExecutor { player, _ ->
                player.inventory.addItem(
                    Config.nextRoundBow,
                    Config.eliminationBow,
                    Config.teleportWaitingPlayers,
                    Config.teleportNextPlayers,
                    Config.chatToggleItem
                )
            })
            .register()
    }
}
