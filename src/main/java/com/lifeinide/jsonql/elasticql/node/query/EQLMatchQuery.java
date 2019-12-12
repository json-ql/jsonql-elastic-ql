package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchComponent;

/**
 * A query for {@link EQLMatchComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchQuery extends EQLQuery {

	@SerializedName("fuzziness")
	protected String fuzziness = "AUTO";

	public String getFuzziness() {
		return fuzziness;
	}

	public void setFuzziness(String fuzziness) {
		this.fuzziness = fuzziness;
	}

	public EQLMatchQuery withFuzziness(String fuzziness) {
		setFuzziness(fuzziness);
		return this;
	}

	@Override
	public EQLMatchQuery withQuery(String query) {
		return (EQLMatchQuery) super.withQuery(query);
	}

	public EQLMatchQuery of(String query) {
		return new EQLMatchQuery().withQuery(query);
	}
	
}
