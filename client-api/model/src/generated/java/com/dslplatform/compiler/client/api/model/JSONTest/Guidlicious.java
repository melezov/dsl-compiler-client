package com.dslplatform.compiler.client.api.model.JSONTest;

import com.fasterxml.jackson.annotation.*;

public final class Guidlicious implements java.io.Serializable {
    public Guidlicious(
            final java.util.UUID oneGuid,
            final java.util.UUID optGuid,
            final java.util.UUID[] arrGuid,
            final java.util.UUID[] arrOptGuid,
            final java.util.UUID[] optArrGuid,
            final java.util.UUID[] optArrOptGuid,
            final java.util.List<java.util.UUID> listGuid,
            final java.util.List<java.util.UUID> listOptGuid,
            final java.util.List<java.util.UUID> optListGuid,
            final java.util.List<java.util.UUID> optListOptGuid,
            final java.util.Set<java.util.UUID> setGuid,
            final java.util.Set<java.util.UUID> setOptGuid,
            final java.util.Set<java.util.UUID> optSetGuid,
            final java.util.Set<java.util.UUID> optSetOptGuid) {
        setOneGuid(oneGuid);
        setOptGuid(optGuid);
        setArrGuid(arrGuid);
        setArrOptGuid(arrOptGuid);
        setOptArrGuid(optArrGuid);
        setOptArrOptGuid(optArrOptGuid);
        setListGuid(listGuid);
        setListOptGuid(listOptGuid);
        setOptListGuid(optListGuid);
        setOptListOptGuid(optListOptGuid);
        setSetGuid(setGuid);
        setSetOptGuid(setOptGuid);
        setOptSetGuid(optSetGuid);
        setOptSetOptGuid(optSetOptGuid);
    }

    public Guidlicious() {
        this.oneGuid = java.util.UUID.randomUUID();
        this.arrGuid = new java.util.UUID[] {};
        this.arrOptGuid = new java.util.UUID[] {};
        this.listGuid = new java.util.ArrayList<java.util.UUID>();
        this.listOptGuid = new java.util.ArrayList<java.util.UUID>();
        this.setGuid = new java.util.HashSet<java.util.UUID>();
        this.setOptGuid = new java.util.HashSet<java.util.UUID>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1597917123;
        result = prime * result
                + (this.oneGuid != null ? this.oneGuid.hashCode() : 0);
        result = prime * result
                + (this.optGuid != null ? this.optGuid.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof Guidlicious)) return false;
        final Guidlicious other = (Guidlicious) obj;

