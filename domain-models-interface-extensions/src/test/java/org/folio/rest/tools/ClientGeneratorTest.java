package org.folio.rest.tools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.vertx.core.logging.LoggerFactory;

public class ClientGeneratorTest {

  static {
    System.setProperty(LoggerFactory.LOGGER_DELEGATE_FACTORY_CLASS_NAME,
      "io.vertx.core.logging.Log4j2LogDelegateFactory");
  }

  private static String sourceDir;

  @Before
  public void setUp() {
    System.setProperty("client.generate", "true");
    System.setProperty("project.basedir", ".");
    sourceDir = System.getProperties().getProperty("project.basedir")
      + ClientGenerator.PATH_TO_GENERATE_TO
      + RTFConsts.CLIENT_GEN_PACKAGE.replace('.', '/');
  }

  @After
  public void cleanUp() throws IOException {
    System.clearProperty("client.generate");
    System.clearProperty("project.basedir");
    FileUtils.deleteDirectory(new File(sourceDir));
  }

  @Test
  public void doesGenerateTestResourceClient() throws Exception {
    ClientGenerator.main(null);
    File expectedClient = new File(sourceDir + "/TestResourceClient.java");
    Assert.assertTrue(expectedClient.exists());

    // NOTE: naive assertion expecting generated client source file lines match below expected lines

    List<String> expected = new ArrayList<>();
    expected.add("");
    expected.add("package org.folio.rest.client;");
    expected.add("");
    expected.add("import java.io.UnsupportedEncodingException;");
    expected.add("import java.math.BigDecimal;");
    expected.add("import java.net.URLEncoder;");
    expected.add("import java.time.ZoneId;");
    expected.add("import java.time.ZonedDateTime;");
    expected.add("import java.time.format.DateTimeFormatter;");
    expected.add("import java.util.Date;");
    expected.add("import io.vertx.core.Handler;");
    expected.add("import io.vertx.core.http.HttpClient;");
    expected.add("import io.vertx.core.http.HttpClientOptions;");
    expected.add("import io.vertx.core.http.HttpClientResponse;");
    expected.add("import org.folio.rest.tools.utils.VertxUtils;");
    expected.add("");
    expected.add("");
    expected.add("/**");
    expected.add(" * Auto-generated code - based on class org.folio.rest.jaxrs.resource.TestResource");
    expected.add(" * ");
    expected.add(" */");
    expected.add("public class TestResourceClient {");
    expected.add("");
    expected.add("    private String tenantId;");
    expected.add("    private String token;");
    expected.add("    private String okapiUrl;");
    expected.add("    private HttpClientOptions options;");
    expected.add("    private HttpClient httpClient;");
    expected.add("");
    expected.add("    public TestResourceClient(String okapiUrl, String tenantId, String token, boolean keepAlive, int connTO, int idleTO) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this.tenantId = tenantId;");
    expected.add("        this.token = token;");
    expected.add("        this.okapiUrl = okapiUrl;");
    expected.add("        options = new HttpClientOptions();");
    expected.add("        options.setLogActivity(true);");
    expected.add("        options.setKeepAlive(keepAlive);");
    expected.add("        options.setConnectTimeout(connTO);");
    expected.add("        options.setIdleTimeout(idleTO);");
    expected.add("        httpClient = VertxUtils.getVertxFromContextOrNew().createHttpClient(options);");
    expected.add("    }");
    expected.add("");
    expected.add("    public TestResourceClient(String okapiUrl, String tenantId, String token, boolean keepAlive) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this(okapiUrl, tenantId, token, keepAlive, 2000, 5000);");
    expected.add("    }");
    expected.add("");
    expected.add("    public TestResourceClient(String okapiUrl, String tenantId, String token) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this(okapiUrl, tenantId, token, true, 2000, 5000);");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * @deprecated  use a constructor that takes a full okapiUrl instead");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    @Deprecated");
    expected.add("    public TestResourceClient(String host, int port, String tenantId, String token, boolean keepAlive, int connTO, int idleTO) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this((((\"http://\"+ host)+\":\")+ port), tenantId, token, keepAlive, connTO, idleTO);");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * @deprecated  use a constructor that takes a full okapiUrl instead");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    @Deprecated");
    expected.add("    public TestResourceClient(String host, int port, String tenantId, String token, boolean keepAlive) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this(host, port, tenantId, token, keepAlive, 2000, 5000);");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * @deprecated  use a constructor that takes a full okapiUrl instead");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    @Deprecated");
    expected.add("    public TestResourceClient(String host, int port, String tenantId, String token) {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this(host, port, tenantId, token, true, 2000, 5000);");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * Convenience constructor for tests ONLY!<br>Connect to localhost on 8081 as folio_demo tenant.@deprecated  use a constructor that takes a full okapiUrl instead");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    @Deprecated");
    expected.add("    public TestResourceClient() {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        this(\"localhost\", 8081, \"folio_demo\", \"folio_demo\", false, 2000, 5000);");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * Service endpoint \"unittests\"+queryParams.toString()");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    public void getRmbtests(String name, Boolean success, Handler<HttpClientResponse> responseHandler)");
    expected.add("        throws UnsupportedEncodingException");
    expected.add("    {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        StringBuilder queryParams = new StringBuilder(\"?\");");
    expected.add("        if (name!= null) {");
    expected.add("            queryParams.append(\"name=\");");
    expected.add("            queryParams.append(URLEncoder.encode(name, \"UTF-8\"));");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        if (success!= null) {");
    expected.add("            queryParams.append(\"success=\");");
    expected.add("            queryParams.append(success);");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        io.vertx.core.http.HttpClientRequest request = httpClient.getAbs(okapiUrl+\"unittests\"+queryParams.toString());");
    expected.add("        request.handler(responseHandler);");
    expected.add("        request.putHeader(\"Accept\", \"application/json\");");
    expected.add("        if (tenantId!= null) {");
    expected.add("            request.putHeader(\"X-Okapi-Token\", token);");
    expected.add("            request.putHeader(\"x-okapi-tenant\", tenantId);");
    expected.add("        }");
    expected.add("        if (okapiUrl!= null) {");
    expected.add("            request.putHeader(\"X-Okapi-Url\", okapiUrl);");
    expected.add("        }");
    expected.add("        request.end();");
    expected.add("    }");
    expected.add("");
    expected.add("    /**");
    expected.add("     * Service endpoint \"unittestsbooks\"+queryParams.toString()");
    expected.add("     * ");
    expected.add("     */");
    expected.add("    public void getRmbtestsBooks(String author, Date publicationDate, BigDecimal rating, String isbn, String[] facets, Handler<HttpClientResponse> responseHandler)");
    expected.add("        throws UnsupportedEncodingException");
    expected.add("    {");
    expected.add("        // Auto-generated code");
    expected.add("        // - generated by       org.folio.rest.tools.ClientGenerator");
    expected.add("        // - generated based on org.folio.rest.jaxrs.resource.TestResourceResource");
    expected.add("        StringBuilder queryParams = new StringBuilder(\"?\");");
    expected.add("        if (author!= null) {");
    expected.add("            queryParams.append(\"author=\");");
    expected.add("            queryParams.append(URLEncoder.encode(author, \"UTF-8\"));");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        if (publicationDate!= null) {");
    expected.add("            queryParams.append(\"publicationDate=\");");
    expected.add("            queryParams.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ZonedDateTime.ofInstant(publicationDate.toInstant(), ZoneId.of(\"UTC\"))));");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        if (rating!= null) {");
    expected.add("            queryParams.append(\"rating=\");");
    expected.add("            queryParams.append(rating);");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        if (isbn!= null) {");
    expected.add("            queryParams.append(\"isbn=\");");
    expected.add("            queryParams.append(URLEncoder.encode(isbn, \"UTF-8\"));");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        if (facets!= null) {");
    expected.add("            queryParams.append(\"facets=\");");
    expected.add("            if(facets.getClass().isArray()){queryParams.append(String.join(\"&facets=\",facets));}");
    expected.add("            queryParams.append(\"&\");");
    expected.add("        }");
    expected.add("        io.vertx.core.http.HttpClientRequest request = httpClient.getAbs(okapiUrl+\"unittestsbooks\"+queryParams.toString());");
    expected.add("        request.handler(responseHandler);");
    expected.add("        request.putHeader(\"Accept\", \"application/json\");");
    expected.add("        if (tenantId!= null) {");
    expected.add("            request.putHeader(\"X-Okapi-Token\", token);");
    expected.add("            request.putHeader(\"x-okapi-tenant\", tenantId);");
    expected.add("        }");
    expected.add("        if (okapiUrl!= null) {");
    expected.add("            request.putHeader(\"X-Okapi-Url\", okapiUrl);");
    expected.add("        }");
    expected.add("        request.end();");
    expected.add("    }");
    expected.add("");
    expected.add("}");

    List<String> actual = FileUtils.readLines(expectedClient, StandardCharsets.UTF_8);

    Assert.assertEquals(expected.size(), actual.size());
    Assert.assertEquals(expected, actual);
  }

}
