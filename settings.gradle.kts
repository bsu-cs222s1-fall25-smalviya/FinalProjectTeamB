rootProject.name = "FinalProjectTeamB"
include("main")
include("project-without-directory")
project(":project-without-directory").projectDir.mkdirs()
