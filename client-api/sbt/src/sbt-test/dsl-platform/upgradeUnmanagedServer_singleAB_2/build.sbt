import dslplatform.CompilerPlugin.DslKeys._

dslplatform.CompilerPlugin.dslSettings

username := "rinmalavi@gmail.com"

password := "qwe321"

dslProjectId := "6bff118e-0ad9-4aee-813d-b292df9b9291"

outputDirectory := Some(file("out"))

packageName := "namespace"

apiImpl := new com.dslplatform.compiler.client.ApiImpl(new com.dslplatform.compiler.client.api.core.impl.HttpRequestBuilderImpl(), new com.dslplatform.compiler.client.api.core.mock.HttpTransportMock(), com.dslplatform.compiler.client.api.core.mock.UnmanagedDSLMock.mock_single_integrated)

databaseConnection := Map("ServerName" -> "localhost", "Port" -> "5432", "DatabaseName" -> "dccTest", "User" -> "dccTest", "Password" -> "testingTest3")

TaskKey[Unit]("checkOut") := {
  val outputDir = outputDirectory.value.get
  val checkFile = outputDir / "scala" / "namespace" / "SystemConfiguration.scala"
  assert(checkFile.exists())
}
