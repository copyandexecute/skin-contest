package de.hglabor.skincontest.command

import de.hglabor.skincontest.config.Config
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.GreedyStringArgument
import dev.jorel.commandapi.executors.PlayerCommandExecutor
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.extensions.geometry.toSimple

object LocationCommand {
    init {
        CommandAPICommand("skinlocations")
            .withArguments(GreedyStringArgument("which").overrideSuggestions(
                "waiting",
                "catwalk",
                "next",
                "eliminated"))
            .withPermission("hglabor.admin")
            .executesPlayer(PlayerCommandExecutor { player, objects ->
                val locationType = objects[0] as String
                when (locationType.lowercase()) {
                    "waiting" -> Config.waitingLoc = player.location
                    "next" -> Config.nextLoc = player.location
                    "eliminated" -> Config.eliminatedLoc = player.location
                    "catwalk" -> Config.catwalkLoc = player.location
                }
                player.sendMessage("${KColors.GREEN}Die Location $locationType wurde auf ${player.location.toSimple()} gesetzt")
            })
            .register()
    }
}
