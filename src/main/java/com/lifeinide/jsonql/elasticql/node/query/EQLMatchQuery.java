package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchComponent;

/**
 * A query for {@link EQLMatchComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchQuery extends EQLQuery {

	public static final String AUTO = "AUTO";

	/** Default: {@link #AUTO} **/
	@SerializedName("fuzziness")
	protected String fuzziness = null;

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

	public EQLMatchQuery withAutoFuzziness() {
		return withFuzziness(AUTO);
	}

	@Override
	public EQLMatchQuery withQuery(String query) {
		return (EQLMatchQuery) super.withQuery(query);
	}

	public static EQLMatchQuery of(String query) {
		return new EQLMatchQuery().withQuery(query);
	}
	
}
