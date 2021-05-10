package org.dhma.web.route

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.dhma.service.HealthCheckService

fun Route.healthCheck(healthCheck: HealthCheckService) {
    get("/health-check") {
        call.respondText(healthCheck.check())
    }
}
