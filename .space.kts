
@file:kotlin.script.experimental.dependencies.DependsOn("com.squareup.okhttp:okhttp:2.7.4")

import com.squareup.okhttp.*

container(image = "amazoncorretto:17-alpine") {
    kotlinScript {
        val client = OkHttpClient()
        val request = Request.Builder().url("http://example.com").build()
        val response = client.newCall(request).execute()
        println(response)
    }
}
}

//job("Shell script") {
//    container(displayName = "Say Hello", image = "ubuntu") {
//        shellScript {
//            content = """
//                echo Hello
//                echo World!
//            """
//        }
//    }
//}
//job("Kotlin") {
//    container(image = "openjdk:11") {
//        kotlinScript { api ->
//            if (api.gitBranch() == "refs/heads/master"){
//                println("Running in master branch")
//            }
//            else {
//                println("Running in custom branch")
//            }
//        }
//    }
//}
//
//job("Run me on git push and at 8 AM UTC") {
//    container("hello-world")
//
//    startOn {
//        gitPush { enabled = true }
//        schedule { cron("0 8 * * *") }
//    }
//}
//
//job("Fail after 1 min") {
//    container(image = "hello-world")
//
//    failOn {
//        testFailed {  enabled = false  }
//        nonZeroExitCode { enabled = false }
//        outOfMemory { enabled = false }
//        timeOut {
//            timeOutInMinutes = 1
//        }
//    }
//}
//
//job("Share files") {
//    container(displayName = "Create file", image = "ubuntu") {
//        shellScript {
//            content = "touch /mnt/space/share/file.txt"
//        }
//    }
//
//    container(displayName = "Show file", image = "ubuntu") {
//        shellScript {
//            content = "ls -la /mnt/space/share"
//        }
//    }
//}
//
//job("Build and run tests") {
//   gradlew("openjdk:11", "build")
//}
