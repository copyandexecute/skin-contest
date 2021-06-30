package de.hglabor.skincontest.listener

import de.hglabor.skincontest.config.Config
import io.papermc.paper.event.player.AsyncChatEvent
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.feedSaturate
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.FoodLevelChangeEvent

object GlobalListener {
    init {
        listen<EntityDamageByEntityEvent> {
            if (it.damager is Player && (it.damager as Player).gameMode == GameMode.ADVENTURE) {
                it.isCancelled = true;
            }
        }
        listen<FoodLevelChangeEvent> {
            (it.entity as Player).feedSaturate()
        }
        listen<AsyncChatEvent> {
            if (!Config.isChat) {
                if (it.player.gameMode === GameMode.ADVENTURE) {
                    it.player.sendMessage("${KColors.RED}Chat ist aus! Ruhe bitte :D")
                    it.isCancelled = true;
                }
            }
        }
    }
}
