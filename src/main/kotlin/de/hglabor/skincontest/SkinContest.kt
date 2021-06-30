package de.hglabor.skincontest

import de.hglabor.skincontest.command.LocationCommand
import de.hglabor.skincontest.listener.ConnectionListener
import de.hglabor.skincontest.listener.DamageListener
import dev.jorel.commandapi.CommandAPI
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.main.KSpigot
class SkinContest : KSpigot() {
    var hasStarted: Boolean = false;

    companion object {
        lateinit var INSTANCE: SkinContest; private set
    }

    override fun startup() {
        CommandAPI.onEnable(this)

        LocationCommand

        ConnectionListener
        DamageListener

        logger.info("${KColors.GREEN}The Plugin was successfully enabled!")
    }

    override fun load() {
        INSTANCE = this
        CommandAPI.onLoad(true)
    }

    override fun shutdown() {
        logger.info("${KColors.RED}The Plugin was disabled!")
    }
}

val Manager by lazy { SkinContest.INSTANCE }
