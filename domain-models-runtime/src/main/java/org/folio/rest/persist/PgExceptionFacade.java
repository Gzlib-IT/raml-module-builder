package org.folio.rest.persist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.vertx.pgclient.PgException;

/**
 * Easy access to
 * {@link io.vertx.pgclient.PgException PgException}
 * fields.
 */
public class PgExceptionFacade {
  private final Map<Character,String> fields;

  /**
   * @param throwable a GenericDatabaseException; any other Throwable is handled gracefully
   */
  public PgExceptionFacade(Throwable throwable) {
    if (!(throwable instanceof PgException)) {
      fields = Collections.emptyMap();
      return;
    }

    fields = new HashMap<>();
    fields.put('M', ((PgException) throwable).getMessage());
    fields.put('D', ((PgException) throwable).getDetail());
    fields.put('C', ((PgException) throwable).getCode());
  }

  /**
   * @return the fields of the underlying GenericDatabaseException, or an empty map if the throwable
   * isn't a GenericDatabaseException.
   */
  public Map<Character,String> getFields() {
    return fields;
  }

  /**
   * The SQL State code (PostgreSQL Error Codes) from the 'C' field
   * @see <a href="https://www.postgresql.org/docs/current/static/errcodes-appendix.html">PostgreSQL Error Codes</a>
   * @return state code, or empty String if not available or unknown
   */
  public String getSqlState() {
    return fields.getOrDefault('C', "");
  }

  /**
   * @return the error detail ('D' field), or empty String if not available or unknown
   */
  public String getDetail() {
    return fields.getOrDefault('D', "");
  }

  /**
   * @return the error message ('M' field), or empty String if not available or unknown
   */
  public String getMessage() {
    return fields.getOrDefault('M', "");
  }

  /**
   * @return the table ('t' field), or empty String if not available or unknown
   */
  public String getTable() {
    return fields.getOrDefault('t', "");
  }

  /**
   * @return the index ('n' field), or empty String if not available or unknown
   */
  public String getIndex() {
    return fields.getOrDefault('n', "");
  }

  /**
   * @return whether the sql state is "23503 foreign_key_violation"
   */
  public boolean isForeignKeyViolation() {
    return PgExceptionUtil.FOREIGN_KEY_VIOLATION.equals(getSqlState());
  }

  /**
   * @return whether the sql state is "23505 unique_violation"
   */
  public boolean isUniqueViolation() {
    return PgExceptionUtil.UNIQUE_VIOLATION.equals(getSqlState());
  }

  /**
   * @return whether the sql state is "22P02 invalid_text_representation"
   */
  public boolean isInvalidTextRepresentation() {
    return PgExceptionUtil.INVALID_TEXT_REPRESENTATION.equals(getSqlState());
  }
}
