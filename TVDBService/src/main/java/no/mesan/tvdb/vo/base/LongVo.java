package no.mesan.tvdb.vo.base;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Base for {@link Long}-vo.
 */
public class LongVo implements ValueObject<Long> {

    private final Long value;

    protected LongVo(final Long value) {
        this.value = value;
    }

    protected LongVo(final String value) {
        this.value = Long.valueOf(value);
    }

    @Override
    @JsonValue
    public Long value() {
        return value;
    }

    public boolean hasValue() {
        return value != null;
    }

    public boolean isEmpty() {
        return !hasValue();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("value", value)
                .toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final LongVo rhs = (LongVo) obj;
        return new EqualsBuilder()
                .append(this.value, rhs.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(value)
                .toHashCode();
    }
}