package com.dslplatform.compiler.client.api.model.JSONTest;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class RootlyTyped implements java.io.Serializable, AggregateRoot {
    public RootlyTyped() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.ID = 0;
        this.oneRootID = 0;
        this.arrRoot = new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];
        this.arrOptRoot = new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];
        this.ListRoot = new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>();
        this.ListOptRoot = new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>();
        this.setRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>();
        this.setOptRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>();
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
        final RootlyTyped other = (RootlyTyped) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "RootlyTyped(" + URI + ')' : "new RootlyTyped("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public RootlyTyped(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped oneRoot,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped optRoot,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] arrRoot,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] arrOptRoot,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] optArrRoot,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] optArrOptRoot,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> ListRoot,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> ListOptRoot,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optListRoot,
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optListOptRoot,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> setRoot,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> setOptRoot,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optSetRoot,
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optSetOptRoot) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setOneRoot(oneRoot);
        setOptRoot(optRoot);
        setArrRoot(arrRoot);
        setArrOptRoot(arrOptRoot);
        setOptArrRoot(optArrRoot);
        setOptArrOptRoot(optArrOptRoot);
        setListRoot(ListRoot);
        setListOptRoot(ListOptRoot);
        setOptListRoot(optListRoot);
        setOptListOptRoot(optListOptRoot);
        setSetRoot(setRoot);
        setSetOptRoot(setOptRoot);
        setOptSetRoot(optSetRoot);
        setOptSetOptRoot(optSetOptRoot);
    }

    @JsonCreator
    private RootlyTyped(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("oneRootURI") final String oneRootURI,
            @JsonProperty("oneRootID") final int oneRootID,
            @JsonProperty("optRootURI") final String optRootURI,
            @JsonProperty("optRootID") final Integer optRootID,
            @JsonProperty("arrRootURI") final String[] arrRootURI,
            @JsonProperty("arrOptRootURI") final String[] arrOptRootURI,
            @JsonProperty("optArrRootURI") final String[] optArrRootURI,
            @JsonProperty("optArrOptRootURI") final String[] optArrOptRootURI,
            @JsonProperty("ListRootURI") final java.util.List<String> ListRootURI,
            @JsonProperty("ListOptRootURI") final java.util.List<String> ListOptRootURI,
            @JsonProperty("optListRootURI") final java.util.List<String> optListRootURI,
            @JsonProperty("optListOptRootURI") final java.util.List<String> optListOptRootURI,
            @JsonProperty("setRootURI") final java.util.Set<String> setRootURI,
            @JsonProperty("setOptRootURI") final java.util.Set<String> setOptRootURI,
            @JsonProperty("optSetRootURI") final java.util.Set<String> optSetRootURI,
            @JsonProperty("optSetOptRootURI") final java.util.Set<String> optSetOptRootURI) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.oneRootURI = oneRootURI == null ? null : oneRootURI;
        this.oneRootID = oneRootID;
        this.optRootURI = optRootURI;
        this.optRootID = optRootID;
        this.arrRootURI = arrRootURI == null ? new String[0] : arrRootURI;
        this.arrOptRootURI = arrOptRootURI == null
                ? new String[0]
                : arrOptRootURI;
        this.optArrRootURI = optArrRootURI;
        this.optArrOptRootURI = optArrOptRootURI;
        this.ListRootURI = ListRootURI == null
                ? new java.util.ArrayList<String>()
                : ListRootURI;
        this.ListOptRootURI = ListOptRootURI == null
                ? new java.util.ArrayList<String>()
                : ListOptRootURI;
        this.optListRootURI = optListRootURI;
        this.optListOptRootURI = optListOptRootURI;
        this.setRootURI = setRootURI == null
                ? new java.util.HashSet<String>()
                : setRootURI;
        this.setOptRootURI = setOptRootURI == null
                ? new java.util.HashSet<String>()
                : setOptRootURI;
        this.optSetRootURI = optSetRootURI;
        this.optSetOptRootURI = optSetOptRootURI;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private RootlyTyped setID(final int value) {
        this.ID = value;

        return this;
    }

    public static RootlyTyped find(final String uri) throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static RootlyTyped find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class).read(RootlyTyped.class, uri)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<RootlyTyped> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<RootlyTyped> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class).find(RootlyTyped.class, uris)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<RootlyTyped> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<RootlyTyped> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<RootlyTyped> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<RootlyTyped> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(RootlyTyped.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<RootlyTyped> search(
            final Specification<RootlyTyped> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<RootlyTyped> search(
            final Specification<RootlyTyped> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<RootlyTyped> search(
            final Specification<RootlyTyped> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<RootlyTyped> search(
            final Specification<RootlyTyped> specification,
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
                    .resolve(DomainProxy.class).count(RootlyTyped.class).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(final Specification<RootlyTyped> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<RootlyTyped> specification,
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
            final com.dslplatform.compiler.client.api.model.JSONTest.RootlyTyped result) {
        this.URI = result.URI;

        this.oneRoot = result.oneRoot;
        this.oneRootURI = result.oneRootURI;
        this.oneRootID = result.oneRootID;
        this.optRoot = result.optRoot;
        this.optRootURI = result.optRootURI;
        this.optRootID = result.optRootID;
        this.arrRoot = result.arrRoot;
        this.arrRootURI = result.arrRootURI;
        this.arrOptRoot = result.arrOptRoot;
        this.arrOptRootURI = result.arrOptRootURI;
        this.optArrRoot = result.optArrRoot;
        this.optArrRootURI = result.optArrRootURI;
        this.optArrOptRoot = result.optArrOptRoot;
        this.optArrOptRootURI = result.optArrOptRootURI;
        this.ListRoot = result.ListRoot;
        this.ListRootURI = result.ListRootURI;
        this.ListOptRoot = result.ListOptRoot;
        this.ListOptRootURI = result.ListOptRootURI;
        this.optListRoot = result.optListRoot;
        this.optListRootURI = result.optListRootURI;
        this.optListOptRoot = result.optListOptRoot;
        this.optListOptRootURI = result.optListOptRootURI;
        this.setRoot = result.setRoot;
        this.setRootURI = result.setRootURI;
        this.setOptRoot = result.setOptRoot;
        this.setOptRootURI = result.setOptRootURI;
        this.optSetRoot = result.optSetRoot;
        this.optSetRootURI = result.optSetRootURI;
        this.optSetOptRoot = result.optSetOptRoot;
        this.optSetOptRootURI = result.optSetOptRootURI;
        this.ID = result.ID;
    }

    public RootlyTyped persist() throws java.io.IOException {
        if (this.getOneRootURI() == null) {
            throw new IllegalArgumentException(
                    "Cannot persist instance of 'com.dslplatform.compiler.client.api.model.JSONTest.RootlyTyped' because reference 'oneRoot' was not assigned");
        }
        final RootlyTyped result;
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

    public RootlyTyped delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(RootlyTyped.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped oneRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped getOneRoot()
            throws java.io.IOException {
        if (oneRoot != null && !oneRoot.getURI().equals(oneRootURI)
                || oneRoot == null && oneRootURI != null)
            try {
                oneRoot = _crudProxy
                        .read(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                oneRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return oneRoot;
    }

    public RootlyTyped setOneRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneRoot\" cannot be null!");

        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"JSONTest.StringlyTyped\" for property \"oneRoot\" must be persisted before it's assigned");
        this.oneRoot = value;

        this.oneRootURI = value.getURI();

        this.oneRootID = value.getID();
        return this;
    }

    private String oneRootURI;

    @JsonProperty("oneRootURI")
    public String getOneRootURI() {
        return this.oneRootURI;
    }

    private int oneRootID;

    @JsonProperty("oneRootID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getOneRootID() {
        return oneRootID;
    }

    private RootlyTyped setOneRootID(final int value) {
        this.oneRootID = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped optRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped getOptRoot()
            throws java.io.IOException {
        if (optRoot != null && !optRoot.getURI().equals(optRootURI)
                || optRoot == null && optRootURI != null)
            try {
                optRoot = _crudProxy
                        .read(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                optRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        if (this.optRootURI == null && this.optRoot != null)
            this.optRoot = null;
        return optRoot;
    }

    public RootlyTyped setOptRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped value) {
        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"JSONTest.StringlyTyped\" for property \"optRoot\" must be persisted before it's assigned");
        this.optRoot = value;

        this.optRootURI = value != null ? value.getURI() : null;

        if (value == null && this.optRootID != null) {
            this.optRootID = null;
        } else if (value != null) {
            this.optRootID = value.getID();
        }
        return this;
    }

    private String optRootURI;

    @JsonProperty("optRootURI")
    public String getOptRootURI() {
        return this.optRootURI;
    }

    private Integer optRootID;

    @JsonProperty("optRootID")
    public Integer getOptRootID() {
        return optRootID;
    }

    private RootlyTyped setOptRootID(final Integer value) {
        this.optRootID = value;

        return this;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] arrRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] getArrRoot()
            throws java.io.IOException {
        if (arrRootURI == null || arrRootURI.length == 0)
            return new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];

        if (arrRootURI != null
                && (arrRoot == null || arrRoot.length != arrRootURI.length))
            try {
                arrRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                arrRootURI)
                        .get()
                        .toArray(
                                new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[arrRootURI.length]);
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return arrRoot;
    }

    public RootlyTyped setArrRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrRoot\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"arrRoot\" must be persisted before it's assigned");
        }
        this.arrRoot = value;

        this.arrRootURI = new String[value.length];
        int i = 0;
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.arrRootURI[i] = it.getURI();
            i++;
        }
        return this;
    }

    private String[] arrRootURI;

    @JsonProperty("arrRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String[] getArrRootURI() {
        return this.arrRootURI;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] arrOptRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] getArrOptRoot()
            throws java.io.IOException {
        if (arrOptRootURI == null || arrOptRootURI.length == 0)
            return new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];

        if (arrOptRootURI != null
                && (arrOptRoot == null || arrOptRoot.length != arrOptRootURI.length))
            try {
                arrOptRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                arrOptRootURI)
                        .get()
                        .toArray(
                                new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[arrOptRootURI.length]);
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return arrOptRoot;
    }

    public RootlyTyped setArrOptRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"arrOptRoot\" cannot be null!");

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"arrOptRoot\" must be persisted before it's assigned");
        }
        this.arrOptRoot = value;

        this.arrOptRootURI = new String[value.length];
        int i = 0;
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.arrOptRootURI[i] = it.getURI();
            i++;
        }
        return this;
    }

    private String[] arrOptRootURI;

    @JsonProperty("arrOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String[] getArrOptRootURI() {
        return this.arrOptRootURI;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] optArrRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] getOptArrRoot()
            throws java.io.IOException {
        if (this.optArrRootURI == null && this.optArrRoot != null)
            this.optArrRoot = null;

        if (optArrRootURI == null || optArrRootURI.length == 0)
            return new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];

        if (optArrRootURI != null
                && (optArrRoot == null || optArrRoot.length != optArrRootURI.length))
            try {
                optArrRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                optArrRootURI)
                        .get()
                        .toArray(
                                new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[optArrRootURI.length]);
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optArrRoot;
    }

    public RootlyTyped setOptArrRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optArrRoot\" must be persisted before it's assigned");
        }
        this.optArrRoot = value;

        if (value != null) {
            this.optArrRootURI = new String[value.length];
            int i = 0;
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optArrRootURI[i] = it.getURI();
                i++;
            }
        } else this.optArrRootURI = null;
        return this;
    }

    private String[] optArrRootURI;

    @JsonProperty("optArrRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String[] getOptArrRootURI() {
        return this.optArrRootURI;
    }

    private com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] optArrOptRoot;

    @JsonIgnore
    public com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] getOptArrOptRoot()
            throws java.io.IOException {
        if (this.optArrOptRootURI == null && this.optArrOptRoot != null)
            this.optArrOptRoot = null;

        if (optArrOptRootURI == null || optArrOptRootURI.length == 0)
            return new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[0];

        if (optArrOptRootURI != null
                && (optArrOptRoot == null || optArrOptRoot.length != optArrOptRootURI.length))
            try {
                optArrOptRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                optArrOptRootURI)
                        .get()
                        .toArray(
                                new com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[optArrOptRootURI.length]);
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optArrOptRoot;
    }

    public RootlyTyped setOptArrOptRoot(
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped[] value) {
        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optArrOptRoot\" must be persisted before it's assigned");
        }
        this.optArrOptRoot = value;

        if (value != null) {
            this.optArrOptRootURI = new String[value.length];
            int i = 0;
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optArrOptRootURI[i] = it.getURI();
                i++;
            }
        } else this.optArrOptRootURI = null;
        return this;
    }

    private String[] optArrOptRootURI;

    @JsonProperty("optArrOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String[] getOptArrOptRootURI() {
        return this.optArrOptRootURI;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> ListRoot;

    @JsonIgnore
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getListRoot()
            throws java.io.IOException {
        if (ListRootURI != null
                && (ListRoot == null || ListRoot.size() != ListRootURI.size()))
            try {
                ListRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                ListRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return ListRoot;
    }

    public RootlyTyped setListRoot(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"ListRoot\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"ListRoot\" must be persisted before it's assigned");
        }
        this.ListRoot = value;

        this.ListRootURI = new java.util.ArrayList<String>(value.size());
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.ListRootURI.add(it.getURI());
        }
        return this;
    }

    private java.util.List<String> ListRootURI;

    @JsonProperty("ListRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getListRootURI() {
        return this.ListRootURI;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> ListOptRoot;

    @JsonIgnore
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getListOptRoot()
            throws java.io.IOException {
        if (ListOptRootURI != null
                && (ListOptRoot == null || ListOptRoot.size() != ListOptRootURI
                        .size()))
            try {
                ListOptRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                ListOptRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return ListOptRoot;
    }

    public RootlyTyped setListOptRoot(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"ListOptRoot\" cannot be null!");

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"ListOptRoot\" must be persisted before it's assigned");
        }
        this.ListOptRoot = value;

        this.ListOptRootURI = new java.util.ArrayList<String>(value.size());
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.ListOptRootURI.add(it.getURI());
        }
        return this;
    }

    private java.util.List<String> ListOptRootURI;

    @JsonProperty("ListOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getListOptRootURI() {
        return this.ListOptRootURI;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optListRoot;

    @JsonIgnore
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getOptListRoot()
            throws java.io.IOException {
        if (this.optListRootURI == null && this.optListRoot != null)
            this.optListRoot = null;

        if (optListRootURI != null
                && (optListRoot == null || optListRoot.size() != optListRootURI
                        .size()))
            try {
                optListRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                optListRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optListRoot;
    }

    public RootlyTyped setOptListRoot(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optListRoot\" must be persisted before it's assigned");
        }
        this.optListRoot = value;

        if (value != null) {
            this.optListRootURI = new java.util.ArrayList<String>(value.size());
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optListRootURI.add(it.getURI());
            }
        } else this.optListRootURI = null;
        return this;
    }

    private java.util.List<String> optListRootURI;

    @JsonProperty("optListRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getOptListRootURI() {
        return this.optListRootURI;
    }

    private java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optListOptRoot;

    @JsonIgnore
    public java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getOptListOptRoot()
            throws java.io.IOException {
        if (this.optListOptRootURI == null && this.optListOptRoot != null)
            this.optListOptRoot = null;

        if (optListOptRootURI != null
                && (optListOptRoot == null || optListOptRoot.size() != optListOptRootURI
                        .size()))
            try {
                optListOptRoot = _domainProxy
                        .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                optListOptRootURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optListOptRoot;
    }

    public RootlyTyped setOptListOptRoot(
            final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optListOptRoot\" must be persisted before it's assigned");
        }
        this.optListOptRoot = value;

        if (value != null) {
            this.optListOptRootURI = new java.util.ArrayList<String>(
                    value.size());
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optListOptRootURI.add(it.getURI());
            }
        } else this.optListOptRootURI = null;
        return this;
    }

    private java.util.List<String> optListOptRootURI;

    @JsonProperty("optListOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getOptListOptRootURI() {
        return this.optListOptRootURI;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> setRoot;

    @JsonIgnore
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getSetRoot()
            throws java.io.IOException {
        if (setRootURI != null
                && (setRoot == null || setRoot.size() != setRootURI.size()))
            try {
                setRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>(
                        _domainProxy
                                .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                        setRootURI).get());
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return setRoot;
    }

    public RootlyTyped setSetRoot(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setRoot\" cannot be null!");
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"setRoot\" must be persisted before it's assigned");
        }
        this.setRoot = value;

        this.setRootURI = new java.util.HashSet<String>(value.size());
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.setRootURI.add(it.getURI());
        }
        return this;
    }

    private java.util.Set<String> setRootURI;

    @JsonProperty("setRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getSetRootURI() {
        return this.setRootURI;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> setOptRoot;

    @JsonIgnore
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getSetOptRoot()
            throws java.io.IOException {
        if (setOptRootURI != null
                && (setOptRoot == null || setOptRoot.size() != setOptRootURI
                        .size()))
            try {
                setOptRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>(
                        _domainProxy
                                .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                        setOptRootURI).get());
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return setOptRoot;
    }

    public RootlyTyped setSetOptRoot(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"setOptRoot\" cannot be null!");

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"setOptRoot\" must be persisted before it's assigned");
        }
        this.setOptRoot = value;

        this.setOptRootURI = new java.util.HashSet<String>(value.size());
        for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
            this.setOptRootURI.add(it.getURI());
        }
        return this;
    }

    private java.util.Set<String> setOptRootURI;

    @JsonProperty("setOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getSetOptRootURI() {
        return this.setOptRootURI;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optSetRoot;

    @JsonIgnore
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getOptSetRoot()
            throws java.io.IOException {
        if (this.optSetRootURI == null && this.optSetRoot != null)
            this.optSetRoot = null;

        if (optSetRootURI != null
                && (optSetRoot == null || optSetRoot.size() != optSetRootURI
                        .size()))
            try {
                optSetRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>(
                        _domainProxy
                                .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                        optSetRootURI).get());
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optSetRoot;
    }

    public RootlyTyped setOptSetRoot(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        com.dslplatform.compiler.client.api.model.Guards.checkNulls(value);

        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optSetRoot\" must be persisted before it's assigned");
        }
        this.optSetRoot = value;

        if (value != null) {
            this.optSetRootURI = new java.util.HashSet<String>(value.size());
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optSetRootURI.add(it.getURI());
            }
        } else this.optSetRootURI = null;
        return this;
    }

    private java.util.Set<String> optSetRootURI;

    @JsonProperty("optSetRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getOptSetRootURI() {
        return this.optSetRootURI;
    }

    private java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> optSetOptRoot;

    @JsonIgnore
    public java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> getOptSetOptRoot()
            throws java.io.IOException {
        if (this.optSetOptRootURI == null && this.optSetOptRoot != null)
            this.optSetOptRoot = null;

        if (optSetOptRootURI != null
                && (optSetOptRoot == null || optSetOptRoot.size() != optSetOptRootURI
                        .size()))
            try {
                optSetOptRoot = new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped>(
                        _domainProxy
                                .find(com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                                        optSetOptRootURI).get());
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return optSetOptRoot;
    }

    public RootlyTyped setOptSetOptRoot(
            final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> value) {
        if (value != null) {
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"JSONTest.StringlyTyped\" for property \"optSetOptRoot\" must be persisted before it's assigned");
        }
        this.optSetOptRoot = value;

        if (value != null) {
            this.optSetOptRootURI = new java.util.HashSet<String>(value.size());
            for (final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped it : value) {
                this.optSetOptRootURI.add(it.getURI());
            }
        } else this.optSetOptRootURI = null;
        return this;
    }

    private java.util.Set<String> optSetOptRootURI;

    @JsonProperty("optSetOptRootURI")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getOptSetOptRootURI() {
        return this.optSetOptRootURI;
    }
}
