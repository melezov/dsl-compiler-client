package com.dslplatform.compiler.client.api.model.JSONTest;

import com.fasterxml.jackson.annotation.*;

public final class MummyVal implements java.io.Serializable {
    public MummyVal(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs oneLL,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs optLL,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrLL,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrOptLL,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrLL,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrOptLL,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listLL,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listOptLL,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListLL,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListOptLL,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setLL,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setOptLL,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetLL,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetOptLL) {
        setOneLL(oneLL);
        setOptLL(optLL);
        setArrLL(arrLL);
        setArrOptLL(arrOptLL);
        setOptArrLL(optArrLL);
        setOptArrOptLL(optArrOptLL);
        setListLL(listLL);
        setListOptLL(listOptLL);
        setOptListLL(optListLL);
        setOptListOptLL(optListOptLL);
        setSetLL(setLL);
        setSetOptLL(setOptLL);
        setOptSetLL(optSetLL);
        setOptSetOptLL(optSetOptLL);
    }

    public MummyVal() {
        this.oneLL = new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs();
        this.arrLL = new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[0];
        this.arrOptLL = new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[0];
        this.listLL = new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>();
        this.listOptLL = new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>();
        this.setLL = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>();
        this.setOptLL = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 115631744;
        result = prime * result + (this.oneLL.hashCode());
        result = prime * result
                + (this.optLL != null ? this.optLL.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof MummyVal)) return false;
        final MummyVal other = (MummyVal) obj;

        if (!(this.oneLL.equals(other.oneLL))) return false;
        if (!(this.optLL == other.optLL || this.optLL != null
                && this.optLL.equals(other.optLL))) return false;
        if (!(java.util.Arrays.equals(this.arrLL, other.arrLL))) return false;
        if (!(java.util.Arrays.equals(this.arrOptLL, other.arrOptLL)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrLL, other.optArrLL)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrOptLL, other.optArrOptLL)))
            return false;
        if (!(this.listLL.equals(other.listLL))) return false;
        if (!(this.listOptLL.equals(other.listOptLL))) return false;
        if (!(this.optListLL == other.optListLL || this.optListLL != null
                && this.optListLL.equals(other.optListLL))) return false;
        if (!(this.optListOptLL == other.optListOptLL || this.optListOptLL != null
                && this.optListOptLL.equals(other.optListOptLL))) return false;
        if (!(this.setLL.equals(other.setLL))) return false;
        if (!(this.setOptLL.equals(other.setOptLL))) return false;
        if (!(this.optSetLL == other.optSetLL || this.optSetLL != null
                && this.optSetLL.equals(other.optSetLL))) return false;
        if (!(this.optSetOptLL == other.optSetOptLL || this.optSetOptLL != null
                && this.optSetOptLL.equals(other.optSetOptLL))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "MummyVal(" + oneLL + ',' + optLL + ',' + arrLL + ',' + arrOptLL
                + ',' + optArrLL + ',' + optArrOptLL + ',' + listLL + ','
                + listOptLL + ',' + optListLL + ',' + optListOptLL + ','
                + setLL + ',' + setOptLL + ',' + optSetLL + ',' + optSetOptLL
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs oneLL;

    @JsonProperty("oneLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs getOneLL() {
        return oneLL;
    }

    public MummyVal setOneLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneLL\" cannot be null!");
        this.oneLL = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs optLL;

    @JsonProperty("optLL")
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs getOptLL() {
        return optLL;
    }

    public MummyVal setOptLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs value) {
        this.optLL = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrLL;

    @JsonProperty("arrLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] getArrLL() {
        return arrLL;
    }

    public MummyVal setArrLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrLL\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.arrLL = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrOptLL;

    @JsonProperty("arrOptLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] getArrOptLL() {
        return arrOptLL;
    }

    public MummyVal setArrOptLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrOptLL\" cannot be null!");
        this.arrOptLL = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrLL;

    @JsonProperty("optArrLL")
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] getOptArrLL() {
        return optArrLL;
    }

    public MummyVal setOptArrLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optArrLL = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrOptLL;

    @JsonProperty("optArrOptLL")
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] getOptArrOptLL() {
        return optArrOptLL;
    }

    public MummyVal setOptArrOptLL(
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] value) {
        this.optArrOptLL = value;

        return this;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listLL;

    @JsonProperty("listLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getListLL() {
        return listLL;
    }

    public MummyVal setListLL(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listLL\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.listLL = value;

        return this;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listOptLL;

    @JsonProperty("listOptLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getListOptLL() {
        return listOptLL;
    }

    public MummyVal setListOptLL(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listOptLL\" cannot be null!");
        this.listOptLL = value;

        return this;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListLL;

    @JsonProperty("optListLL")
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getOptListLL() {
        return optListLL;
    }

    public MummyVal setOptListLL(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optListLL = value;

        return this;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListOptLL;

    @JsonProperty("optListOptLL")
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getOptListOptLL() {
        return optListOptLL;
    }

    public MummyVal setOptListOptLL(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        this.optListOptLL = value;

        return this;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setLL;

    @JsonProperty("setLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getSetLL() {
        return setLL;
    }

    public MummyVal setSetLL(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setLL\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.setLL = value;

        return this;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setOptLL;

    @JsonProperty("setOptLL")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getSetOptLL() {
        return setOptLL;
    }

    public MummyVal setSetOptLL(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setOptLL\" cannot be null!");
        this.setOptLL = value;

        return this;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetLL;

    @JsonProperty("optSetLL")
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getOptSetLL() {
        return optSetLL;
    }

    public MummyVal setOptSetLL(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optSetLL = value;

        return this;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetOptLL;

    @JsonProperty("optSetOptLL")
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> getOptSetOptLL() {
        return optSetOptLL;
    }

    public MummyVal setOptSetOptLL(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> value) {
        this.optSetOptLL = value;

        return this;
    }
}
