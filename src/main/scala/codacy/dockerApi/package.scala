package codacy

import java.nio.file.Path
import play.api.libs.json._
import scala.util.Try

package dockerApi {
  abstract class Formats[W <: AnyVal{ val value:B }, B](apply_ : (B => W)) extends (B => W){ self =>
    implicit def writes(implicit writes: Writes[B]):Writes[W] = Writes(
      (_:W).value match{ case value: B@unchecked => writes.writes(value) }
    )

    implicit def reads(implicit reads: Reads[B]): Reads[W] = reads.map { self.apply }

    override def apply(v1: B): W = apply_(v1)
  }

  trait Tool{def apply(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[Iterable[Result]] }

  final class PatternId     (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class SourcePath    (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class ResultMessage (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class ResultLine    (val value:Int    ) extends AnyVal{ override def toString = value.toString }
  final class ResultColumn  (val value:Int    ) extends AnyVal{ override def toString = value.toString }
  final class ResultLength  (val value:Int    ) extends AnyVal{ override def toString = value.toString }
  final class ToolName      (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class ParameterName (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class Version       (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class RubyEngine    (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class RubyVersion   (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class RubyPatchLevel(val value:String ) extends AnyVal{ override def toString = value.toString }
  final class RubyPlatform  (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class Severity      (val value:String ) extends AnyVal{ override def toString = value.toString }
  final class Corrected     (val value:Boolean) extends AnyVal{ override def toString = value.toString }
  final class OffenseCount  (val value:Int    ) extends AnyVal{ override def toString = value.toString }
  final class TrgtFileCount (val value:Int    ) extends AnyVal{ override def toString = value.toString }
  final class InspFileCount (val value:Int    ) extends AnyVal{ override def toString = value.toString }

  object PatternId      extends Formats[PatternId     , String ]( new PatternId(_)     )
  object SourcePath     extends Formats[SourcePath    , String ]( new SourcePath(_)    )
  object ResultMessage  extends Formats[ResultMessage , String ]( new ResultMessage(_) )
  object ResultLine     extends Formats[ResultLine    , Int    ]( new ResultLine(_)    )
  object ToolName       extends Formats[ToolName      , String ]( new ToolName(_)      )
  object ParameterName  extends Formats[ParameterName , String ]( new ParameterName(_) )
  object ResultColumn   extends Formats[ResultColumn  , Int    ]( new ResultColumn(_)  )
  object ResultLength   extends Formats[ResultLength  , Int    ]( new ResultLength(_)  )
  object Version        extends Formats[Version       , String ]( new Version(_)       )
  object RubyEngine     extends Formats[RubyEngine    , String ]( new RubyEngine(_)    )
  object RubyVersion    extends Formats[RubyVersion   , String ]( new RubyVersion(_)   )
  object RubyPatchLevel extends Formats[RubyPatchLevel, String ]( new RubyPatchLevel(_))
  object RubyPlatform   extends Formats[RubyPlatform  , String ]( new RubyPlatform(_)  )
  object Severity       extends Formats[Severity      , String ]( new Severity(_)      )
  object Corrected      extends Formats[Corrected     , Boolean]( new Corrected(_)     )
  object OffenseCount   extends Formats[OffenseCount  , Int    ]( new OffenseCount(_)  )
  object TrgtFileCount  extends Formats[TrgtFileCount , Int    ]( new TrgtFileCount(_) )
  object InspFileCount  extends Formats[InspFileCount , Int    ]( new InspFileCount(_) )

  case class ParameterDef(name:ParameterName,value:JsValue)
  case class PatternDef(patternId: PatternId, parameters:Option[Set[ParameterDef]])
  case class ToolConfig(name:ToolName, patterns:Seq[PatternDef])
  private[dockerApi] case class FullConfig(tools:Set[ToolConfig],files:Option[Set[SourcePath]])

  case class RubocopLocation(line:ResultLine, column:ResultColumn, length:ResultLength)
  case class RubocopMetadata(rubocopVersion:Version, rubyEngine:RubyEngine, rubyVersion:RubyVersion, rubyPatchLevel:RubyPatchLevel, rubyPlatform:RubyPlatform)
  case class RubocopOffenses(severity:Severity, message:ResultMessage, copName:PatternId, corrected:Corrected, location:RubocopLocation)
  case class RubocopFiles(path:SourcePath, offenses:Option[Seq[RubocopOffenses]])
  case class RubocopSummary(offenseCount:OffenseCount, targetFileCount:TrgtFileCount, inspectedFileCount:InspFileCount)
  case class RubocopResult(metadata:RubocopMetadata, files:Option[Seq[RubocopFiles]], summary:RubocopSummary)

  //there are other fields like name and description but i don't care about them inside the tool
  case class ParameterSpec(name:ParameterName, default:JsValue)
  case class PatternSpec(patternId: PatternId, parameters:Option[Set[ParameterSpec]])
  case class Spec(name:ToolName,patterns:Set[PatternSpec])

  case class Result(filename:SourcePath,message:ResultMessage,patternId:PatternId,line: ResultLine)
}

package object dockerApi {
  private[this] def asReader[A](jsResult: JsResult[A]): Reads[A] = Reads[A]((_:JsValue) => jsResult)
  implicit def toValue[A] = (a: AnyVal{ def value:A }) => a.value

  implicit lazy val specReader: Reads[Spec] = {
    implicit val r1 = Json.reads[ParameterSpec]
    implicit val r0 = Json.reads[PatternSpec]
    Json.reads[Spec]
  }

  implicit def configReader(implicit spec:Spec): Reads[FullConfig] = {
    implicit val r1 = Json.reads[ParameterDef]
    implicit val r0 = Json.reads[PatternDef].flatMap { case pattern =>

        val filtered =
          if (spec.patterns.exists(_.patternId == pattern.patternId)) JsSuccess(pattern)
          else JsError(s"invalid patternId: ${pattern.patternId}")

        asReader(filtered)
    }

    implicit val r2 = Reads.set(Json.reads[ToolConfig])

    Json.reads[FullConfig].flatMap{ case fullCfg =>
      val ps = fullCfg.tools.collectFirst{ case tool if tool.name == spec.name =>
          if (tool.patterns.isEmpty) JsError("no patterns selected")
          else JsSuccess(fullCfg)
      }.getOrElse(JsError(s"no config for ${spec.name} found"))

        asReader(ps)
    }
  }

  implicit lazy val writer: Writes[Result] = Json.writes[Result]
}