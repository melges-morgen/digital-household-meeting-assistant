package org.dhma

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.dhma.service.HealthCheckService
import org.dhma.web.route.healthCheck
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

fun main(args: Array<String>): Unit {
    val kodein = DI {
        bind { singleton { HealthCheckService() } }
    }

    val healthCheckService by kodein.instance<HealthCheckService>()

    embeddedServer(Netty, port = 8080) {
        install(DefaultHeaders)
        install(CallLogging)

        routing {
            healthCheck(healthCheckService)
        }
    }.start(wait = true)
}
