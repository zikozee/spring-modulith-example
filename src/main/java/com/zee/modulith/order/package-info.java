@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {"inventory::exposed", "eventaction::action", "exception"}
)
package com.zee.modulith.order;