        if (!(this.oneGuid.equals(other.oneGuid))) return false;
        if (!(this.optGuid == other.optGuid || this.optGuid != null
                && this.optGuid.equals(other.optGuid))) return false;
        if (!(java.util.Arrays.equals(this.arrGuid, other.arrGuid)))
            return false;
        if (!(java.util.Arrays.equals(this.arrOptGuid, other.arrOptGuid)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrGuid, other.optArrGuid)))
            return false;
        if (!(java.util.Arrays.equals(this.optArrOptGuid, other.optArrOptGuid)))
            return false;
        if (!(this.listGuid.equals(other.listGuid))) return false;
        if (!(this.listOptGuid.equals(other.listOptGuid))) return false;
        if (!(this.optListGuid == other.optListGuid || this.optListGuid != null
                && this.optListGuid.equals(other.optListGuid))) return false;
        if (!(this.optListOptGuid == other.optListOptGuid || this.optListOptGuid != null
                && this.optListOptGuid.equals(other.optListOptGuid)))
            return false;
        if (!(this.setGuid.equals(other.setGuid))) return false;
        if (!(this.setOptGuid.equals(other.setOptGuid))) return false;
        if (!(this.optSetGuid == other.optSetGuid || this.optSetGuid != null
                && this.optSetGuid.equals(other.optSetGuid))) return false;
        if (!(this.optSetOptGuid == other.optSetOptGuid || this.optSetOptGuid != null
                && this.optSetOptGuid.equals(other.optSetOptGuid)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Guidlicious(" + oneGuid + ',' + optGuid + ',' + arrGuid + ','
                + arrOptGuid + ',' + optArrGuid + ',' + optArrOptGuid + ','
                + listGuid + ',' + listOptGuid + ',' + optListGuid + ','
                + optListOptGuid + ',' + setGuid + ',' + setOptGuid + ','
                + optSetGuid + ',' + optSetOptGuid + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.UUID oneGuid;

    @JsonProperty("oneGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.UUID getOneGuid() {
        return oneGuid;
    }

    public Guidlicious setOneGuid(final java.util.UUID value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneGuid\" cannot be null!");
        this.oneGuid = value;

        return this;
    }

    private java.util.UUID optGuid;

    @JsonProperty("optGuid")
    public java.util.UUID getOptGuid() {
        return optGuid;
    }

    public Guidlicious setOptGuid(final java.util.UUID value) {
        this.optGuid = value;

        return this;
    }

    private java.util.UUID[] arrGuid;

    @JsonProperty("arrGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.UUID[] getArrGuid() {
        return arrGuid;
    }

    public Guidlicious setArrGuid(final java.util.UUID[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrGuid\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.arrGuid = value;

        return this;
    }

    private java.util.UUID[] arrOptGuid;

    @JsonProperty("arrOptGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.UUID[] getArrOptGuid() {
        return arrOptGuid;
    }

    public Guidlicious setArrOptGuid(final java.util.UUID[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrOptGuid\" cannot be null!");
        this.arrOptGuid = value;

        return this;
    }

    private java.util.UUID[] optArrGuid;

    @JsonProperty("optArrGuid")
    public java.util.UUID[] getOptArrGuid() {
        return optArrGuid;
    }

    public Guidlicious setOptArrGuid(final java.util.UUID[] value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optArrGuid = value;

        return this;
    }

    private java.util.UUID[] optArrOptGuid;

    @JsonProperty("optArrOptGuid")
    public java.util.UUID[] getOptArrOptGuid() {
        return optArrOptGuid;
    }

    public Guidlicious setOptArrOptGuid(final java.util.UUID[] value) {
        this.optArrOptGuid = value;

        return this;
    }

    private java.util.List<java.util.UUID> listGuid;

    @JsonProperty("listGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.util.UUID> getListGuid() {
        return listGuid;
    }

    public Guidlicious setListGuid(final java.util.List<java.util.UUID> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listGuid\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.listGuid = value;

        return this;
    }

    private java.util.List<java.util.UUID> listOptGuid;

    @JsonProperty("listOptGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.util.UUID> getListOptGuid() {
        return listOptGuid;
    }

    public Guidlicious setListOptGuid(final java.util.List<java.util.UUID> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"listOptGuid\" cannot be null!");
        this.listOptGuid = value;

        return this;
    }

    private java.util.List<java.util.UUID> optListGuid;

    @JsonProperty("optListGuid")
    public java.util.List<java.util.UUID> getOptListGuid() {
        return optListGuid;
    }

    public Guidlicious setOptListGuid(final java.util.List<java.util.UUID> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optListGuid = value;

        return this;
    }

    private java.util.List<java.util.UUID> optListOptGuid;

    @JsonProperty("optListOptGuid")
    public java.util.List<java.util.UUID> getOptListOptGuid() {
        return optListOptGuid;
    }

    public Guidlicious setOptListOptGuid(
            final java.util.List<java.util.UUID> value) {
        this.optListOptGuid = value;

        return this;
    }

    private java.util.Set<java.util.UUID> setGuid;

    @JsonProperty("setGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<java.util.UUID> getSetGuid() {
        return setGuid;
    }

    public Guidlicious setSetGuid(final java.util.Set<java.util.UUID> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setGuid\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.setGuid = value;

        return this;
    }

    private java.util.Set<java.util.UUID> setOptGuid;

    @JsonProperty("setOptGuid")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<java.util.UUID> getSetOptGuid() {
        return setOptGuid;
    }

    public Guidlicious setSetOptGuid(final java.util.Set<java.util.UUID> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setOptGuid\" cannot be null!");
        this.setOptGuid = value;

        return this;
    }

    private java.util.Set<java.util.UUID> optSetGuid;

    @JsonProperty("optSetGuid")
    public java.util.Set<java.util.UUID> getOptSetGuid() {
        return optSetGuid;
    }

    public Guidlicious setOptSetGuid(final java.util.Set<java.util.UUID> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optSetGuid = value;

        return this;
    }

    private java.util.Set<java.util.UUID> optSetOptGuid;

    @JsonProperty("optSetOptGuid")
    public java.util.Set<java.util.UUID> getOptSetOptGuid() {
        return optSetOptGuid;
    }

    public Guidlicious setOptSetOptGuid(
            final java.util.Set<java.util.UUID> value) {
        this.optSetOptGuid = value;

        return this;
    }
}
