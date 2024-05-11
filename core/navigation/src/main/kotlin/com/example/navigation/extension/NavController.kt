package com.example.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph

fun NavController.navigateSafe(directions: NavDirections) {
    // Get action by ID. If action doesn't exist on current node, return.
    val action = (currentDestination ?: graph).getAction(directions.actionId) ?: return
    var destId = action.destinationId
    val dest = graph.findNode(destId)
    if (dest is NavGraph) {
        // Action destination is a nested graph, which isn't a real destination.
        // The real destination is the start destination of that graph so resolve it.
        destId = dest.startDestinationId
    }
    if (currentDestination?.id != destId) {
        navigate(directions)
    }
}