package de.hglabor.skincontest.extension

import org.bukkit.entity.Player
import java.util.*

object PlayerExtensions {
    private val playerInfo = mutableMapOf<UUID, Status>()

    fun Player.getStatus(): Status = playerInfo.getOrDefault(this.uniqueId, Status.WAITING)

    fun Player.setStatus(value: Status) {
        playerInfo[this.uniqueId] = value
    }

    enum class Status {
        WAITING, NEXT, ELIMINATED, CATWALK
    }
}
