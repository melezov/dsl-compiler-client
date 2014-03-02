package com.dslplatform.compiler.client.api.model.JSONTest;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class StringlyTyped implements java.io.Serializable, AggregateRoot {
    public StringlyTyped() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.ID = 0;
        this.oneStr = "";
        this.arrStr = new String[] {};
        this.arrOptStr = new String[] {};
        this.ListStr = new java.util.ArrayList<String>();
        this.ListOptStr = new java.util.ArrayList<String>();
        this.setStr = new java.util.HashSet<String>();
        this.setOptStr = new java.util.HashSet<String>();
    }

    private transient final ServiceLocator _serviceLocator;
    private transient final DomainProxy _domainProxy;
    private transient final CrudProxy _crudProxy;

    private String URI;

    @JsonProperty("URI")
    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI != null ? URI.hashCode() : super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final StringlyTyped other = (StringlyTyped) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "StringlyTyped(" + URI + ')'
                : "new StringlyTyped(" + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public StringlyTyped(
            final String oneStr,
            final String optStr,
            final String[] arrStr,
            final String[] arrOptStr,
            final String[] optArrStr,
            final String[] optArrOptStr,
            final java.util.List<String> ListStr,
            final java.util.List<String> ListOptStr,
            final java.util.List<String> optListStr,
            final java.util.List<String> optListOptStr,
            final java.util.Set<String> setStr,
            final java.util.Set<String> setOptStr,
            final java.util.Set<String> optSetStr,
            final java.util.Set<String> optSetOptStr) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setOneStr(oneStr);
        setOptStr(optStr);
        setArrStr(arrStr);
        setArrOptStr(arrOptStr);
        setOptArrStr(optArrStr);
        setOptArrOptStr(optArrOptStr);
        setListStr(ListStr);
        setListOptStr(ListOptStr);
        setOptListStr(optListStr);
        setOptListOptStr(optListOptStr);
        setSetStr(setStr);
        setSetOptStr(setOptStr);
        setOptSetStr(optSetStr);
        setOptSetOptStr(optSetOptStr);
    }

    @JsonCreator
    private StringlyTyped(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("oneStr") final String oneStr,
            @JsonProperty("optStr") final String optStr,
            @JsonProperty("arrStr") final String[] arrStr,
            @JsonProperty("arrOptStr") final String[] arrOptStr,
            @JsonProperty("optArrStr") final String[] optArrStr,
            @JsonProperty("optArrOptStr") final String[] optArrOptStr,
            @JsonProperty("ListStr") final java.util.List<String> ListStr,
            @JsonProperty("ListOptStr") final java.util.List<String> ListOptStr,
            @JsonProperty("optListStr") final java.util.List<String> optListStr,
            @JsonProperty("optListOptStr") final java.util.List<String> optListOptStr,
            @JsonProperty("setStr") final java.util.Set<String> setStr,
            @JsonProperty("setOptStr") final java.util.Set<String> setOptStr,
            @JsonProperty("optSetStr") final java.util.Set<String> optSetStr,
            @JsonProperty("optSetOptStr") final java.util.Set<String> optSetOptStr) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.oneStr = oneStr == null ? "" : oneStr;
        this.optStr = optStr;
        this.arrStr = arrStr == null ? new String[] {} : arrStr;
        this.arrOptStr = arrOptStr == null ? new String[] {} : arrOptStr;
        this.optArrStr = optArrStr;
        this.optArrOptStr = optArrOptStr;
        this.ListStr = ListStr == null
                ? new java.util.ArrayList<String>()
                : ListStr;
        this.ListOptStr = ListOptStr == null
                ? new java.util.ArrayList<String>()
                : ListOptStr;
        this.optListStr = optListStr;
        this.optListOptStr = optListOptStr;
        this.setStr = setStr == null ? new java.util.HashSet<String>() : setStr;
        this.setOptStr = setOptStr == null
                ? new java.util.HashSet<String>()
                : setOptStr;
        this.optSetStr = optSetStr;
        this.optSetOptStr = optSetOptStr;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private StringlyTyped setID(final int value) {
        this.ID = value;

        return this;
    }

    public static StringlyTyped find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static StringlyTyped find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class).read(StringlyTyped.class, uri)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<StringlyTyped> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<StringlyTyped> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class).find(StringlyTyped.class, uris)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<StringlyTyped> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<StringlyTyped> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<StringlyTyped> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<StringlyTyped> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(StringlyTyped.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<StringlyTyped> search(
            final Specification<StringlyTyped> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<StringlyTyped> search(
            final Specification<StringlyTyped> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<StringlyTyped> search(
            final Specification<StringlyTyped> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<StringlyTyped> search(
            final Specification<StringlyTyped> specification,
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .search(specification, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count() throws java.io.IOException {
        return count(Bootstrap.getLocator());
    }

    public static long count(final ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class).count(StringlyTyped.class)
                    .get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(final Specification<StringlyTyped> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<StringlyTyped> specification,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class).count(specification).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private void updateWithAnother(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped result) {
        this.URI = result.URI;

        this.oneStr = result.oneStr;
        this.optStr = result.optStr;
        this.arrStr = result.arrStr;
        this.arrOptStr = result.arrOptStr;
        this.optArrStr = result.optArrStr;
        this.optArrOptStr = result.optArrOptStr;
        this.ListStr = result.ListStr;
        this.ListOptStr = result.ListOptStr;
        this.optListStr = result.optListStr;
        this.optListOptStr = result.optListOptStr;
        this.setStr = result.setStr;
        this.setOptStr = result.setOptStr;
        this.optSetStr = result.optSetStr;
        this.optSetOptStr = result.optSetOptStr;
        this.ID = result.ID;
    }

    public StringlyTyped persist() throws java.io.IOException {
        final StringlyTyped result;
        try {
            result = this.URI == null
                    ? _crudProxy.create(this).get()
                    : _crudProxy.update(this).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
        this.updateWithAnother(result);
        return this;
    }

    public StringlyTyped delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(StringlyTyped.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private String oneStr;

    @JsonProperty("oneStr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getOneStr() {
        return oneStr;
    }

    public StringlyTyped setOneStr(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneStr\" cannot be null!");
        this.oneStr = value;

        return this;
    }

    private String optStr;

    @JsonProperty("optStr")
    public String getOptStr() {
        return optStr;
    }

    public StringlyTyped setOptStr(final String value) {
        this.optStr = value;

        return this;
    }

    private String[] arrStr;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("arrStr")
    public String[] getArrStr() {
        return arrStr;
    }

    public StringlyTyped setArrStr(final String[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrStr\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.arrStr = value;

        return this;
    }

    private String[] arrOptStr;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("arrOptStr")
    public String[] getArrOptStr() {
        return arrOptStr;
    }

    public StringlyTyped setArrOptStr(final String[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrOptStr\" cannot be null!");
        this.arrOptStr = value;

        return this;
    }

    private String[] optArrStr;

    @JsonProperty("optArrStr")
    public String[] getOptArrStr() {
        return optArrStr;
    }

    public StringlyTyped setOptArrStr(final String[] value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optArrStr = value;

        return this;
    }

    private String[] optArrOptStr;

    @JsonProperty("optArrOptStr")
    public String[] getOptArrOptStr() {
        return optArrOptStr;
    }

    public StringlyTyped setOptArrOptStr(final String[] value) {
        this.optArrOptStr = value;

        return this;
    }

    private java.util.List<String> ListStr;

    @JsonProperty("ListStr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getListStr() {
        return ListStr;
    }

    public StringlyTyped setListStr(final java.util.List<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"ListStr\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.ListStr = value;

        return this;
    }

    private java.util.List<String> ListOptStr;

    @JsonProperty("ListOptStr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getListOptStr() {
        return ListOptStr;
    }

    public StringlyTyped setListOptStr(final java.util.List<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"ListOptStr\" cannot be null!");
        this.ListOptStr = value;

        return this;
    }

    private java.util.List<String> optListStr;

    @JsonProperty("optListStr")
    public java.util.List<String> getOptListStr() {
        return optListStr;
    }

    public StringlyTyped setOptListStr(final java.util.List<String> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optListStr = value;

        return this;
    }

    private java.util.List<String> optListOptStr;

    @JsonProperty("optListOptStr")
    public java.util.List<String> getOptListOptStr() {
        return optListOptStr;
    }

    public StringlyTyped setOptListOptStr(final java.util.List<String> value) {
        this.optListOptStr = value;

        return this;
    }

    private java.util.Set<String> setStr;

    @JsonProperty("setStr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getSetStr() {
        return setStr;
    }

    public StringlyTyped setSetStr(final java.util.Set<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setStr\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.setStr = value;

        return this;
    }

    private java.util.Set<String> setOptStr;

    @JsonProperty("setOptStr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getSetOptStr() {
        return setOptStr;
    }

    public StringlyTyped setSetOptStr(final java.util.Set<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setOptStr\" cannot be null!");
        this.setOptStr = value;

        return this;
    }

    private java.util.Set<String> optSetStr;

    @JsonProperty("optSetStr")
    public java.util.Set<String> getOptSetStr() {
        return optSetStr;
    }

    public StringlyTyped setOptSetStr(final java.util.Set<String> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);
        this.optSetStr = value;

        return this;
    }

    private java.util.Set<String> optSetOptStr;

    @JsonProperty("optSetOptStr")
    public java.util.Set<String> getOptSetOptStr() {
        return optSetOptStr;
    }

    public StringlyTyped setOptSetOptStr(final java.util.Set<String> value) {
        this.optSetOptStr = value;

        return this;
    }
}
