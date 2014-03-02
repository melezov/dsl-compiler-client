package com.dslplatform.compiler.client.api.model.JSONTest;

import com.fasterxml.jackson.annotation.*;

public final class LongLegs implements java.io.Serializable {
    public LongLegs(
            final long oneLong,
            final Long optLong,
            final long[] arrLong,
            final Long[] arrOptLong,
            final long[] optArrLong,
            final Long[] optArrOptLong,
            final java.util.List<Long> listLong,
            final java.util.List<Long> listOptLong,
            final java.util.List<Long> optListLong,
            final java.util.List<Long> optListOptLong,
            final java.util.Set<Long> setLong,
            final java.util.Set<Long> setOptLong,
            final java.util.Set<Long> optSetLong,
            final java.util.Set<Long> optSetOptLong) {
        setOneLong(oneLong);
        setOptLong(optLong);
        setArrLong(arrLong);
        setArrOptLong(arrOptLong);
        setOptArrLong(optArrLong);
        setOptArrOptLong(optArrOptLong);
        setListLong(listLong);
        setListOptLong(listOptLong);
        setOptListLong(optListLong);
        setOptListOptLong(optListOptLong);
        setSetLong(setLong);
        setSetOptLong(setOptLong);
        setOptSetLong(optSetLong);
        setOptSetOptLong(optSetOptLong);
    }

    public LongLegs() {
        this.oneLong = 0L;
        this.arrLong = new long[] {};
        this.arrOptLong = new Long[] {};
        this.listLong = new java.util.ArrayList<Long>();
        this.listOptLong = new java.util.ArrayList<Long>();
        this.setLong = new java.util.HashSet<Long>();
        this.setOptLong = new java.util.HashSet<Long>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1420527283;
        result = prime * result
                + ((int) (this.oneLong ^ (this.oneLong >>> 32)));
        result = prime * result
                + (this.optLong != null ? this.optLong.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof LongLegs)) return false;
        final LongLegs other = (LongLegs) obj;

        if (!(this.oneLong == other.oneLong)) return false;
        if (!(this.optLong == other.optLong || this.optLong != null
                && this.optLong.equals(other.optLong))) return false;
        if (!(java.util.Arrays.equals(this.arrLong, other.arrLong)))
            return false;
        if (!(java.util.Arrays.equals(this.arrOptLong, other.arrOptLong)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrLong, other.optArrLong)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrOptLong, other.optArrOptLong)))
            return false;
        if (!(this.listLong.equals(other.listLong))) return false;
        if (!(this.listOptLong.equals(other.listOptLong))) return false;
        if (!(this.optListLong == other.optListLong || this.optListLong != null
                && this.optListLong.equals(other.optListLong))) return false;
        if (!(this.optListOptLong == other.optListOptLong || this.optListOptLong != null
                && this.optListOptLong.equals(other.optListOptLong)))
            return false;
        if (!(this.setLong.equals(other.setLong))) return false;
        if (!(this.setOptLong.equals(other.setOptLong))) return false;
        if (!(this.optSetLong == other.optSetLong || this.optSetLong != null
                && this.optSetLong.equals(other.optSetLong))) return false;
        if (!(this.optSetOptLong == other.optSetOptLong || this.optSetOptLong != null
                && this.optSetOptLong.equals(other.optSetOptLong)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "LongLegs(" + oneLong + ',' + optLong + ',' + arrLong + ','
                + arrOptLong + ',' + optArrLong + ',' + optArrOptLong + ','
                + listLong + ',' + listOptLong + ',' + optListLong + ','
                + optListOptLong + ',' + setLong + ',' + setOptLong + ','
                + optSetLong + ',' + optSetOptLong + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private long oneLong;

    @JsonProperty("oneLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public long getOneLong() {
        return oneLong;
    }

    public LongLegs setOneLong(final long value) {
        this.oneLong = value;

        return this;
    }

    private Long optLong;

    @JsonProperty("optLong")
    public Long getOptLong() {
        return optLong;
    }

    public LongLegs setOptLong(final Long value) {
        this.optLong = value;

        return this;
    }

    private long[] arrLong;

    @JsonProperty("arrLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public long[] getArrLong() {
        return arrLong;
    }

    public LongLegs setArrLong(final long[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrLong\" cannot be null!");
        this.arrLong = value;

        return this;
    }

    private Long[] arrOptLong;

    @JsonProperty("arrOptLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long[] getArrOptLong() {
        return arrOptLong;
    }

    public LongLegs setArrOptLong(final Long[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrOptLong\" cannot be null!");
        this.arrOptLong = value;

        return this;
    }

    private long[] optArrLong;

    @JsonProperty("optArrLong")
    public long[] getOptArrLong() {
        return optArrLong;
    }

    public LongLegs setOptArrLong(final long[] value) {
        this.optArrLong = value;

        return this;
    }

    private Long[] optArrOptLong;

    @JsonProperty("optArrOptLong")
    public Long[] getOptArrOptLong() {
        return optArrOptLong;
    }

    public LongLegs setOptArrOptLong(final Long[] value) {
        this.optArrOptLong = value;

        return this;
    }

    private java.util.List<Long> listLong;

    @JsonProperty("listLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<Long> getListLong() {
        return listLong;
    }

    public LongLegs setListLong(final java.util.List<Long> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listLong\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.listLong = value;

        return this;
    }

    private java.util.List<Long> listOptLong;

    @JsonProperty("listOptLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<Long> getListOptLong() {
        return listOptLong;
    }

    public LongLegs setListOptLong(final java.util.List<Long> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listOptLong\" cannot be null!");
        this.listOptLong = value;

        return this;
    }

    private java.util.List<Long> optListLong;

    @JsonProperty("optListLong")
    public java.util.List<Long> getOptListLong() {
        return optListLong;
    }

    public LongLegs setOptListLong(final java.util.List<Long> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optListLong = value;

        return this;
    }

    private java.util.List<Long> optListOptLong;

    @JsonProperty("optListOptLong")
    public java.util.List<Long> getOptListOptLong() {
        return optListOptLong;
    }

    public LongLegs setOptListOptLong(final java.util.List<Long> value) {
        this.optListOptLong = value;

        return this;
    }

    private java.util.Set<Long> setLong;

    @JsonProperty("setLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<Long> getSetLong() {
        return setLong;
    }

    public LongLegs setSetLong(final java.util.Set<Long> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setLong\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.setLong = value;

        return this;
    }

    private java.util.Set<Long> setOptLong;

    @JsonProperty("setOptLong")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<Long> getSetOptLong() {
        return setOptLong;
    }

    public LongLegs setSetOptLong(final java.util.Set<Long> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setOptLong\" cannot be null!");
        this.setOptLong = value;

        return this;
    }

    private java.util.Set<Long> optSetLong;

    @JsonProperty("optSetLong")
    public java.util.Set<Long> getOptSetLong() {
        return optSetLong;
    }

    public LongLegs setOptSetLong(final java.util.Set<Long> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optSetLong = value;

        return this;
    }

    private java.util.Set<Long> optSetOptLong;

    @JsonProperty("optSetOptLong")
    public java.util.Set<Long> getOptSetOptLong() {
        return optSetOptLong;
    }

    public LongLegs setOptSetOptLong(final java.util.Set<Long> value) {
        this.optSetOptLong = value;

        return this;
    }
}
