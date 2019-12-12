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
public class GsonEQLTest {

	public static final String FIELD_TEXT = "text";
	public static final String FIELD_ID = "textid";

	protected EQLBuilder eqlBuilder = new EQLBuilder();

	@Test
	public void testComplexEql() {
		EQLRoot root = new EQLRoot()
			.withQuery(new EQLBoolComponent().withBool(new EQLBool()
				.withShould(new EQLMatchComponent().withMatch(FIELD_TEXT, new EQLMatchQuery().withQuery("middle")))
			    .withShould(new EQLMatchPhrasePrefixComponent().withMatchPhrasePrefix(FIELD_ID, new EQLMatchPhrasePrefixQuery().withQuery("phrase-a")))
				.withFilter(new EQLBoolComponent().withBool(new EQLBool()
					.withShould(new EQLTermComponent().withTerm("enumVal", new EQLTermValue<>().withValue("C")))
					.withShould(new EQLTermComponent().withTerm("enumVal", new EQLTermValue<>().withValue("A")))))
				.withFilter(new EQLTermComponent().withTerm("longVal", new EQLTermValue<>().withValue(3L)))))
			.withHighlight(new EQLHighlight()
				.withField(FIELD_TEXT)
				.withField(FIELD_ID));

		System.out.println(eqlBuilder.toJsonString(root));
		// TODOLF assertions instead of println
	}

	// TODOLF particular term types test (long, double, bigdecimal->keyword, date, timestamp, boolean)

}
