package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchComponent;

import javax.annotation.Nonnull;

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

	@Nonnull public EQLMatchQuery withFuzziness(@Nonnull String fuzziness) {
		setFuzziness(fuzziness);
		return this;
	}

	@Nonnull public EQLMatchQuery withAutoFuzziness() {
		return withFuzziness(AUTO);
	}

	@Override
	@Nonnull public EQLMatchQuery withQuery(@Nonnull String query) {
		return (EQLMatchQuery) super.withQuery(query);
	}

	@Nonnull public static EQLMatchQuery of(@Nonnull String query) {
		return new EQLMatchQuery().withQuery(query);
	}
	
}
