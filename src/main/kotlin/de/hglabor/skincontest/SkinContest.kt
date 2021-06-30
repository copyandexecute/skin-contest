package de.hglabor.skincontest

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.main.KSpigot
class SkinContest : KSpigot() {
    companion object {
        lateinit var INSTANCE: SkinContest; private set
    }

    override fun startup() {
        logger.info("${KColors.GREEN}The Plugin was successfully enabled!")
    }

    override fun shutdown() {
        logger.info("${KColors.RED}The Plugin was disabled!")
    }
}

val Manager by lazy { SkinContest.INSTANCE }
