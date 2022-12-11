package com.github.phgeorgiev

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class InitDayTask extends DefaultTask {

    @Input
    abstract Property<String> getDay()

    @Input
    abstract Property<String> getSession()

    @TaskAction
    def execute() {
        def puzzleInput = project.file('src/test/resources/day%02d/input.txt'.formatted(day.get() as Integer))
        puzzleInput.parentFile.mkdirs()
        puzzleInput.write(downloadPuzzleInput())

        project
                .file('src/test/java/com/github/phgeorgiev/day%02d/'.formatted(day.get() as Integer))
                .mkdirs()

        project
                .file('src/main/java/com/github/phgeorgiev/day%02d/'.formatted(day.get() as Integer))
                .mkdirs()
    }

    String downloadPuzzleInput() {
        def get = new URL('https://adventofcode.com/2022/day/%s/input'.formatted(day.get())).openConnection()
        get.addRequestProperty('Cookie', 'session=' + session.get())
        get.with {
            it.doOutput = true
            it.requestMethod = 'GET'
            return content.text
        }
    }
}
