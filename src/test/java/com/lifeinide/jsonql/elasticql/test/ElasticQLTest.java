package com.lifeinide.jsonql.elasticql.test;

import com.lifeinide.jsonql.elasticql.EQLBuilder;
import com.lifeinide.jsonql.elasticql.node.EQLHighlight;
import com.lifeinide.jsonql.elasticql.node.EQLRoot;
import com.lifeinide.jsonql.elasticql.node.component.*;
import com.lifeinide.jsonql.elasticql.node.query.*;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Lukasz Frankowski
 */
public class ElasticQLTest {

	public static final String FIELD_TEXT = "text";
	public static final String FIELD_ID = "textid";

	protected EQLBuilder eqlBuilder = new EQLBuilder();

	@Test
	public void testComplexEql() {
		jsonTest(
			EQLRoot.of()
				.withQuery(EQLBoolComponent.of(EQLBool.of()
					.withShould(EQLMatchComponent.of(FIELD_TEXT, EQLMatchQuery.of("middle").withAutoFuzziness()))
					.withShould(EQLMatchPhrasePrefixComponent.of(FIELD_ID, EQLMatchPhrasePrefixQuery.of("phrase-a")))
					.withFilter(EQLBoolComponent.of(EQLBool.of()
						.withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("C")))
						.withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("A")))))
					.withFilter(EQLRangeComponent.of("longVal", EQLRangeQuery.ofGte(1L).withLte(3L)))))
				.withHighlight(EQLHighlight.of(FIELD_TEXT, FIELD_ID)),
			"testComplexEql.json"
		);
	}

	protected void jsonTest(EQLRoot root, String jsonFileName) {
		try {
			String builtJson = eqlBuilder.toJsonString(root);
			String testJson = IOUtils.toString(getClass().getResourceAsStream(jsonFileName), StandardCharsets.UTF_8);
			Assertions.assertEquals(testJson, builtJson);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// TODOLF particular term types test (string, boolean, enum, long, double, bigdecimal->keyword, date)

}
