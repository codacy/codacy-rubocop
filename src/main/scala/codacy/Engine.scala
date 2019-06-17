package codacy

import codacy.rubocop.Rubocop
import com.codacy.tools.scala.seed.DockerEngine

object Engine extends DockerEngine(Rubocop)()
