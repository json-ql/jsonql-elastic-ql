package com.lifeinide.jsonql.elasticql.test;

import com.lifeinide.jsonql.elasticql.EQLBuilder;
import com.lifeinide.jsonql.elasticql.node.EQLHighlight;
import com.lifeinide.jsonql.elasticql.node.EQLRoot;
import com.lifeinide.jsonql.elasticql.node.EQLSort;
import com.lifeinide.jsonql.elasticql.node.component.*;
import com.lifeinide.jsonql.elasticql.node.query.*;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

/**
 * @author Lukasz Frankowski
 */
public class ElasticQLTest {

	public static final Logger logger = LoggerFactory.getLogger(ElasticQLTest.class);

	public static final String FIELD_TEXT = "text";
	public static final String FIELD_ID = "textid";

	protected EQLBuilder eqlBuilder = new EQLBuilder();

	protected enum TestEnum { A }

	@Test
	public void testComplexEql() {
		doJsonTest(
			EQLRoot.of()
				.withQuery(EQLBoolComponent.of(EQLBool.of()
					.withShould(EQLMatchComponent.of(FIELD_TEXT, EQLMatchQuery.of("middle").withAutoFuzziness()))
					.withShould(EQLMatchPhrasePrefixComponent.of(FIELD_ID, EQLMatchPhrasePrefixQuery.of("phrase-a")))
					.withFilter(EQLBoolComponent.of(EQLBool.of()
						.withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("C")))
						.withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("A")))))
					.withFilter(EQLRangeComponent.of("longVal", EQLRangeQuery.ofGte(1L).withLte(3L)))))
				.withSort("enumVal", EQLSort.ofAsc())
				.withSort("longVal", EQLSort.ofDesc())
				.withHighlight(EQLHighlight.of(FIELD_TEXT, FIELD_ID)),
			"testComplexEql.json"
		);
	}

	@Test
	public void testStringEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of(FIELD_ID, EQLTermQuery.of("phrase-an"))
		), "testStringEncoding.json");
	}

	@Test
	public void testBooleanEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of("booleanVal", EQLTermQuery.of(true))
		), "testBooleanEncoding.json");
	}

	@Test
	public void testEnumEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of("enumVal", EQLTermQuery.of(TestEnum.A))
		), "testEnumEncoding.json");
	}

	@Test
	public void testLongEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of("longVal", EQLTermQuery.of(3L))
		), "testLongEncoding.json");
	}

	@Test
	public void testBigDecimalEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of("decimalVal", EQLTermQuery.of(new BigDecimal("1.22")))
		), "testDecimalEncoding.json");
	}

	@Test
	public void testDateEncoding() {
		doJsonTest(EQLRoot.of().withQuery(
			EQLTermComponent.of("dateVal", EQLTermQuery.of(LocalDate.of(2018, 1, 19)))
		), "testDateEncoding.json");
	}

	protected void doJsonTest(EQLRoot root, String jsonFileName) {
		try {
			String builtJson = eqlBuilder.toJsonString(root);
			logger.debug("Built JSON:\n" + builtJson);
			String testJson = IOUtils.toString(getClass().getResourceAsStream(jsonFileName), StandardCharsets.UTF_8);
			Assertions.assertEquals(testJson, builtJson);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
