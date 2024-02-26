package io.confluent.developer;

import io.confluent.developer.HashUtility;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

/*
 * @UdfDescription: This annotation marks the Java class as UDF.
 * You can set the following attribute to this annotation:
 * name, description, author, version and the category.
 */
@UdfDescription(
  name = "hash",
  description = "Build the hash of a given parameter, it could one value or a complete record as concatenated strings.",
  author = "Confluent"
)
public class Hash {

  /*
   * @Udf: This annotation marks the method that will be invoked to do the job.
   * If the parameters are meet during the call the method will be executed,
   * you can have multiple definitions for the same method with different
   * implementations.
   */
  @Udf(description = "Build the hash of a given parameter, it could one value or a complete record as concatenated strings.")
  public String hash(
    /*
     * @UdfParameter: This annotation marks each parameter of the method.
     * You can set the following attributes for this annotation:
     * value and description.
     */
    @UdfParameter(value = "str", description = "string value to be hashed with SHA256") final String str) {

    if (str == null) {
      return null;
    }

    return HashUtility.hashWithSHA256(str);
  }
}