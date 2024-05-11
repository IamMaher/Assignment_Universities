

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import kotlin.jvm.optionals.getOrNull

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal val VersionCatalog.plugins: List<String>
    get() = pluginAliases

internal fun VersionCatalog.versionStr(alias: String): String =
    this.findVersion(alias).getOrNull()?.toString() ?: ""

internal fun VersionCatalog.versionInt(alias: String): Int =
    versionStr(alias).toInt()

internal fun VersionCatalog.library(alias: String) =
    findLibrary(alias).get()

internal fun VersionCatalog.bundle(alias: String) =
    findBundle(alias).get()

