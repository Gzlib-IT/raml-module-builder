package org.folio.rest.tools.utils;

import java.lang.invoke.MethodHandles;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class VertxUtils {
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private VertxUtils() {
    throw new UnsupportedOperationException("Cannot instantiate utility class.");
  }

  /**
   * Return the Vertx of the current context; if there isn't a current context
   * create and return a new Vertx using getVertxWithExceptionHandler().
   * @return the Vertx
   */
  public static Vertx getVertxFromContextOrNew() {
    Context context = Vertx.currentContext();

    if (context == null) {
      return getVertxWithExceptionHandler();
    }

    return context.owner();
  }

  /**
   * Return a new Vertx with an exception handler that writes the exception to VertxUtils' logger.
   * @return the new Vertx
   */
  public static Vertx getVertxWithExceptionHandler() {
    Vertx vertx = Vertx.vertx();
    vertx.exceptionHandler(ex -> log.error("Unhandled exception caught by vertx", ex));
    return vertx;
  }
}
