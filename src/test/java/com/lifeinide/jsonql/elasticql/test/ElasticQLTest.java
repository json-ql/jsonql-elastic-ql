package com.lifeinide.jsonql.elasticql.test;

import com.lifeinide.jsonql.elasticql.EQLBuilder;
import com.lifeinide.jsonql.elasticql.node.EQLHighlight;
import com.lifeinide.jsonql.elasticql.node.EQLRoot;
import com.lifeinide.jsonql.elasticql.node.component.EQLBoolComponent;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchComponent;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchPhrasePrefixComponent;
import com.lifeinide.jsonql.elasticql.node.component.EQLTermComponent;
import com.lifeinide.jsonql.elasticql.node.query.EQLBool;
import com.lifeinide.jsonql.elasticql.node.query.EQLMatchPhrasePrefixQuery;
import com.lifeinide.jsonql.elasticql.node.query.EQLMatchQuery;
import com.lifeinide.jsonql.elasticql.node.query.EQLTermValue;
import org.junit.jupiter.api.Test;

/**
 * @author Lukasz Frankowski
 */
public class ElasticQLTest {

	public static final String FIELD_TEXT = "text";
	public static final String FIELD_ID = "textid";

	protected EQLBuilder eqlBuilder = new EQLBuilder();

	@Test
	public void testComplexEql() {
		EQLRoot root = EQLRoot.of()
			.withQuery(EQLBoolComponent.of(EQLBool.of()
				.withShould(EQLMatchComponent.of(FIELD_TEXT, new EQLMatchQuery().withQuery("middle")))
			    .withShould(EQLMatchPhrasePrefixComponent.of(FIELD_ID, new EQLMatchPhrasePrefixQuery().withQuery("phrase-a")))
				.withFilter(EQLBoolComponent.of(new EQLBool()
					.withShould(EQLTermComponent.of("enumVal", new EQLTermValue<>().withValue("C")))
					.withShould(EQLTermComponent.of("enumVal", new EQLTermValue<>().withValue("A")))))
				.withFilter(EQLTermComponent.of("longVal", new EQLTermValue<>().withValue(3L)))))
			.withHighlight(EQLHighlight.of(FIELD_TEXT, FIELD_ID));

		System.out.println(eqlBuilder.toJsonString(root));
		// TODOLF assertions instead of println
	}

	// TODOLF particular term types test (long, double, bigdecimal->keyword, date, timestamp, boolean)

}
