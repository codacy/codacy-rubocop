package codacy

import codacy.dockerApi.DockerEngine
import codacy.rubocop.Rubocop

object Engine extends DockerEngine(Rubocop)
