package de.hglabor.skincontest.listener

import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent

object DamageListener {
    init {
        listen<EntityDamageByEntityEvent> {
            if (it.damager is Player && (it.damager as Player).gameMode == GameMode.ADVENTURE) {
                it.isCancelled = true;
            }
        }
    }
}
