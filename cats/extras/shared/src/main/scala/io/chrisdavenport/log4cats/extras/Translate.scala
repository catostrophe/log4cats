package io.chrisdavenport.log4cats.extras

import io.chrisdavenport.log4cats._
import cats._

/**
  * Allows for mapK or algebraic higher kinded 
  * transformations
  **/
object Translate {

  def errorLogger[G[_], F[_]](f: G ~> F)(logger: ErrorLogger[G]): ErrorLogger[F] = 
    new ErrorLogger[F]{
      def error(t: Throwable)(message: => String): F[Unit] = 
        f(logger.error(t)(message))
      def warn(t: Throwable)(message: => String): F[Unit] =
        f(logger.warn(t)(message))
      def info(t: Throwable)(message: => String): F[Unit] = 
        f(logger.info(t)(message))
      def debug(t: Throwable)(message: => String): F[Unit] = 
        f(logger.debug(t)(message))
      def trace(t: Throwable)(message: => String): F[Unit] = 
        f(logger.trace(t)(message))
    }

  def logger[G[_], F[_]](f: G ~> F)(logger: Logger[G]): Logger[F] = 
    new Logger[F]{
      def error(t: Throwable)(message: => String): F[Unit] = 
        f(logger.error(t)(message))
      def warn(t: Throwable)(message: => String): F[Unit] =
        f(logger.warn(t)(message))
      def info(t: Throwable)(message: => String): F[Unit] = 
        f(logger.info(t)(message))
      def debug(t: Throwable)(message: => String): F[Unit] = 
        f(logger.debug(t)(message))
      def trace(t: Throwable)(message: => String): F[Unit] = 
        f(logger.trace(t)(message))
      def error(message: => String): F[Unit] = 
        f(logger.error(message))
      def warn(message: => String): F[Unit] = 
        f(logger.warn(message))
      def info(message: => String): F[Unit] =
        f(logger.info(message))
      def debug(message: => String): F[Unit] =
        f(logger.debug(message))
      def trace(message: => String): F[Unit] =
        f(logger.trace(message))
    }

  def messageLogger[G[_], F[_]](f: G ~> F)(logger: MessageLogger[G]): MessageLogger[F] = 
    new MessageLogger[F]{
      def error(message: => String): F[Unit] = 
        f(logger.error(message))
      def warn(message: => String): F[Unit] = 
        f(logger.warn(message))
      def info(message: => String): F[Unit] =
        f(logger.info(message))
      def debug(message: => String): F[Unit] =
        f(logger.debug(message))
      def trace(message: => String): F[Unit] =
        f(logger.trace(message))
    }
  
  def selfAwareLogger[G[_], F[_]](f: G ~> F)(logger: SelfAwareLogger[G]): SelfAwareLogger[F] =
    new SelfAwareLogger[F]{
      def isTraceEnabled: F[Boolean] =
        f(logger.isTraceEnabled)
      def isDebugEnabled: F[Boolean] =
        f(logger.isDebugEnabled)
      def isInfoEnabled: F[Boolean] =
        f(logger.isInfoEnabled)
      def isWarnEnabled: F[Boolean] =
        f(logger.isWarnEnabled)
      def isErrorEnabled: F[Boolean] =
        f(logger.isErrorEnabled)

      def error(t: Throwable)(message: => String): F[Unit] = 
        f(logger.error(t)(message))
      def warn(t: Throwable)(message: => String): F[Unit] =
        f(logger.warn(t)(message))
      def info(t: Throwable)(message: => String): F[Unit] = 
        f(logger.info(t)(message))
      def debug(t: Throwable)(message: => String): F[Unit] = 
        f(logger.debug(t)(message))
      def trace(t: Throwable)(message: => String): F[Unit] = 
        f(logger.trace(t)(message))
      def error(message: => String): F[Unit] = 
        f(logger.error(message))
      def warn(message: => String): F[Unit] = 
        f(logger.warn(message))
      def info(message: => String): F[Unit] =
        f(logger.info(message))
      def debug(message: => String): F[Unit] =
        f(logger.debug(message))
      def trace(message: => String): F[Unit] =
        f(logger.trace(message))
    }

    def selfAwareStructuredLogger[G[_], F[_]](f: G ~> F)(logger: SelfAwareStructuredLogger[G]): SelfAwareStructuredLogger[F] =
      new SelfAwareStructuredLogger[F]{
        def isTraceEnabled: F[Boolean] =
          f(logger.isTraceEnabled)
        def isDebugEnabled: F[Boolean] =
          f(logger.isDebugEnabled)
        def isInfoEnabled: F[Boolean] =
          f(logger.isInfoEnabled)
        def isWarnEnabled: F[Boolean] =
          f(logger.isWarnEnabled)
        def isErrorEnabled: F[Boolean] =
          f(logger.isErrorEnabled)

        def trace(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.trace(ctx:_*)(msg))
        def debug(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.debug(ctx:_*)(msg))
        def info(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.info(ctx:_*)(msg))
        def warn(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.warn(ctx:_*)(msg))
        def error(ctx: (String, String)*)(msg: => String): F[Unit] =
          f(logger.error(ctx:_*)(msg))

        def error(t: Throwable)(message: => String): F[Unit] = 
          f(logger.error(t)(message))
        def warn(t: Throwable)(message: => String): F[Unit] =
          f(logger.warn(t)(message))
        def info(t: Throwable)(message: => String): F[Unit] = 
          f(logger.info(t)(message))
        def debug(t: Throwable)(message: => String): F[Unit] = 
          f(logger.debug(t)(message))
        def trace(t: Throwable)(message: => String): F[Unit] = 
          f(logger.trace(t)(message))
        def error(message: => String): F[Unit] = 
          f(logger.error(message))
        def warn(message: => String): F[Unit] = 
          f(logger.warn(message))
        def info(message: => String): F[Unit] =
          f(logger.info(message))
        def debug(message: => String): F[Unit] =
          f(logger.debug(message))
        def trace(message: => String): F[Unit] =
          f(logger.trace(message))
      }



    def structuredLogger[G[_], F[_]](f: G ~> F)(logger: StructuredLogger[G]): StructuredLogger[F] =
      new StructuredLogger[F]{
        def trace(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.trace(ctx:_*)(msg))
        def debug(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.debug(ctx:_*)(msg))
        def info(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.info(ctx:_*)(msg))
        def warn(ctx: (String, String)*)(msg: => String): F[Unit] = 
          f(logger.warn(ctx:_*)(msg))
        def error(ctx: (String, String)*)(msg: => String): F[Unit] =
          f(logger.error(ctx:_*)(msg))

        def error(t: Throwable)(message: => String): F[Unit] = 
          f(logger.error(t)(message))
        def warn(t: Throwable)(message: => String): F[Unit] =
          f(logger.warn(t)(message))
        def info(t: Throwable)(message: => String): F[Unit] = 
          f(logger.info(t)(message))
        def debug(t: Throwable)(message: => String): F[Unit] = 
          f(logger.debug(t)(message))
        def trace(t: Throwable)(message: => String): F[Unit] = 
          f(logger.trace(t)(message))
        def error(message: => String): F[Unit] = 
          f(logger.error(message))
        def warn(message: => String): F[Unit] = 
          f(logger.warn(message))
        def info(message: => String): F[Unit] =
          f(logger.info(message))
        def debug(message: => String): F[Unit] =
          f(logger.debug(message))
        def trace(message: => String): F[Unit] =
          f(logger.trace(message))
      }

}
