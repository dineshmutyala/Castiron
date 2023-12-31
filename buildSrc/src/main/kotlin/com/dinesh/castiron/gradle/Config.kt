package com.dinesh.castiron.gradle

import org.gradle.accessors.dm.LibrariesForLibs

object Config {
    private const val ROOT_NAMESPACE = "com.dinesh"

    object Modules {
        const val APP = ":castiron-app"

        object Ui {
            const val COMPONENTS = ":castiron-ui-components"
            const val THEME = ":castiron-ui-theme"
        }

        fun getNamespace(
            module: String,
            libs: LibrariesForLibs
        ): String {
            return if (module == APP || ":$module" == APP) libs.versions.application.id.get()
            else "$ROOT_NAMESPACE.${module.replace("-", ".")}"
        }
    }
}